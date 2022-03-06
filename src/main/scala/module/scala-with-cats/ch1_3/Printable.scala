package module.`scala-with-cats`.ch1_3

trait Printable[T] {
  def format(v: T): String
}
