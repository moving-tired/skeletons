import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import com.typesafe.config.{Config, ConfigFactory}
import org.moving.tired.messages.dao.MessageDAO
import org.moving.tired.messages.rest.routing.MessageRoute
import org.slf4j.LoggerFactory

import scala.concurrent.ExecutionContext
import slick.jdbc.PostgresProfile.api._

object AkkaBootstrap extends App {
  
  val config: Config = ConfigFactory.load()
  val actorSystemName = config.getString("akka.system.name")

  implicit val system: ActorSystem = ActorSystem(actorSystemName)
  implicit val materializer: ActorMaterializer = ActorMaterializer()
  implicit val executionContext: ExecutionContext = system.dispatcher

  val log = LoggerFactory.getLogger(AkkaBootstrap.getClass)

  val db = Database.forConfig("database.postgre")
  val messageRepository: MessageDAO = new MessageDAO(db)

  val restRoutes = new MessageRoute(messageRepository)

  val host = config.getString("application.host")
  val port = config.getInt("application.port")
  Http().bindAndHandle(restRoutes.route, host, port)

  log.info("{} ActorSystem started", actorSystemName)

  system.registerOnTermination {
    log.info("Terminating {} ActorSystem", actorSystemName)
  }

}