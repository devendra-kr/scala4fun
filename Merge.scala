/*==========================================
 Title:  Scala merge two List method implemetation
 Author: Devendra Kumar
 MailId: devspirit2016@gmail.com
 Education: M. Tech From HCU
 Date:   1 Sept 2018
========================================== */
object Merge{
        def main(args: Array[String]): Unit = {
        	println(merge(Range(0,10).toList,Range(10,20).toList))
        }
	def merge(list1: List[Int], list2: List[Int]): List[Int] = (list1, list2) match {
	      case (Nil, Nil) => Nil
	      case (Nil, _) => list2
	      case (_, Nil) => list1
	      case (_, x :: y) => merge(list1 ++ List(x),y)
      	}
  	}
}
