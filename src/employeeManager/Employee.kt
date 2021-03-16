package employeeManager

import java.util.*
import kotlin.properties.Delegates

open class Employee(): Any(){
    open var empName = ""
    open var department = Department.NO_DEPT

    open lateinit var empNum: UUID
    open val empType = ""
    var salary = 0

    constructor(empName: String,
                empNum: UUID):this(){
        this.empName = empName
        this.empNum = empNum
    }

    override fun toString() = """ 
        |
        | $empName 님
        | 부서 : $department
        | 고용형태 : $empType
        | 월급 : $salary
        | UUID : $empNum """.trimMargin()
}

class PermanentEmployee(override var empName: String,
                        override var empNum: UUID): Employee(empName, empNum){

    override var empType: String = "Permanent"

    override var department by Delegates.observable(Department.NO_DEPT){
            _, old, new -> println("$empName 님은 $old -> $new 로 부서가 변경되었습니다. ")
    }
}

class PartTimeEmployee(override var empName: String,
                       override var empNum: UUID): Employee(empName, empNum){

    override var department: Department by Delegates.observable(Department.NO_DEPT){
            _, old, new -> println("$empName 님은 $old -> $new 로 부서가 변경되었습니다. ")
    }

    override var empType: String = "PartTime"
    var workingHour: Int = 0
}


