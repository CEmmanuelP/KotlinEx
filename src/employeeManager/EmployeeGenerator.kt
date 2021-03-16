package employeeManager

import java.util.*


class EmployeeGenerator{

    companion object Singleton{
        private var instance: EmployeeGenerator? = null

        fun getEmployeeGenerator(): EmployeeGenerator =
            instance ?: synchronized(this){
                return@synchronized instance ?: EmployeeGenerator().also { instance = it }
            }
    }

    private fun randomNameGenerator(): String{
        var firstName = mutableListOf("김", "이", "박", "최", "정", "강", "조", "윤", "장", "임", "한", "오", "서", "신", "권", "황")
        var lastName = mutableListOf("유", "윤", "율", "은", "의", "이", "익", "인", "일", "자","장", "재", "전", "정", "제", "조", "종", "주", "준",
            "중", "지", "진", "찬", "창", "채", "천", "철", "초", "춘", "충", "치", "탐", "태", "택", "판", "하", "한", "해", "혁", "현", "형",
            "혜", "호", "홍", "화", "환")

        firstName.shuffle()
        lastName.shuffle()

        return firstName[0] + lastName[0] + lastName[1]
    }

    fun randomEmpNumber(): UUID{
        return UUID.randomUUID()
    }

    private fun randomDepartment(): Department{
        var pick = (1 until Department.values().size).random()
        return Department.values()[pick]
    }

    fun generatePartTimePerson(): PartTimeEmployee{
        var randomName = randomNameGenerator()
        var randomEmpNum = randomEmpNumber()
        var randomDept = randomDepartment()

        val employee = PartTimeEmployee(randomName, randomEmpNum)
        employee.department = randomDept

        return employee
    }

    fun generatePermanentPerson(): PermanentEmployee{
        var randomName = randomNameGenerator()
        var randomEmpNum = randomEmpNumber()
        var randomDept = randomDepartment()

        val employee = PermanentEmployee(randomName, randomEmpNum)
        employee.department = randomDept

        return employee
    }

    fun generatePeople(): MutableSet<Employee>{
        val employees: MutableSet<Employee> = mutableSetOf()

        for(i in 1..15){
            var randomName = randomNameGenerator()
            var randomEmpNum = randomEmpNumber()
            var randomDept = randomDepartment()

            val employee = PermanentEmployee(randomName, randomEmpNum)
            employee.department = randomDept
            employees.add(employee)
        }

        for(i in 1..15){
            var randomName = randomNameGenerator()
            var randomEmpNum = randomEmpNumber()
            var randomDept = randomDepartment()

            val employee = PartTimeEmployee(randomName, randomEmpNum)
            employee.department = randomDept

            employees.add(employee)
        }



//        val employeesIterator = employees.iterator()
//        while(employeesIterator.hasNext()){
//            println(employeesIterator.next())
//        }

        return employees
    }

}
