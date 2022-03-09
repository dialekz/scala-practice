package module.scala_with_cats.ch2_5

import cats.implicits.catsSyntaxOptionId
import org.scalatest.funsuite.AnyFunSuite
import module.scala_with_cats.ch2_5.AddingAllTheThings._

import scala.language.postfixOps

class AddingAllTheThingsTest extends AnyFunSuite {

  test("Add method should correct combine all items") {
    assert(add(1 to 100 toList).equals(5050))
  }

  test("AddOption method should correct combine all items") {
    assert(addOption(List(None)).isEmpty)
    assert(addOption(List(None, 1.some)).equals(1.some))
    assert(addOption(1 to 100 map(_.some) toList).equals(5050.some))
  }

  test("AddOrder method should correct combine all items") {
    assert(addOrder(List.empty).equals(Order(0, 0)))
    assert(addOrder(List(Order(5, 10))).equals(Order(5, 10)))
    assert(addOrder(List(Order(5, 10), Order(5, 10))).equals(Order(10, 20)))
  }
}
