 def reduce(list: List[Map[String, Int]]): Map[String, Int] = {
  def fun(ls: List[Map[String, Int]], res: Map[String, Int]): Map[String, Int] = ls match {
    case Nil => res
    case x :: xs => fun(xs, addMap(x, res))
  }
  fun(list, Map[String, Int]())
}

def addMap(m1: Map[String, Int], m2: Map[String, Int])  = {
  m2 ++ m1.map{ case (k,v) => k -> (v + m2.getOrElse(k,0)) }
}

eg: println(reduce(List(Map("a" -> 1, "b" -> 1), Map("a" -> 1, "c" -> 1), Map("b" -> 1, "c" -> 1), Map("d" -> 1)))) 
