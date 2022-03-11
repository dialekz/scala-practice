package module.scala_with_cats.ch3_5

import cats.syntax.functor._
import module.scala_with_cats.ch3_5.TreeFunctor._
import org.scalatest.funsuite.AnyFunSuite

class TreeFunctorTest extends AnyFunSuite {

  test("TreeFunctor should work") {
    val input: Tree[Int] = Tree.branch(
      left = Tree.branch(
        left = Tree.leaf(1),
        right = Tree.branch(Leaf(2), Leaf(3))
      ),
      right = Tree.leaf(4)
    )
    val expected: Tree[String] = Tree.branch(
      left = Tree.branch(
        left = Tree.leaf("1"),
        right = Tree.branch(Leaf("2"), Leaf("3"))
      ),
      right = Tree.leaf("4")
    )

    assert(input.map(_.toString).equals(expected))
  }
}
