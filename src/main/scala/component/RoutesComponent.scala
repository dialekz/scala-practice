package component

import routes.{AbstractRoute, TestRoute}

case class RoutesComponent(routeBeans: List[AbstractRoute])

object RoutesComponent {
  lazy val testRoute: TestRoute = new TestRoute()

  def apply(): RoutesComponent =
    RoutesComponent(
      List(testRoute)
    )
}
