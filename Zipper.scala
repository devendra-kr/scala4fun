/*==========================================
 Title:  Scala zipper method implemetation
 Author: Devendra Kumar
 MailId: devspirit2016@gmail.com
 Education: M. Tech From HCU
 Date:   1 Sept 2018
========================================== */
object Zipper{
	def main(args: Array[String]): Unit = {
		println(zip(List(1,2,3), List("a", "b", "c")))
		println(zip(List('a', 'b', 'c'), List(1,2,3)))
	}
	def zip[A,B](ls1: List[A], ls2: List[B]): List[(A, B)] = (ls1, ls2) match {
  			case(Nil,_) => Nil
	  		case(_, Nil) => Nil
	  		case(head1 :: tail1, head2 :: tail2) => (head1,head2)::zip(tail1,tail2)
	}
}
