package org.moving.tired.messages.actor

import org.moving.tired.messages.dao.MessageDAO
import org.moving.tired.messages.model.Message

import scala.concurrent.Future
import scala.util.{Failure, Success}

trait MessageGetter {

  this: PerRequestActor =>

  def dao: MessageDAO

  def get(key: String, space: String, locale: String): Unit = {
    dao.find(key, space, locale).onComplete {
      case Success(message) => message.fold(complete("No Message found", 404))(m => complete(m.translated, 200))
      case Failure(_) => complete("Couldn't get messages")
    }
  }

}
