package module.scala_with_cats.ch1_3

trait Printable[T] {
  def format(v: T): String
}
