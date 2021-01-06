/*
Qvantel test 
Generate random List whose sum is zero.
println(zeroSum(7))
*/

def zeroSum(num: Int): Array[Int] = {
      	var arr = new Array[Int](num)
      	val mid = num/2
      	val last = mid * 2 - 1
      	for(i <- 0 to mid - 1) {
      		arr(i) = -mid+i
      		arr(last-i) = mid-i
      	}
	      if(num%2 != 0) arr(num-1) = 0
	      val res = randomSelect(num, arr.toList)
	      println(res)
	      res.toArray
}

def randomSelect[A](n: Int, ls: List[A]): List[A] =
    if (n <= 0) Nil
    else {
      val (rest, e) = removeAt((new util.Random).nextInt(ls.length), ls)
      e :: randomSelect(n - 1, rest)
}

def removeAt[A](n: Int, ls: List[A]): (List[A], A) = ls.splitAt(n) match {
    case (Nil, _) if n < 0 => throw new NoSuchElementException
    case (pre, e :: post)  => (pre ::: post, e)
    case (pre, Nil)        => throw new NoSuchElementException
}
