package module.`scala-with-cats`.ch2_4

import cats.{Monoid, Semigroup}

object SetMonoid {
  val SetConcatMonoid: Monoid[Set[_]] = Monoid.instance[Set[_]](Set.empty, _ ++ _)

  val SetZipAllInListMonoid: Monoid[Set[_]] = Monoid.instance[Set[_]](Set.empty, (lSet, rSet) =>
    lSet.zipAll(rSet, List.empty, List.empty).map {
      case (Nil, r) => r
      case (l, Nil) => l
      case (l: Iterable[_], r: Iterable[_]) => l ++ r
      case (l: Iterable[_], r) => l.toList :+ r
      case (l, r: Iterable[_]) => l +: r.toList
      case (l, r) => List(l, r)
    })

  val SetZipInListSemigroup: Semigroup[Set[_]] = Semigroup.instance[Set[_]] {
    _ zip _ map {
      case (l: Iterable[_], r: Iterable[_]) => l ++ r
      case (l: Iterable[_], r) => l.toList :+ r
      case (l, r: Iterable[_]) => l +: r.toList
      case (l, r) => List(l, r)
    }
  }
}
