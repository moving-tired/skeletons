package org.moving.tired.messages.actor

import org.moving.tired.messages.dao.MessageDAO
import org.moving.tired.messages.model.Message

import scala.concurrent.Future

trait MessageGetter {

  this: PerRequestActor =>

  def dao: MessageDAO

  def get(name: String, space: String, locale: String): Future[Option[Message]] = {
    dao.find(name, space, locale)
  }

}
