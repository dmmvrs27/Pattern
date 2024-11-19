class Student(
    private val id: String,
    private val lastName: String,
    private val firstName: String,
    private val middleName: String,

    private var phone: String? = null,
    private var telegram: String? = null,
    private var email: String? = null,
    private var gitHub: String? = null
) {

    // Геттеры и сеттеры
    fun getId(): String = id
    fun getLastName(): String = lastName
    fun getFirstName(): String = firstName
    fun getMiddleName(): String = middleName

    fun setPhone(phone: String?) {
        this.phone = phone
    }

    fun setTelegram(telegram: String?) {
        this.telegram = telegram
    }

    fun setEmail(email: String?) {
        this.email = email
    }

    fun setGitHub(gitHub: String?) {
        this.gitHub = gitHub
    }

    // Новый метод для вывода информации о студенте
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