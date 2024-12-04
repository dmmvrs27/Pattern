fun main() {
    try {
        val st1 = Student_short(4, "Иванов И.И., github.com/ivanov, +79995456556")
        val st2 = Student_short(5, "Петров П.П.", "github.com/petrov", "petrov@mail.ru")
        val thrd = Student(6, "Сидоров", "Семен", "Сергеевич", "@sidrrr", "github.com/sidorov")
        val st3 = Student_short(thrd)
        val students = arrayOf(st1, st2, st3, st1, st2, st3, st1, st2, st3,)
        val studentList = Data_list_student_short(students)
        println("Имена аттрибутов: ${studentList.buildNames().joinToString()}")
        println("Сущности аттрибутов:\n${studentList.buildData()}")
        println("Сущности аттрибутов:\n${studentList.buildData()}")
    } catch (e: Exception) {
        println(e.message)
    }
}