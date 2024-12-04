fun main() {
    try {
        val frst = Student(1, "Ralf", "Bobby", "Braun", "@RaBBiT", git = "github.com/RuMiJ")
        val sec = Student(2, "Ruby", "John", "Milligan", git = "github.com/RuMiJ", phone = "81234567890")
        val thrd = Student(3, "Tomb", "Raider", "Third", git = "github.com/tnt", phone = "+78889990000")
        thrd.setContacts(tg = "@adood")
        thrd.write()
        println(sec.toString()+"\n")
        val ph = Student(4, "Tommy", "Doggy", "Poppy", email = "TDP@mail.ru", git = "github.com/TDPgit")
        val stringData = "5 Hail Malia Tate @maliaht github.com/MalHT"
        val fromStr = Student(stringData)
        println(ph.getContact().substringAfter(":").trim())
        println()
        val short = Student_short(frst)
        val short2 = Student_short(6, "Sam T.K., github.com/Samtk, 89998887675")
        val path = ".//stud.txt"
        val pathWr = ".//student.txt"
        val txt = Student.readFromTxt(path).map {it.getInfo()}
        Student.writeToTxt(pathWr, Student.readFromTxt(path))
    } catch (e: Exception) {
        println(e.message)
    }
}