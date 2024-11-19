fun main() {
    val student = Student(
        id = "2706",
        lastName = "Малышев",
        firstName = "Денис",
        middleName = "Амилович"
    )

    // Установим необязательные поля
    student.setPhone("+79298491219")
    student.setTelegram("@dmmvrs")
    student.setEmail("denis.malyshev.2002@list.ru")
    student.setGitHub("https://github.com/dmmvrs")

    // Вывод информации о студенте
    student.printInfo()
}