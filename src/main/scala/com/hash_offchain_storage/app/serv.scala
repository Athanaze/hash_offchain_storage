package com.hash_offchain_storage.app

import org.scalatra._
import org.json4s.{DefaultFormats, Formats}
import org.scalatra.json._
import upickle.default._

import java.util.Calendar
import java.io.{BufferedOutputStream, FileOutputStream, FileInputStream, BufferedInputStream, File}
import java.nio.file.{Files, Path, Paths};

class serv extends ScalatraServlet with JacksonJsonSupport{
  val SNAPSHOT_PATH = "snapshots/"

  // Before every action runs, set the content type to be in JSON format.
  protected implicit lazy val jsonFormats: Formats = DefaultFormats
  
  before() {
    contentType = formats("json")
  }
  
  def getListOfFiles(dir: String):List[File] = {
    val d = new File(dir)
    if (d.exists && d.isDirectory) {
        d.listFiles.filter(_.isFile).toList
    } else {
        List[File]()
    }
  }

  var dataMap: Map[String, String] = latestSnapshot match {
    case None => Map("someKey"->"someValue")
    case Some(p) => getMapFromPath(p)
  }

  def getMapFromPath(p: String):Map[String, String] = {
    val byteArray: Array[Byte] = Files.readAllBytes(Paths.get(p))
    readBinary[Map[String, String]](byteArray)
  }

  def timestamp: String = Calendar.getInstance().getTimeInMillis().toString
  
  def latestSnapshot: Option[String] = {
    val l = getListOfFiles(SNAPSHOT_PATH)
    l.isEmpty match {
      case true => None
      case false => Some(SNAPSHOT_PATH+l.map(f=>f.getName()).sorted.reverse.head)
    }
  } 

  get("/add/:hash") {
    this.dataMap = this.dataMap + (params("hash") -> "Some json value")
    params("hash")
  }

  get("/get/:hash") {
    dataMap.get(params("hash")) match {
      case Some(e) => e
      case None => "No content with hash : " +params("hash")+ " found."
    } 
  }

  get("/getAll") {
    this.dataMap
  }

  get("/save") {
    val bos = new BufferedOutputStream(new FileOutputStream(SNAPSHOT_PATH+this.timestamp))
    bos.write(writeBinary(dataMap))
    bos.close()
    "Snapshot saved"   
  }

  get("/restore") {
    latestSnapshot match {
      case Some(p) => {
        this.dataMap = getMapFromPath(p)
        "Restored"
      }
      case None => {
        "No snapshot found"
      }
    }
  }
}
