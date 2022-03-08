package module.scala_with_cats.ch1_3

import module.scala_with_cats.ch1_3.Printable

object PrintableInstances {
  implicit object PrintableString extends Printable[String] {
    override def format(v: String): String = v
  }
  implicit object PrintableInt extends Printable[Int] {
    override def format(v: Int): String = v.toString
  }
  implicit object PrintableCat extends Printable[Cat] {
    override def format(v: Cat): String = s"${v.name} is a ${v.age} year-old ${v.color} cat"
  }
}
