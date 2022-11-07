
package layouts.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml

object default extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[String,String,Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(title: String, headline: String)(body: Html):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""<html>
  <head>
    <title>"""),_display_(/*4.13*/title),format.raw/*4.18*/("""</title>
  </head>
  <body>
    <h1>"""),_display_(/*7.10*/headline),format.raw/*7.18*/("""</h1>
    """),_display_(/*8.6*/body),format.raw/*8.10*/("""
  """),format.raw/*9.3*/("""</body>
</html>"""))
      }
    }
  }

  def render(title:String,headline:String,body:Html): play.twirl.api.HtmlFormat.Appendable = apply(title,headline)(body)

  def f:((String,String) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (title,headline) => (body) => apply(title,headline)(body)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: src/main/twirl/layouts/default.scala.html
                  HASH: ab59b4dddbafceb665de3cb0f7ce9f2c8dc5df51
                  MATRIX: 582->1|721->47|775->75|800->80|863->117|891->125|927->136|951->140|980->143
                  LINES: 14->1|19->2|21->4|21->4|24->7|24->7|25->8|25->8|26->9
                  -- GENERATED --
              */
          