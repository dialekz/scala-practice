package module.`scala-with-cats`.ch1_3

import module.`scala-with-cats`.ch1_3.Printable

import scala.language.implicitConversions

object PrintableSyntax {
  implicit final class PrintableOps[T](v: T) {
    def format(implicit p: Printable[T]): String = p.format(v)
    def print(implicit p: Printable[T]): Unit = println(p.format(v))
  }
}
