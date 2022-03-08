package module.scala_with_cats.ch1_3

import org.scalatest.funsuite.AnyFunSuite

class PrintableTest extends AnyFunSuite {

  import PrintableInstances._
  import PrintableSyntax._

  test("PrintableInt instance should have format method") {
    val intPrintable = PrintableInstances.PrintableInt
    val result: String = intPrintable.format(100)
    assert(result.equals("100"))
  }

  test("Int should have format method") {
    val result: String = 100.format
    assert(result.equals("100"))
  }

  test("Cat should have format method") {
    val result: String = Cat(name = "Liza", age = 2, color = "white").format
    assert(result.equals("Liza is a 2 year-old white cat"))
  }


}
