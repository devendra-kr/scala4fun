# scala4fun

How Scala is scalable over java => https://dzone.com/articles/scaling-scala-vs-java

1. Find last element in a list
def lastElem[A](ls: List[A]): A = ls match {
	case h :: Nil  => h
	case _ :: tail => lastElem(tail)
	case _         => throw new NoSuchElementException
}

2. Find second last element in a list
def secondLastElem[T](ls: List[T]): T = ls match {
	case s :: h :: Nil => s
	case _ :: tail => secondLastElem(tail)
	case _ => throw new NoSuchElementException
}

3. Find kth element in a list
def kthElem[T](ls: List[T], k: Int): T = (ls, k) match {
	case (h :: _, 0) => h
	case (_ :: tail, k) => kthElem(tail, k - 1)
	case (Nil, _) => throw new NoSuchElementException
}
                        OR
def kthElem[T](ls: List[T], k: Int): T = ls match {
	case h :: tail => if(k == 0) h else kthElem(tail, k - 1)
	case Nil => throw new NoSuchElementException
}

4. Find Number of element of a list.
def length[T](ls: List[T]) = {
	def len[T](ls: List[T], l: Int): Int = ls match {
		case Nil => l
		case _ :: tail => len(tail, l + 1)
	}
	len(ls, 0)
}

5. Reverse a list
def reverse[T](ls: List[T]): List[T] = ls match {
	case Nil => Nil
	case h :: tail => reverse(tail) ::: List(h)
}
			OR

def reverse[T](ls: List[T]): List[T] = {
	def rev(result: List[T], ls: List[T]): List[T] = ls match {
	case Nil => result
	case h :: tail => rev(h :: result, tail)
	}
	rev(Nil, ls)
}

			OR

def reverse[T](ls: List[T]): List[T] = ls.foldLeft(List[T]()) { (r,h) => h :: r}

6. Find out whether a list is a palindrome
def isPalindrome[T](ls: List[T]): Boolean = ls == ls.reverse

7. Flatten a nested list structure   
def flat(ls: List[Any]): List[Any] = ls flatMap {
	case l: List[_] => flat(l)
	case e => List(e)
}
println(flat(List(List(8, 5), 2, List(List(1,2,4,2,1)))))

8. Eliminate consecutive duplicates of list elements
def eliminateConsecutiveDuplicates[T](ls: List[T]): List[T] = ls match {
	case Nil => Nil
	case h :: tail => h :: eliminateConsecutiveDuplicates(tail.dropWhile(_ == h))
}
						OR
def eliminateConsecutiveDuplicates[T](ls: List[T]): List[T] = ls.foldRight(List[T]()) {
	(h, r) => if(r.isEmpty || r.head != h) h :: r else r
}

9. Pack consecutive duplicates of list elements into sublists
def sublists[T](ls: List[T]): List[List[T]] = {
	if(ls.isEmpty) List(List())
		else {
		    val (pack, next) = ls.span(_ == ls.head)
		    if(next == Nil) List(pack) else pack :: sublists(next)
		}
}

10.  Run-length encoding of a list
def encoding[T](ls: List[T]): List[(T, Int)] = {
	def sublists(ls: List[T], length: Int): List[(T, Int)] = {
		if(ls.isEmpty) List()
		else {
		    val (pack, next) = ls.span(_ == ls.head)
		    if(next == Nil) List((pack.head, pack.length)) else ((pack.head, pack.length)) :: sublists(next, next.length)
		}
	}
	sublists(ls, ls.length)
}
					OR
def encoding[T](ls: List[T]) = {
	def sublists[T](ls: List[T]): List[List[T]] = {
		if(ls.isEmpty) List(List())
		else {
		    val (pack, next) = ls.span(_ == ls.head)
		    if(next == Nil) List(pack) else pack :: sublists(next)
		}
	}
	val list = sublists(ls)
	list.map( e => (e.length, e.head))
}


11. Modified run-length encoding
def modifiedEncoding[T](ls: List[T]) = {
	def sublists[T](ls: List[T]): List[List[T]] = {
		if(ls.isEmpty) List(List())
		else {
		    val (pack, next) = ls.span(_ == ls.head)
		    if(next == Nil) List(pack) else pack :: sublists(next)
		}
	}
	val list = sublists(ls)
	list.map( e => (if(e.length == 1) e.head else (e.length, e.head)))
}

12. Decode a run-length encoded list
def decode[T](ls: List[(Int, T)]): List[T] = ls flatMap( e => { List.make(e._1, e._2) })

13. Run-length encoding of a list (direct solution)


14. Duplicate the elements of a list
def makeDuplicate[T](ls: List[T]) = ls.flatMap(e => List(e,e))
						OR
def makeDuplicate[T](ls: List[T]) = ls.map(e => List(e,e)).flatten

15. Duplicate the elements of a list a given number of times
def makeDuplicateN[T](n: Int, ls: List[T]): List[T] = ls flatMap { List.make(n, _) }

16. Drop every Nth element from a list
def dropEveryN[T](n: Int, ls: List[T]): List[T] = {
    def dropR[T](c: Int, ls: List[T]): List[T] = (c, ls) match {
      	case (_, Nil) => Nil
      	case (1, _ :: tail) => 	dropR(n, tail)
       	case (_, h :: tail) => h :: dropR(c-1, tail)
    }
    dropR(n,ls)
}

16. Split a list into two parts
def split[T](n: Int, ls: List[T]): (List[T], List[T]) = ls.splitAt(n)
def split[T](n: Int, ls: List[T]): (List[T], List[T]) = (ls.take(n), ls.drop(n))


The Difference Between Currying and Partially Applied Functions:
1. Currying:
def sun(a: Int, b: Int) = a + b can be write as def sun(a: Int)(b: Int) = a + b
2. Partially Applied
def sun(a: Int, b: Int) = a + b can be write as def sun(a: Int, _: Int) it will return new fumtion like fun(_)
