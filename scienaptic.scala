1. You current project and technology you working.
2. Merge two sorted List.
3. Return two elements those sum is X from given list.
4. Diff b/w class and case class.
5. isIntanceOf impl with match and case on case class which extends trait, how can we achive this on class.
6. Scala Option related programming question.
7. Diff b/w scala funtion and method, show with some example.

Answer 2: 
Answer 3: https://github.com/devendra-kr/scala4fun/blob/master/isExistSumOfTwoElemInList

Answer 5: 
trait Animal
case class Dog(legs:Int) extends Animal
case class Cat(legs:Int) extends Animal
val dog:Animal = Dog(4)

def detect(a: Animal) = a match {
  case Dog(d) => Println("Dog " + d)
  case Cat(c) => Println("Cat " + c)
  case _ => Println("Undefined")
}

Answer 6: 
def fun(value: Option[Int]) = {
  value.map(x => 2 * x)
}

Answer 7:
object A {
  def fun() = {
   println("def")
 }
 val fun1 : (Unit => Unit) = x => {
  println("val")
  }
}

val mOp = A.Fun(
mOp == A.fun1()


