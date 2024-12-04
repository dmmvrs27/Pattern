class Student_short(val id: Int, val surnameIn: String, val git: String, val contact: String){
    init {
        println("Cтудент $id (кратко) добавлен успешно!")
        write()
    }
    constructor(student: Student):this(
        student.id,
        student.getIn(),
        student.git.toString(),
        student.getContact()
    )
    constructor(id: Int, info: String):this(
        id,
        info.substringBefore(",").trim(),
        info.substringAfter("git:").substringBefore(",").trim(),
        info.substringAfter(",").trim()
    )
    fun write() {
        println(
            "Студент $id:\n" + "ФИО - $surnameIn; " + "Гит - $git; " +
                    "Контакт - $contact.\n"
        )
    }
}