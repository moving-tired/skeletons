package org.moving.tired.messages.actor

import akka.actor.{Actor, ActorLogging}
import com.fasterxml.jackson.databind.ser.Serializers
import org.moving.tired.messages.rest.routing.PerRequest

import scala.concurrent.ExecutionContextExecutor
import scala.concurrent.duration._

trait PerRequestActor
  extends Actor
    with ActorLogging
    with Serializers
    with PerRequest {

  context.setReceiveTimeout(60 seconds)

  implicit val ec: ExecutionContextExecutor = context.dispatcher

}
