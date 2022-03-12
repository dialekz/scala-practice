package module.scala_with_cats.ch4_1

import cats.implicits.catsSyntaxOptionId
import org.scalatest.funsuite.AnyFunSuite

class MMonadTest extends AnyFunSuite {

  import MMonadOption.mMonadOption

  test("MMonad should have correct flatMap method") {
    val input = Some(5)
    val expected = Some("5")

    assert(mMonadOption.flatMap(input)(_.toString.some).equals(expected))
  }

  test("MMonad should have correct map method") {
    val input = Some(5)
    val expected = Some("5")

    assert(mMonadOption.map(input)(_.toString).equals(expected))
  }
}
