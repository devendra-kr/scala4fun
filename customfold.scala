def fold[A](f: (A, A)=> A, a: A, ls: List[A]): A = {
	def fun(ls: List[A], res: A): A = ls match {
		case Nil => res
		case x::xs => fun(xs, f(res, x))
	}
	fun(ls, a)
}

val sum = (a: Int, b: Int) => a + b

println(fold(sum, 0, List(1,2,3,4,5)))
