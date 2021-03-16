package employeeManager

enum class Department(var deptCode: Int, var deptName: String){
    NO_DEPT(1, "부서 없음"),
    DEVELOPMENT_TEAM(2, "개발팀"),
    SALES_TEAM(3, "영업팀"),
    CS_TEAM(4, "고객응대팀"),
    OFFICE_TEAM(5, "사무팀")
}

