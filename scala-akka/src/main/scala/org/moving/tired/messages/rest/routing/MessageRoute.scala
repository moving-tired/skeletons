package org.moving.tired.messages.rest.routing

import akka.actor.ActorSystem
import akka.http.scaladsl.server.Route
import org.moving.tired.messages.dao.MessageDAO
import akka.http.scaladsl.server.Directives._
import org.moving.tired.messages.model.Message

class MessageRoute(repository: MessageDAO)(implicit system: ActorSystem) {

  val route: Route = pathPrefix("messages") {
    path(String) { key =>
      get {

      } ~
        delete {
        }
    } ~
      pathEndOrSingleSlash {
        entity(as[Message]) { book =>
          post {

          } ~
            put {
            }
        }
      }
  }

}
