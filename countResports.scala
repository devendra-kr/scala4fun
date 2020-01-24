  def countReportes(ls: List[Int]) = {
    val map = ls.groupBy(x => x).mapValues(_.size)
    val sortedList = map.toSeq.sortBy(_._1).toList
    println(sortedList)
    def count(ls: List[(Int, Int)], res: Int): Int = ls match {
      case Nil          => res
      case x :: Nil     => res
      case x :: y :: xs => if (y._1 - x._1 == 1) count(y::xs, res + y._2) else count(y::xs, res)
    }
    count(sortedList, 0)
  }
  
 /*ls1 = List(1,1,2,3,5,6,6) o/p ===> 4
  ls2 = List(0,1,1,2,3,5,6,6) o/p ====> 6
  */
