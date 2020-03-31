package org.moving.tired.messages.dao

import org.moving.tired.messages.model.Message
import slick.jdbc.GetResult
import slick.jdbc.PostgresProfile.api._

import scala.concurrent.Future

class MessageDAO(private val db: Database) {

  implicit val getMessageResult: GetResult[Message] = GetResult(r => Message(r.<<, r.<<, r.<<, r.<<, r.<<, r.<<))

  def insert(message: Message): Future[Int] = db.run(
    sqlu"insert into messages(key, space, locale, translated) values (${message.key}, ${message.space}, ${message.locale}, ${message.translated})"
  )

  def find(key: String, space: String, locale: String): Future[Option[Message]] =
    db.run(
      sql"""
          SELECT key, space, locale, translated, created_at, updated_at FROM messages
          WHERE key = $key AND space = $space AND locale = $locale
        """.as[Message].headOption
    )
}
