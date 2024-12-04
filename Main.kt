fun main() {
    try {
        val frst = Student(1, "Ralf", "Bobby", "Braun", "@RaBBiT", git = "github.com/RuMiJ")
        val sec = Student(2, "Ruby", "John", "Milligan", git = "github.com/RuMiJ", phone = "81234567890")
        val thrd = Student(3, "Tomb", "Raider", "Third", git = "github.com/tnt", phone = "+78889990000")
        thrd.setContacts(tg = "@adood")
        val stringData = "4 Hail Malia Tate @maliaht github.com/MalHT"
        val fromStr = Student(stringData)
        val path = ".//stud.txt"
        val pathWr = ".//student.txt"
        val txt = Student.readFromTxt(path)
        Student.writeToTxt(pathWr, txt)
        val test = Student.readFromTxt(pathWr)
    } catch (e: Exception) {
        println(e.message)
    }
}