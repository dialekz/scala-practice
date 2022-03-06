package module.`scala-with-cats`.ch1_4

import cats.implicits.toShow
import module.`scala-with-cats`.ch1_3.Cat
import module.`scala-with-cats`.ch1_4.ShowInstanceCat._
import org.scalatest.funsuite.AnyFunSuite

class ShowTest extends AnyFunSuite {

  test("Cat printable with cat's show syntax") {
    val result: String = Cat(name = "Liza", age = 2, color = "white").show
    assert(result.equals("Liza is a 2 year-old white cat"))
  }
}
