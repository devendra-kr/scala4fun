/*==========================================
 Title:  Scala zipper method implemetation
 Author: Devendra Kumar
 MailId: devspirit2016@gmail.com
 Education: M. Tech From HCU
 Date:   1 Sept 2018
========================================== */
object Zipper{
	def main(args: Array[String]): Unit = {
		val resZip = zip(List(1,2,3), List("a", "b", "c"))
		println(resZip)
	}

	def zip(list1: List[Int], list2: List[String]): List[(Int, String)] = {
	  	(list1, list2) match {
  			case(Nil,_) => Nil
	  		case(_, Nil) => Nil
	  		case(head1 :: tail1, head2 :: tail2) => (head1,head2)::zip(tail1,tail2)
  		}
	}
}
