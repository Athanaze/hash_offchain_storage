package com.hash_offchain_storage.app

import org.scalatra.test.scalatest._

class servTests extends ScalatraFunSuite {

  addServlet(classOf[serv], "/*")

  test("GET / on serv should return status 200") {
    get("/") {
      status should equal (200)
    }
  }

}
