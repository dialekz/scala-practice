package module.`scala-with-cats`.ch2_3

import cats.{Monoid, Semigroup}

object BooleanMonoid {
  val BooleanAndMonoid: Monoid[Boolean] = Monoid.instance[Boolean](emptyValue = true, _ & _)
  val BooleanOrMonoid: Monoid[Boolean] = Monoid.instance[Boolean](emptyValue = false, _ | _)
  val BooleanXorSemigroup: Semigroup[Boolean] = Semigroup.instance[Boolean](_ ^ _)
  val BooleanEqSemigroup: Semigroup[Boolean] = Semigroup.instance[Boolean](_ == _)
}
