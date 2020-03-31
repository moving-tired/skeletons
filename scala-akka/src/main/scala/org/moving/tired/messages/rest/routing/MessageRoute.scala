package org.moving.tired.messages.rest.routing

import akka.actor.ActorSystem
import akka.http.scaladsl.server.{Route, RouteResult}
import org.moving.tired.messages.dao.MessageDAO
import akka.http.scaladsl.server.Directives._
import org.moving.tired.messages.actor.MessageManager
import org.moving.tired.messages.actor.MessageManager.{AddMessage, MessageEntry}
import org.moving.tired.messages.model.Message

import scala.concurrent.Promise

class MessageRoute(repository: MessageDAO)(implicit system: ActorSystem) {

  val route: Route = pathPrefix("messages") {
    path(Segment) { space =>
      path(Segment) { key =>
        get {
          headerValueByName("Accept-Language") { locale =>
            toEventLoop(MessageManager.GetMessage(key, space, locale))
          }
        }
      }
    } ~
      pathEndOrSingleSlash {
        entity(as[MessageEntry]) { entry =>
          post {
            toEventLoop(MessageManager.AddMessage(entry))
          } ~
            put {
              toEventLoop(MessageManager.AddMessage(entry))
            }
        }
      }
  }

  private def toEventLoop(request: MessageManager.MessageRequest): Route = ctx => {
    val p = Promise[RouteResult]
    val target = system.actorOf(MessageManager.props(repository, ctx, p))
    target ! request
    p.future
  }

}
