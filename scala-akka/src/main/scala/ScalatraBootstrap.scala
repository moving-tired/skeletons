import javax.servlet.ServletContext
import org.andrey.justo.account.rest.{MessagesServiceSwagger, ResourcesApp}
import org.moving.tired.messages.rest.{MessagesServiceSwagger, ResourcesApp}
import org.moving.tired.messages.rest.v1.MessageController
import org.scalatra.LifeCycle

class ScalatraBootstrap extends LifeCycle {
  implicit val swagger = new MessagesServiceSwagger

  override def init(context: ServletContext) {
    try {
      context mount (new MessageController, "/api/v1/messages")
      context mount (new ResourcesApp, "/api-docs")
    } catch {
      case e: Throwable => e.printStackTrace()
    }
  }

}