package module.`scala-with-cats-practice`

object Chapter1PrintableExercise

trait Printable[T] {
  def format(v: T): String
}

object Printable {
  def format[T](v: T)(implicit printable: Printable[T]): String = printable.format(v)
  def print[T](v: T)(implicit printable: Printable[T]): Unit = println(printable.format(v))
}

object PrintableInstances {
  implicit object PrintableString extends Printable[String] {
    override def format(v: String): String = v
  }
  implicit object PrintableInt extends Printable[Int] {
    override def format(v: Int): String = v.toString
  }
}
