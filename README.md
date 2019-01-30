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

