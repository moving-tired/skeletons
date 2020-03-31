package org.moving.tired.messages.actor

import org.moving.tired.messages.actor.MessageManager.MessageEntry
import org.moving.tired.messages.dao.MessageDAO
import org.moving.tired.messages.model.Message

import scala.concurrent.Future
import scala.util.{Failure, Success, Try}

trait MessageCreator {

  this: PerRequestActor =>

  def dao: MessageDAO

  def add(entry: MessageEntry): Unit = {
    dao.insert(Message(key = entry.key, space = entry.space, locale = entry.locale, translated = entry.text)).onComplete {
      case Success(rows) => if (rows > 0) complete("", 201) else complete("Failed to insert message")
      case _ => complete("Failed to insert message")
    }
  }

}
