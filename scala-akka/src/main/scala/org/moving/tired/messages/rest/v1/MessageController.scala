package org.moving.tired.messages.rest.v1

import org.json4s.{DefaultFormats, Formats}
import org.scalatra.ScalatraServlet
import org.scalatra.json.NativeJsonSupport
import org.scalatra.swagger._

class MessageController(implicit val swagger: Swagger) extends ScalatraServlet with SwaggerSupport with NativeJsonSupport {

  override protected def applicationDescription: String = "Api for messages"

  protected implicit val jsonFormats: Formats = DefaultFormats

  // Before every action runs, set the content type to be in JSON format.
  before() {
    contentType = formats("json")
  }

  get(
    "/:space/:key",
    operation(
      apiOperation[Void]("getMessage")
        summary "Get translated information"
        parameters
        pathParam[String]("space").description("Application space")),
    pathParam[String]("key").description("Message key")) {
    //    Some(Account(params("id"), params("id").toInt))
  }

  post(
    "/:space/messages",
    operation(
      apiOperation[Void]("addMessage")
        summary "Add message"
        parameters
        pathParam[String]("space").description("Space"))) {
  }

}
