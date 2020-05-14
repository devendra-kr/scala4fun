def filter(f: Int => Boolean, ls: List[Int]): List[Int] = {
	def fun(ls: List[Int], res: List[Int]): List[Int] = ls match {
		case Nil => res
		case x::xs => f(x) match {
			case true => fun(xs, res:+x)
			case false => fun(xs, res)
		}
	}
	fun(ls, List())
}

val even = (x: Int) => x % 2 == 0

println(filter(even, List(1,2,3,4,5,6,7,8,9,10)))
