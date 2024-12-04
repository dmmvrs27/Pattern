class Student_short(id: Int, val surnameIn: String, git: String, val contact: String)
    : StudentBase(id, "", "", "", null, git), Comparable<Student_short> {
    init {
        optValidate()
        println("Cтудент $id (кратко) добавлен успешно!")
        writeShort()
    }

    constructor(student: Student):this(
        id = student.id,
        surnameIn = student.getIn(),
        git = student.git.toString(),
        contact = student.getContact().substringAfter(":").trim()
    )
    constructor(id: Int, info: String):this(
        id = id,
        surnameIn = info.substringBefore(",").trim(),
        git = info.substringAfter(",").substringBefore(",").trim(),
        contact = info.substringAfter(",").substringAfter(",").trim()
    )

    override fun optValidate() {
        if (!isValidIn(surnameIn))
            throw IllegalArgumentException("Неверный формат ФИО!")
        super.optValidate()
        if (!isValidTg(contact) && !isValidEmail(contact) && !isValidPhone(contact))
            throw IllegalArgumentException("Неверный формат контакта!")
    }
    fun isValidIn(text: String): Boolean {
        return text.matches(Regex("^([А-ЯЁ][а-яё]+|[A-Z][a-z]+) ([А-ЯЁ][.]|[A-Z][.])([А-ЯЁ][.]|[A-Z][.])$"))
    }
    fun writeShort() {
        var what = ""
        if (isValidTg(contact))
            what = "tg"
        else if (isValidEmail(contact))
            what = "email"
        else if (isValidPhone(contact))
            what = "phone"
        println(
            "${this::class.simpleName} $id:\n" + "ФИО - $surnameIn; " + "git - $git; " +
                    "$what - $contact.\n"
        )
    }
    override fun compareTo(other: Student_short): Int {
        return this.surnameIn.compareTo(other.surnameIn)
    }
    override fun toString(): String {
        return "${this::class.simpleName}(id=$id, surnameIn=$surnameIn, git=$git, contact=$contact)"
    }
}