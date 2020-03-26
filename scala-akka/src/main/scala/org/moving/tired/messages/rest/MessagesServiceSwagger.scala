package org.moving.tired.messages.rest

import org.scalatra.ScalatraServlet
import org.scalatra.swagger.{ApiInfo, NativeSwaggerBase, Swagger}

class MessagesServiceSwagger extends Swagger(
  "2.0",
  "1",
  ApiInfo("The i18n messages api", "", "", "", "", ""))

class ResourcesApp(implicit val swagger: Swagger) extends ScalatraServlet with NativeSwaggerBase