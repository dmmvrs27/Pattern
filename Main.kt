fun main() {
    val student1 = Student("2706", "Малышев", "Денис", "Амилович", telegram="@dmmvrs", phone = "+79298491219", gitHub = "github.com/dmmvrs")
    student1.printInfo()
    println()

    val student2 = Student("2707", "Иванов", "Петр", "Сергеевич", "+79298323235", gitHub = "github.com/dmmvrs")
    student2.printInfo()

    val student3 = Student("2708", "Пупкин", "Иван", "Петрович", "124234242")
    student2.printInfo()
}