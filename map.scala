def map[A,B](f: A => B, ls: List[A]): List[B] = {
	def fun(ls: List[A], res: List[B]): List[B] = ls match {
		case Nil => res
		case x::xs => fun(xs, res :+ f(x))
	}
	fun(ls, Nil)
}

case class EMP(name: String, age: Int)
val ls = List(EMP("dev", 20), EMP("Mahi", 30), EMP("sita", 25))
val names = (e: EMP) => e.name

println(map1(names, ls))
