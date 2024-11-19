fun main() {
    val student = Student(
        id = "2706",
        lastName = "Малышев",
        firstName = "Денис",
        middleName = "Амилович"
    )

    student.phone = "+79298491219"
    student.telegram = "@dmmvrs"
    student.email = "denis.malyshev.2002@list.ru"
    student.gitHub = "https://github.com/dmmvrs"

    student.printInfo()
}