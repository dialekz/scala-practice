package component

import akka.http.scaladsl.server.{Directives, Route}
import routes.{AbstractRoute, TestRoute}

class RoutesComponent(routeBeans: List[AbstractRoute]) {

  def this() { this(List(RoutesComponent.testRoute)) }

  def concatRoute(): Route = Directives.concat(routeBeans.flatMap(_.routes): _*)
}

object RoutesComponent {
  lazy val testRoute: TestRoute = new TestRoute()
}
