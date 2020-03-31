package org.moving.tired.messages.rest.routing

import de.heikoseeberger.akkahttpjson4s.Json4sSupport
import org.json4s.{NoTypeHints, jackson}
import org.json4s.jackson.Serialization

trait Serializers extends Json4sSupport {

  implicit val serialization = jackson.Serialization

  implicit val formats = Serialization.formats(NoTypeHints)

}
