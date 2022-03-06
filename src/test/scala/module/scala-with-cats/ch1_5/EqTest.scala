package module.`scala-with-cats`.ch1_5

import cats.implicits.{catsKernelStdEqForOption, catsSyntaxEq, catsSyntaxOptionId, none}
import module.`scala-with-cats`.ch1_3.Cat
import module.`scala-with-cats`.ch1_5.EqInstanceCat._
import org.scalatest.funsuite.AnyFunSuite

class EqTest extends AnyFunSuite {

  val cat1: Cat = Cat(name = "Liza", age = 2, color = "white")
  val cat2: Cat = Cat(name = "Liza", age = 2, color = "white")
  val cat3: Cat = Cat(name = "Bars", age = 3, color = "black")

  test("Cat should use Eq") {
    assert(cat1 eqv cat2)
    assert(cat1 =!= cat3)
  }

  test("Cat should use Eq with Option") {
    assert(cat1.some eqv cat2.some)
    assert(cat1.some =!= cat3.some)
    assert(cat1.some =!= none)
  }
}
