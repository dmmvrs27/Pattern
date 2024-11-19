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

    companion object {
        fun isValidPhone(phone: String): Boolean {
            return phone.matches(Regex("^(\\+7[0-9]{10}|8[0-9]{10})\$"))
        }
        fun isValidText(text: String): Boolean {
            return text.matches(Regex("^[A-Za-zА-Яа-яЁё ]+$"))
        }
        fun isValidTg(tg: String): Boolean {
            return tg.matches(Regex("^@[A-Za-z0-9_]+$"))
        }
        fun isValidGit(git: String): Boolean {
            return git.matches(Regex("^github.com/[A-Za-z0-9_-]+$"))
        }
        fun isValidEmail(email: String): Boolean {
            return email.matches(Regex("^[A-Za-z0-9_-]+@[A-Za-z0-9-.]+$"))
        }
    }

    init {
        if (!isValidText(lastName) || !isValidText(firstName) || !isValidText(middleName))
            throw IllegalArgumentException("Неверный формат ФИО!")
        if (telegram != null && !isValidTg(telegram!!))
            throw IllegalArgumentException("Неверный формат телеграмм!")
        if (gitHub != null && !isValidGit(gitHub!!))
            throw IllegalArgumentException("Неверный формат Git!")
        if (email != null && !isValidEmail(email!!))
            throw IllegalArgumentException("Неверный формат email!")
        if (phone != null && !isValidPhone(phone!!))
            throw IllegalArgumentException("Неверный формат номера!")

        println("Студент с $id под именем $firstName был добавлен!")
    }
    constructor(id: String, surname: String, name: String, patronymic: String) :
            this(id, surname, name, patronymic, null, null, null, null)

    constructor(hashSt: HashMap<String, Any?>) : this(
        (hashSt["id"] as? String) ?: throw IllegalArgumentException("ID обязателен"),
        (hashSt["surname"] as? String) ?: throw IllegalArgumentException("Фамилия обязательна"),
        (hashSt["name"] as? String) ?: throw IllegalArgumentException("Имя обязательно"),
        (hashSt["patronymic"] as? String) ?: throw IllegalArgumentException("Отчество обязательно"),
        hashSt["phone"]?.toString(),
        hashSt["tg"]?.toString(),
        hashSt["email"]?.toString(),
        hashSt["git"]?.toString()
    )

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