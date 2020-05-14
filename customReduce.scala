def reduce[A](f: (A, A) => A, ls: List[A]): A = {
	def fun(ls: List[A], res: A): A = ls match {
		case Nil => res
		case x::xs => fun(xs, f(res, x))
	}
	ls.isEmpty match {
		case true => {
		  throw new NoSuchElementException
		}
		case false => fun(ls.tail, ls(0))
	}
}

println(reduce1(sum, List(1,2,3,4,5)))

println(reduce1(sum, List()))
