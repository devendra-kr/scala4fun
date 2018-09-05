/*==========================================
 Title:  Scala merge two List method implemetation
 Author: Devendra Kumar
 MailId: devspirit2016@gmail.com
 Education: M. Tech From HCU
 Date:   1 Sept 2018
========================================== */
object Merge{
        def main(args: Array[String]): Unit = {
                val res = merge(List(1,2,3), List(4, 5, 6))
                println(res)
        }
	def merge(list1: List[Int], list2: List[Int]): List[Int] = {
   	 (list1, list2) match {
	      case (Nil, list2) => list2
	      case (list1, Nil) => list1
	      case (list1, list2) => { var list = list1
	      list2.foreach(x => {list :+= x})
        list
      }
    }
  }
	
}
