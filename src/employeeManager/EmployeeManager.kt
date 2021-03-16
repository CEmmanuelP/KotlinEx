package employeeManager

val generator = EmployeeGenerator.getEmployeeGenerator()

class EmployeeManager {
    private val ANNUAL_SALARY: Int = 120_000_000
    private val HOURLY_WAGE: Int = 25000

    fun setUpPermanent(): PermanentEmployee{
        val emp = generator.generatePermanentPerson()
        calculatePermanentEmployeeSalary(emp)

        return emp
    }

    fun setUpPartTime(time: Int): PartTimeEmployee{
        val emp = generator.generatePartTimePerson()
        calculatePartTimeEmployeeSalary(emp, time)

        return emp
    }

    private fun calculatePermanentEmployeeSalary(e: PermanentEmployee){
        e.salary = if(e.department == Department.SALES_TEAM){
            (ANNUAL_SALARY * 1.05).toInt()
        }else{
            ANNUAL_SALARY
        }
    }

    private fun calculatePartTimeEmployeeSalary(e: PartTimeEmployee, workingTime: Int){
        e.workingHour = workingTime
        e.salary = if(e.department == Department.SALES_TEAM){
            (e.workingHour.times(HOURLY_WAGE) * 1.05).toInt()
        }else{
            e.workingHour.times(HOURLY_WAGE)
        }

    }



}

fun main(){

    var emp = EmployeeManager().setUpPermanent()
    println(emp)
}