package module.scala_with_cats.ch2_3

import cats.{Monoid, Semigroup}
import module.scala_with_cats.ch2_3.BooleanMonoid._
import org.scalatest.funsuite.AnyFunSuite

class BooleanMonoidTest extends AnyFunSuite {

  import BooleanMonoidTest._

  test("BooleanAndMonoid should be correct as monoid") {
    val expected = List(false, false, false, true)
    testCombineMethod(expected, BooleanAndMonoid)
    testCombineAssociative(BooleanAndMonoid)
    testCombineWithEmpty(BooleanAndMonoid)
  }

  test("BooleanOrMonoid should be correct as monoid") {
    val expected = List(false, true, true, true)
    testCombineMethod(expected, BooleanOrMonoid)
    testCombineAssociative(BooleanOrMonoid)
    testCombineWithEmpty(BooleanOrMonoid)
  }

  test("BooleanXorSemigroup should work with combine") {
    val expected = List(false, true, true, false)
    testCombineMethod(expected, BooleanXorSemigroup)
    testCombineAssociative(BooleanXorSemigroup)
  }

  test("BooleanEqSemigroup should work with combine") {
    val expected = List(true, false, false, true)
    testCombineMethod(expected, BooleanEqSemigroup)
    testCombineAssociative(BooleanEqSemigroup)
  }
}

object BooleanMonoidTest {

  val AList = List(false, true)
  val BList = List(false, true)

  private def testCombineMethod(expected: List[Boolean], sg: Semigroup[Boolean]): Unit = {
    val result = for {
      a <- AList
      b <- BList
    } yield sg.combine(a, b)
    assert(expected == result)
  }

  private def testCombineAssociative(sg: Semigroup[Boolean]): Unit = {
    val result = for {
      a <- AList
      b <- BList
      c <- AList
    } yield (
      sg.combine(sg.combine(a, b), c),
      sg.combine(a, sg.combine(b, c))
    )
    assert(result.forall(v => v._1 == v._2))
  }

  private def testCombineWithEmpty(monoid: Monoid[Boolean]): Unit = {
    val result = for {
      a <- AList
    } yield monoid.combine(a, monoid.empty)
    assert(AList == result)
  }
}
