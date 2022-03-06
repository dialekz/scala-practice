import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives
import component.RoutesComponent

object AppStarter extends App {
  implicit val system: ActorSystem[Nothing] = ActorSystem(Behaviors.empty, "det-jobbar-service")

  val routesComponent = RoutesComponent()
  val concatRoute = Directives.concat(routesComponent.routeBeans.flatMap(_.routes):_*)

  val bindingFuture = Http()
    .newServerAt("localhost", 8080)
    .bind(concatRoute)
}
