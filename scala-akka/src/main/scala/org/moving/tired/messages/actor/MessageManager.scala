package org.moving.tired.messages.actor

import akka.actor.Props
import akka.http.scaladsl.server.{RequestContext, RouteResult}
import org.moving.tired.messages.actor.MessageManager.{AddMessage, GetMessage, MessageRequest}
import org.moving.tired.messages.dao.MessageDAO

import scala.concurrent.Promise


object MessageManager {

  def props(dao: MessageDAO, requestContext: RequestContext,
            promise: Promise[RouteResult]): Props =
    Props(new MessageManager(dao, requestContext, promise))

  sealed trait MessageRequest

  case class MessageEntry(key: String, space: String, locale: String, text: String) extends MessageRequest

  case class AddMessage(message: MessageEntry) extends MessageRequest

  case class GetMessage(key: String, space: String, locale: String) extends MessageRequest

}

class MessageManager(val dao: MessageDAO, val requestContext: RequestContext, val promise: Promise[RouteResult])
  extends PerRequestActor
    with MessageGetter
    with MessageCreator {

  override def receive: Receive = {
    case request: MessageRequest =>
      request match {
        case AddMessage(m) => add(m)
        case GetMessage(key, space, locale) => get(key, space, locale)
      }
  }
}