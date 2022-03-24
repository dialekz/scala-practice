package component

import akka.http.scaladsl.server.{Directives, Route}
import routes.{AbstractRoute, TestRoute}

class RoutesComponent(routeBeans: List[AbstractRoute]) {

  def concatRoute(): Route = Directives.concat(routeBeans.flatMap(_.routes): _*)
}

object RoutesComponent {
  lazy val testRoute: TestRoute = new TestRoute()

  def apply(): RoutesComponent =
    new RoutesComponent(
      List(testRoute)
    )
}
