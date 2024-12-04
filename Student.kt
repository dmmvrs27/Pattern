class Student(
    var id: Int, var surname: String, var name: String, var patronymic: String, var tg: String? = null,
    var git: String? = null, var email: String? = null, var phone: String? = null
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
        if (!isValidText(surname) || !isValidText(name) || !isValidText(patronymic))
            throw IllegalArgumentException("Неверный формат ФИО!")
        if (tg != null && !isValidTg(tg!!))
            throw IllegalArgumentException("Неверный формат телеграмм!")
        if (git != null && !isValidGit(git!!))
            throw IllegalArgumentException("Неверный формат Git!")
        if (email != null && !isValidEmail(email!!))
            throw IllegalArgumentException("Неверный формат email!")
        if (phone != null && !isValidPhone(phone!!))
            throw IllegalArgumentException("Неверный формат номера!")
        validate()
        println("Студент $id был добавлен успешно!")
        write()
    }

    constructor(id: Int, surname: String, name: String, patronymic: String):
            this(id, surname, name, patronymic, null, null, null, null)

    constructor(hashStudents: HashMap<String, Any?>) : this(
        (hashStudents["id"] as? Int) ?: throw IllegalArgumentException("ID обязателен"),
        (hashStudents["surname"] as? String) ?: throw IllegalArgumentException("Фамилия обязательна"),
        (hashStudents["name"] as? String) ?: throw IllegalArgumentException("Имя обязательно"),
        (hashStudents["patronymic"] as? String) ?: throw IllegalArgumentException("Отчество обязательно"),
        hashStudents["phone"]?.toString(),
        hashStudents["tg"]?.toString(),
        hashStudents["email"]?.toString(),
        hashStudents["git"]?.toString()
    )

    constructor(str: String) : this(
        id = str.split(" ")[0].toIntOrNull()
            ?: throw ParsingException("Неверный формат ID!"),
        surname = str.split(" ").getOrNull(1)
            ?: throw ParsingException("Фамилия отсутствует!"),
        name = str.split(" ").getOrNull(2)
            ?: throw ParsingException("Имя отсутствует!"),
        patronymic = str.split(" ").getOrNull(3)
            ?: throw ParsingException("Отчество отсутствует!"),
        tg = str.split(" ").getOrNull(4),
        git = str.split(" ").getOrNull(5),
        email = str.split(" ").getOrNull(6),
        phone = str.split(" ").getOrNull(7)
    )

    override fun toString(): String {
        return "Student(id=$id, surname=$surname, name=$name, patronymic=$patronymic, " +
                "tg=$tg, git=$git, email=$email, phone=$phone)"
    }

    fun getIn(): String {
        return "$surname ${name.take(1)}.${patronymic.take(1)}."
    }
    fun getContact(): String {
        return when {
            tg != null -> "tg: $tg"
            email != null -> "email: $email"
            else -> "phone: $phone"
        }
    }
    fun getInfo(): String {
        val infoSt = "${getIn()}, git: $git, ${getContact()}"
        println(infoSt)
        return infoSt
    }
    fun setContacts(tg: String? = this.tg, git: String? = this.git, email: String? = this.email, phone: String? = this.phone) {
        if (tg != null && !isValidTg(tg)) throw IllegalArgumentException("Неверный формат телеграмм!")
        if (git != null && !isValidGit(git)) throw IllegalArgumentException("Неверный формат Git!")
        if (email != null && !isValidEmail(email)) throw IllegalArgumentException("Неверный формат email!")
        if (phone != null && !isValidPhone(phone)) throw IllegalArgumentException("Неверный формат номера!")
        this.tg = tg
        this.git = git
        this.email = email
        this.phone = phone
    }

    fun validate() {
        if (git != null && !anyContact())
            throw IllegalArgumentException("Необходим хотя бы 1 контакт!")
        else if (git == null && !anyContact())
            throw IllegalArgumentException("Необходим git и хотя бы 1 контакт!")
        else if (git == null)
            throw IllegalArgumentException("Необходим git!")
    }

    fun anyContact(): Boolean {
        return (tg != null || email != null || phone != null)
    }

    fun write() {
        println(
            "Студент $id:\n" + "ФИО - $surname $name $patronymic; " + "Телеграм - ${tg?: "[не указано]"}; " +
                    "Гит - ${git?: "[не указано]"}; " + "Почта - ${email?: "[не указано]"}; " + "Телефон - ${phone?: "[не указано]"}.\n"
        )
    }
}