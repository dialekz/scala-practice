package module.scala_with_cats.ch2_5

import cats.instances.int._
import cats.instances.option._
import cats.kernel.Monoid
import cats.syntax.semigroup._
import module.scala_with_cats.ch2_5.OrderMonoidInstance._

object AddingAllTheThings {
  def add(items: List[Int]): Int = absAdd[Int](items)
  def addOption(items: List[Option[Int]]): Option[Int] = absAdd[Option[Int]](items)
  def addOrder(items: List[Order]): Order = absAdd[Order](items)

  private def absAdd[T](items: List[T])(implicit sg: Monoid[T]) = items.foldLeft(Monoid[T].empty)(_ |+| _)
}
