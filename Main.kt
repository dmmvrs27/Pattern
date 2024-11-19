fun main() {
    val student1 = Student("2706", "Малышев", "Денис", "Амилович", telegram="@dmmvrs")
    student1.printInfo()
    println()

    val student2 = Student("2707", "Иванов", "Петр", "Сергеевич", "+79298323235")
    student2.printInfo()
}