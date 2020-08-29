package Main

import scala.io.Source
import java.text.SimpleDateFormat
import java.util.Date

/*Given a file which contains series of transactional laws
Try to find out the average time between start and end of each transaction
T1234, 2020 – 03 – 01 , 3:15 pm, start
T1235, 2020 – 03 – 01 , 3:16 pm, start
T1236, 2020 – 03 – 01 , 3:17 pm, start
T1234, 2020 – 03 – 01 , 3:18 pm, End
T1235, 2020 – 03 – 01 , 3:18 pm, End
*
*/
object TransactionalLaws extends App {
  case class Transaction(tnx: String, dateTime: Long, tnxType: String)

  val filename = "fileopen.txt" // file location/address

  /*val list = List(
    "T1234, 2020 – 03 – 01 , 3:15 pm, start",
    "T1235, 2020 – 03 – 01 , 3:16 pm, start",
    "T1236, 2020 – 03 – 01 , 3:17 pm, start",
    "T1234, 2020 – 03 – 01 , 3:18 pm, End",
    "T1235, 2020 – 03 – 01 , 3:18 pm, End")*/ // Tested with this input

  val lines = Source.fromFile(filename).getLines.toList //list
  val tnx = lines.map(x => {
    val trans = x.split(",").toList
    if (trans.length == 4) {
      val dateTime = dateTimeFormatter(trans(1).replaceAll(" ", "") + trans(2), "yyyy–MM–dd h:mm a")
      if (dateTime.isDefined)
        Some(Transaction(trans(0).trim, dateTime.get, trans(3).trim))
      else None
    } else None
  }).flatten.groupBy(_.tnx).map {
    case (key, value) =>
      val endTime = value.filter(_.tnxType.equalsIgnoreCase("end")).map(_.dateTime).headOption
      val startTime = value.filter(_.tnxType.equalsIgnoreCase("start")).map(_.dateTime).headOption
      if (startTime.isDefined && endTime.isDefined)
        println(key + " ----> " + (endTime.get - startTime.get) / 1000 / 60 + " min")
  }

  def dateTimeFormatter(s: String, format: String) = {
    val dateFormat = new SimpleDateFormat(format)
    try {
      Some(dateFormat.parse(s).getTime)
    } catch {
      case ex: Exception =>
        println("Get Exception During DateFormat Parsing msg " + ex.getMessage + " stack trace " + ex.getStackTrace.mkString("\n"))
        None
    }
  }

}
