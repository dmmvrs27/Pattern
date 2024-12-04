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
        val intArr = arrayOf(
            arrayOf(1, 2, 3),
            arrayOf(4, 5, 6),
            arrayOf(7, 8, 9)
        )
        val strArr = arrayOf(
            arrayOf("a", "b", "c"),
            arrayOf("d", "e", "f"),
            arrayOf("g", "i", "j")
        )
        val intTable = Data_table(intArr)
        val strTable = Data_table(strArr)
    }
    catch (e: Exception) {
        println(e.message)
    }
}