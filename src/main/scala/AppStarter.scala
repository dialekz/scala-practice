import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import component.{ConfigComponent, RoutesComponent, ServerComponent}

import scala.concurrent.{ExecutionContext, ExecutionContextExecutor}

object AppStarter extends App {
  implicit val system: ActorSystem[Nothing] = ActorSystem(Behaviors.empty, "det-jobbar-service")
  implicit val ec: ExecutionContextExecutor = ExecutionContext.global

  for {
    config <- new ConfigComponent().load()
    routesComponent = new RoutesComponent()
    serverComponent = new ServerComponent(config.server, routesComponent.concatRoute())
    _ = serverComponent.startNewServer()
  } yield ()
}
