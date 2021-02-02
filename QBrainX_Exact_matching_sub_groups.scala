val k = 6
val n = "11020211"

println(sub(n, k))

def sub(num: String, k: Int) = {
  def rec(n: String, res: List[String]): List[String] = n.length == 0 match {
    case true => res
    case false => {
      val subString = subStringForEqualToK(k, n)
      rec(n.substring(1, n.length), if(subString.isEmpty) res else res :+ subString)
    }
  }
  rec(num, Nil)
}

def subStringForEqualToK(k: Int, n: String): String = {
  var res = 0
  for(i <- 0 until n.length){
    res = res + n(i).toString.toInt
    if(k == res)
      return n.substring(0, i+1)
  }
  return ""
}
