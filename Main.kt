fun main() {
    testThird()
}
fun testThird(){
    try {
        val pathR = ".//stud.txt"
        val pathW = ".//student.txt"
        val studentListManager = Student_list_txt(pathR)
        val students = studentListManager.readFromTxt(pathR)
        val student = studentListManager.findById(2)
        println("Found student: $student\n")
        studentListManager.writeToTxt(pathW, students)
        studentListManager.get_k_n_student_short_list(2,1)
        println("Count: ${studentListManager.get_count()}\n")
        studentListManager.orderStudents()
        studentListManager.get_k_n_student_short_list(0,3)
        val idRem = 3
        studentListManager.removeById(idRem)
        println("After removing $idRem\n")
        studentListManager.get_k_n_student_short_list(0,3)
        println("Count: ${studentListManager.get_count()}\n")
        val ad = Student(3, "Tomb", "Raider", "Third",
            git = "github.com/RuMiJ", phone = "+78889990000")
        studentListManager.addStudent(ad)
        studentListManager.get_k_n_student_short_list(0,3)
        val rep = Student(2, "Ruby", "John", "Milligan",
            git = "github.com/RuMiJ", phone = "81234567890")
        studentListManager.replaceStudentById(2, rep)
        studentListManager.get_k_n_student_short_list(0,3)
    }
    catch (e: Exception) {
        println(e.message)
    }
}
fun testSecond(){
    try {
        val st1 = Student_short(4, "Иванов И.И., github.com/ivanov, +79995456556")
        val st2 = Student_short(5, "Петров П.П.", "github.com/petrov", "petrov@mail.ru")
        val thrd = Student(6, "Сидоров", "Семен", "Сергеевич", "@sidrrr", "github.com/sidorov")
        val st3 = Student_short(thrd)
        val students = arrayOf(st1,st2,st3,st1,st2,st3,st1,st2,st3,)
        val studentList = Data_list_student_short(students)
        println("Имена аттрибутов: ${studentList.buildNames().joinToString()}")
        println("Сущности аттрибутов:\n${studentList.buildData()}")
        println("Сущности аттрибутов:\n${studentList.buildData()}")
    }
    catch (e: Exception) {
        println(e.message)
    }
}
fun testFirst(){
    try {
        val frst = Student(1, "Ralf", "Bobby", "Braun", "@RaBBiT", git = "github.com/RuMiJ")
        val sec = Student(2, "Ruby", "John", "Milligan", git = "github.com/RuMiJ", phone = "81234567890")
        val thrd = Student(3, "Tomb", "Raider", "Third", git = "github.com/RuMiJ", phone = "+78889990000")
        thrd.setContacts(tg = "@adood")
        thrd.write()
        val ph = Student(4, "Tommy", "Doggy", "Poppy", email = "TDP@mail.ru")
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
}