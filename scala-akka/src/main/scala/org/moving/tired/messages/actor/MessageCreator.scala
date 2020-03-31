package org.moving.tired.messages.actor

import org.moving.tired.messages.dao.MessageDAO
import org.moving.tired.messages.model.Message

import scala.concurrent.Future
import scala.util.{Failure, Success, Try}

trait MessageCreator {

  this: PerRequestActor =>

  def dao: MessageDAO

  def add(name: String, space: String, locale: String, text: String): Unit = {
    dao.insert(Message(key = name, space = space, locale = locale, translated = text)).onComplete {
      case Success(rows) => if (rows > 0) complete("", 201) else complete("Failed to insert message")
      case _ => complete("Failed to insert message")
    }
  }

}
