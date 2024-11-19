class Student(
    val id: String,
    val lastName: String,
    val firstName: String,
    val middleName: String,

    var phone: String? = null,
    var telegram: String? = null,
    var email: String? = null,
    var gitHub: String? = null
) {
    fun printInfo() {
        println("ID: $id")
        println("Фамилия: $lastName")
        println("Имя: $firstName")
        println("Отчество: $middleName")
        println("Телефон: ${phone ?: "нет информации"}")
        println("Телеграм: ${telegram ?: "нет информации"}")
        println("Почта: ${email ?: "нет информации"}")
        println("Гит: ${gitHub ?: "нет информации"}")
    }
}
