package routes

import akka.http.scaladsl.server.{Directive, Route}

trait AbstractRoute {
  def routes: List[Route]
}
