package module.scala_with_cats.ch3_5

sealed trait Tree[+T]

final case class Branch[T](left: Tree[T], right: Tree[T]) extends Tree[T]
  
final case class Leaf[T](value: T) extends Tree[T]

object Tree {
  def branch[T](left: Tree[T], right: Tree[T]): Tree[T] = Branch(left, right)
  def leaf[T](value: T): Tree[T] = Leaf(value)
}
