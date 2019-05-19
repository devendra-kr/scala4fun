def powerset[A](s: Set[A]) = {
    def powerset_rec(acc: List[Set[A]], remaining: List[A]): List[Set[A]] = remaining match {
      case Nil          => acc
      case head :: tail => powerset_rec(acc ++ acc.map(_ + head), tail)
    }
    powerset_rec(List(Set.empty[A]), s.toList)
  }

  def powerset[A](s: List[A]) = {
    def powerset_rec(acc: List[List[A]], remaining: List[A]): List[List[A]] = remaining match {
      case Nil          => acc
      case head :: tail => powerset_rec(acc ++ acc.map(_ :+ head), tail)
    }
    powerset_rec(List(List.empty[A]), s.toList)
  }  

  println(powerset("abca".toList).map(_.mkString("")).length)

  def powerset(s: String) = {
    def powerset_rec(acc: List[List[String]], remaining: String): List[List[String]] = remaining.length <= 0 match {
      case true => acc
      case false => {
        val head = remaining(0).toString
        val tail = remaining.tail
        powerset_rec(acc ++ acc.map(_ :+ head), tail)
      }
    }
    powerset_rec(List(List.empty[String]), s).map(_.mkString(""))
  }
  
  println(powerset("abc"))


def powerset[A](s: Set[A]) = s.foldLeft(Set(Set.empty[A])) { case (ss, el) => ss ++ ss.map(_ + el)}
