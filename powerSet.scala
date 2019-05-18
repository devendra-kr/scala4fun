  def powerSet[A](s: Set[A]) = {
  def powerSet_rec(acc: List[Set[A]], remaining: List[A]): List[Set[A]] = remaining match {
    case Nil => acc
    case head :: tail => powerSet_rec(acc ++ acc.map(_ + head), tail)
  }
  powerSet_rec(List(Set.empty[A]), s.toList)
}  

println(powerSet("abc".toSet).map(_.mkString("")))
