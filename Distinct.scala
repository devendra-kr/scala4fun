/*==========================================
 Title:  Scala distinct method implemetation  
 Author: Devendra Kumar
 MailId: devspirit2016@gmail.com
 Education: M. Tech From HCU
 Date:   1 Sept 2018
========================================== */
object Distinct{ 
 	def main(args: Array[String]): Unit = {
		 println(distinct(List(1L, 2L, 4L, 1L, 5L, 2L)))
		 println(distinct(List('a','b','v','d','a','s','d','a','f','g','r','t')))
	}
	def distinct[A](ls: List[A]): List[A] = {
  		def dis(res: List[A], ls: List[A]): List[A] = ls match {
    			case Nil => res
    			case x :: y => res.contains(x) match {
      				case true => dis(res, y)
      				case false => dis(res ++ List(x), y) 
    			}
  		}
  		dis(List[A](), ls)
	}
}
