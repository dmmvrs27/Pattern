fun main() {
    try {
        /*
        val frst = Student(1, "Ralf", "Bobby", "Braun", "@RaBBiT", git = "github.com/RuMiJ")
        val sec = Student(2, "Ruby", "John", "Milligan", git = "github.com/RuMiJ", phone = "81234567890")
        val thrd = Student(3, "Tomb", "Raider", "Third", git = "github.com/tnt", phone = "+78889990000")
@@ -11,7 +12,21 @@ fun main() {
        val txt = Student.readFromTxt(path)
        Student.writeToTxt(pathWr, txt)
        val test = Student.readFromTxt(pathWr)
        */
        val st1 = Student_short(1, "Иванов И.И., github.com/ivanov, +79995456556")
        val st2 = Student_short(2, "Петров П.П.", "github.com/petrov", "petrov@mail.ru")
        val thrd = Student(3, "Сидоров", "Семен", "Сергеевич", "@sidrrr", "github.com/sidorov")
        val st3 = Student_short(thrd)
        val students = arrayOf(st1,st2,st3)
        val studentList = Data_list_student_short(students)
        println("Имена аттрибутов: ${studentList.buildNames().joinToString()}")
        println("Сущности аттрибутов: ${studentList.buildData()}")
    }
    catch (e: Exception) {
        println(e.message)
    }
}