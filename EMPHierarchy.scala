/*==========================================
 Title:  Employee Hierarchy in Org.
 Author: Devendra Kumar
 MailId: devspirit2016@gmail.com
 Education: M. Tech From HCU
 Date:   4 Sept 2018
========================================== */

object EMPHierarchy {

case class Employee(empId: Long, managerId: Option[Long])
case class EmployeeHierarchy(empId: Long, managers: List[Employee])

def main(args: Array[String]) = {
	val empList = List(Employee(1000L, Some(1002L)), Employee(1002L, Some(1003L)), Employee(1004L, Some(1005L)), Employee(1005L, None), Employee(1003L, None))
	val res = employeeHierarchy(empList)
	println(res)
}

  def employeeHierarchy(empList: List[Employee]) = {
    val empMap = empList.map(e => (e.empId, e.managerId)).toMap

    def getManagerId(managerId: Option[Long], empList: List[Employee]): List[Employee] = {
      empList match {
        case Nil => List[Employee]()
        case x :: list => {
          if (managerId.isDefined) {
            val newEmp = empMap.get(managerId.get).flatten
            Employee(managerId.get, newEmp) :: getManagerId(newEmp, list)
          } else List[Employee]()
        }
      }
    }
    
    empList.map(e => {
      val managers = getManagerId(e.managerId, empList)
      EmployeeHierarchy(e.empId, managers)
    })
  }
}
