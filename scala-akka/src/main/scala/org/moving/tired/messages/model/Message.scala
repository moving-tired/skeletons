package org.moving.tired.messages.model

import java.time.LocalDateTime

case class Message(key: String, space: String, translated: String, locale: String,
                   createdAt: LocalDateTime = LocalDateTime.now(),
                   updatedAt: LocalDateTime = LocalDateTime.now())