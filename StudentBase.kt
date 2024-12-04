open class StudentBase(
    val id: Int, val surname: String, val name: String, val patronymic: String, var tg: String? = null,
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

    open fun optValidate() {
        if (git != null && !isValidGit(git!!))
            throw IllegalArgumentException("Неверный формат Git!")
    }
    fun validate() {
        if (!isValidText(surname) || !isValidText(name) || !isValidText(patronymic))
            throw IllegalArgumentException("Неверный формат ФИО!")
        if (tg != null && !isValidTg(tg!!))
            throw IllegalArgumentException("Неверный формат телеграмм!")
        optValidate()
        if (email != null && !isValidEmail(email!!))
            throw IllegalArgumentException("Неверный формат email!")
        if (phone != null && !isValidPhone(phone!!))
            throw IllegalArgumentException("Неверный формат номера!")
        if (git != null && !anyContact())
            throw IllegalArgumentException("Необходим хотя бы 1 контакт!")
        else if (git == null && !anyContact())
            throw IllegalArgumentException("Необходим git и хотя бы 1 контакт!")
        else if (git == null)
            throw IllegalArgumentException("Необходим git!")
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
    fun getIn(): String {
        return "$surname ${name.take(1)}.${patronymic.take(1)}."
    }
    fun anyContact(): Boolean {
        return (tg != null || email != null || phone != null)
    }
    override fun toString(): String {
        return "${this::class.simpleName}(id=$id, surname=$surname, name=$name, patronymic=$patronymic, " +
                "tg=$tg, git=$git, email=$email, phone=$phone)"
    }
    fun write() {
        println(
            "${this::class.simpleName} $id:\n" + "ФИО - $surname $name $patronymic; " +
                    "Телеграм - ${tg ?: "[не указано]"}; " + "Гит - ${git ?: "[не указано]"}; " +
                    "Почта - ${email ?: "[не указано]"}; " + "Телефон - ${phone ?: "[не указано]"}.\n"
        )
    }
}