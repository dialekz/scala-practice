package module.scala_with_cats.ch3_5

import cats.Functor

class TreeFunctor extends Functor[Tree] {
  override def map[A, B](fa: Tree[A])(f: A => B): Tree[B] = fa match {
    case Branch(l, r) => Branch(map(l)(f), map(r)(f))
    case Leaf(value) => Leaf(f(value))
  }
}

object TreeFunctor {
  implicit val treeFunctor: Functor[Tree] = new TreeFunctor
}
