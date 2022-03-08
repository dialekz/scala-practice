package module.scala_with_cats.ch2_4

import cats.{Monoid, Semigroup}
import module.scala_with_cats.ch2_4.SetMonoid._
import org.scalatest.funsuite.AnyFunSuite

class SetMonoidTest extends AnyFunSuite {

  import SetMonoidTest._

  test("SetConcatMonoid should have correct associative combine and empty element") {
    val expected = Set(1, 2, 3, 4, 5, 6, 7)
    testCombineMethod(expected, SetConcatMonoid)
    testCombineAssociative(SetConcatMonoid)
    testCombineWithEmpty(SetConcatMonoid)
  }

  test("SetZipAllInListMonoid should have correct associative combine and empty element") {
    val expected = Set(List(1, 4), List(2, 5), List(3, 6), 7)
    testCombineMethod(expected, SetZipAllInListMonoid)
    testCombineAssociative(SetZipAllInListMonoid)
    testCombineWithEmpty(SetZipAllInListMonoid)
  }

  test("SetZipInListSemigroup should have correct associative combine and empty element") {
    val expected = Set(List(1, 4), List(2, 5), List(3, 6))
    testCombineMethod(expected, SetZipInListSemigroup)
    testCombineAssociative(SetZipInListSemigroup)
  }

}

object SetMonoidTest {

  val ASet = Set(1, 2, 3)
  val BSet = Set(4, 5, 6, 7)

  private def testCombineMethod(expected: Set[_], sg: Semigroup[Set[_]]): Unit = {
    val result = sg.combine(ASet, BSet)
    assert(expected == result)
  }

  private def testCombineAssociative(sg: Semigroup[Set[_]]): Unit = {
    val result1 = sg.combine(sg.combine(ASet, BSet), ASet)
    val result2 = sg.combine(ASet, sg.combine(BSet, ASet))
    assert(result1 == result2)
  }

  private def testCombineWithEmpty(monoid: Monoid[Set[_]]): Unit = {
    val result1 = monoid.combine(ASet, monoid.empty)
    val result2 = monoid.combine(monoid.empty, ASet)
    assert(ASet == result1)
    assert(ASet == result2)
  }
}