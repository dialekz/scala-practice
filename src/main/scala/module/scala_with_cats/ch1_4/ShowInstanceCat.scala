package module.scala_with_cats.ch1_4

import cats.Show
import module.scala_with_cats.ch1_3.Cat

object ShowInstanceCat {
  implicit val showInstanceCat: Show[Cat] = Show.show(v => s"${v.name} is a ${v.age} year-old ${v.color} cat")
}
