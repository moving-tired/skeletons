package org.moving.tired.messages.actor

import akka.actor.{Actor, ActorLogging}
import org.moving.tired.messages.rest.routing.{PerRequest, Serializers}

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
