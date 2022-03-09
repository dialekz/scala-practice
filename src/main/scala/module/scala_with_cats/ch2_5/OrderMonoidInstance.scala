package module.scala_with_cats.ch2_5

import cats.Monoid

class OrderMonoidInstance extends Monoid[Order]{
  override def empty: Order = Order(0, 0)
  override def combine(x: Order, y: Order): Order = Order(x.totalCost + y.totalCost, x.quantity + y.quantity)
}

object OrderMonoidInstance {
  implicit def instance: OrderMonoidInstance = new OrderMonoidInstance
}
