/*==========================================
 Title:  Scala code for DublicateFinder
 Author: Devendra Kumar
 MailId: devspirit2016@gmail.com
 Education: M. Tech From HCU
 Date:   1 Sept 2018
========================================== */
object DublicateFinder{ 
	def main(args: Array[String]): Unit = {
		val res = fun(List(1L, 2L, 4L, 1L, 5L, 2L))
		println(res)
 	}
	def fun(list: List[Long]) = {
		var arr = List[Long]()
		var dub= List[Long]()
		list.foreach(l => {if(!arr.contains(l)) arr = arr ++ List(l) else dub = dub ++ List(l)})
		dub
	}
}