/*==========================================
 Title:  Scala distinct method implemetation  
 Author: Devendra Kumar
 MailId: devspirit2016@gmail.com
 Education: M. Tech From HCU
 Date:   1 Sept 2018
========================================== */
object Distinct{ 
 	def main(args: Array[String]): Unit = {
		val inList = List(1L, 2L, 4L, 1L, 5L, 2L)
		println(fun(inList))
	}
	def fun(list: List[Long]) = {
		var res = List[Long]()
		list.foreach(l => {
			if(!res.contains(l)) res = res ++ List(l)
		})
		res
	}
}
