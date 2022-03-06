package module.`scala-with-cats`.ch1_5

import cats.Eq
import module.`scala-with-cats`.ch1_3.Cat

object EqInstanceCat {
  implicit val eqInstanceCat: Eq[Cat] = Eq.instance(_ == _)
}
