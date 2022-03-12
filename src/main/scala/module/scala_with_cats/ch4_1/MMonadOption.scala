package module.scala_with_cats.ch4_1

class MMonadOption extends MMonad[Option] {
  override def pure[A](a: A): Option[A] = Some(a)
  override def flatMap[A, B](value: Option[A])(func: A => Option[B]): Option[B] = value match {
    case Some(v) => func(v)
    case None => None
  }
}

object MMonadOption {
  implicit val mMonadOption: MMonad[Option] = new MMonadOption
}
