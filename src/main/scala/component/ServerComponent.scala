package component

import akka.actor.typed.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Route
import component.ConfigComponent.ServerConfig

import scala.concurrent.{ExecutionContextExecutor, Future}

class ServerComponent(config: ServerConfig, route: Route)(
  implicit
  val system: ActorSystem[Nothing],
  val ec: ExecutionContextExecutor
) {

  def startNewServer(): Future[Http.ServerBinding] =
    Http().newServerAt(config.url, config.port).bind(route)
}
