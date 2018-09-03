/* Author: Devendra Kumar
 MailId: devspirit2016@gmail.com
 Education: M. Tech From HCU
 Date:   3 Sept 2018
========================================== */
import java.text.SimpleDateFormat
import java.text.ParseException
import java.util.Date
object CollisionDateFinder{
        def main(args: Array[String]): Unit = {
                val in = List(("01-09-2018","04-09-2018"), ("02-09-2018","04-09-2018"), ("02-09-2018","03-09-2018"), ("04-09-2018","05-09-2018"), ("05-09-2018","06-09-2018"), ("06-09-2018","08-09-2018"), ("10-09-2018","12-09-2018"), ("13-09-2018","14-09-2018"), ("11-09-2018","11-09-2018"))
		val date = getCollisionDates(in)
                println(date)
        }

	def getCollisionDates(rawList: List[(String, String)]) = {
	   val list = rawList.map(l => (getEpoch(l._1), getEpoch(l._2)))
	    var newList = List[(Long, Long)]()
	    for(i <- 1 to list.length){
	    	val ele = list(i-1)
	        val other = list.drop(i)
	        newList ++= other.flatMap(l => {
	        	if((ele._1 >= l._1 && ele._1 <= l._2) || (ele._2 >= l._1 && ele._2 <= l._2)) List(ele, l) 
		           else if(ele._1 < l._1 && ele._2 > l._2) List(ele, l) else List[(Long, Long)]()
      		})
    	   }
	newList.distinct.map(l => (epochToDate(l._1), epochToDate(l._2)))
	}

  	def getEpoch(date: String) = {
	    import java.text.SimpleDateFormat
	    import java.text.ParseException
	    var millis = 0L
	    try {
	      millis = new SimpleDateFormat("dd-MM-yyyy").parse(date).getTime()
	    } catch {
	      case ex: ParseException => {
		ex.printStackTrace
		print("Exception --> During Date parsing")
	      }
	    }
	    millis
	  }

	def epochToDate(epochMillis: Long): String = {
	   val df = new SimpleDateFormat("dd-MM-yyyy")
	   df.format(epochMillis)
	}
}
