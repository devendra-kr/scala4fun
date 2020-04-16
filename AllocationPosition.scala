
/* Amazon Interview Question---
Suppose you have arrar/list with contains either 0 OR 1, 0 reprsernt vacant seat and 1 represent allocated seat.
You need to allocate new seat in give array/list where this seat should be far away from allocated seat.
*/

object Solution extends App {
      val inputList = List(1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0)

       println("Index postion "  + getNewAllocationPosion(inputList))

       def getNewAllocationPosition(inputList: List[Int]): Int = {
         if(inputList.isEmpty) return -1
          var ls = if(inputList(0) == 0) 1 +: inputList else inputList
          ls = if(ls(ls.length-1) == 0) ls :+ 1 else ls
          var (x,y,max) = (0,0,0)
          var index = 0
          while(ls.length > 1) {
            val (firstIndex, lastIndex, unAllocatedSize) = getEachElements(ls)
            if(unAllocatedSize > max) {
              x = index
              y = lastIndex + index
              max = unAllocatedSize
            }
            index += lastIndex
            ls = ls.drop(lastIndex)
            //println(x+" "+y+" "+max)
          }
          if(x == 0 && inputList(0) == 0) return x
          else if(y == inputList.length && inputList(inputList.length-1) == 0) return y - 1
          else return (x+y) / 2
        }

        def getEachElements(ls: List[Int]) = {
            val firstIndex = ls.indexOf(1, 0)
            val lastIndex = ls.indexOf(1, firstIndex + 1)
            val unAllocatedSize = lastIndex - firstIndex - 1
            (firstIndex, lastIndex, unAllocatedSize)
        }
}
