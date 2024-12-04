import java.io.File
import java.io.IOException

class Student(id: Int, surname: String, name: String, patronymic: String, tg: String? = null,
              git: String? = null, email: String? = null, phone: String? = null)
    : StudentBase(id, surname, name, patronymic, tg, git, email, phone) {
    companion object {
        fun readFromTxt(path: String): List<Student>{
            val file = File(path)
            if (!file.exists() || !file.canRead())
                throw IOException("Path is incorrect!")
            println("Read from $path:\n")
            return file.readLines().map { Student(it) }
        }
        fun writeToTxt(path: String, students: List<Student>) {
            val file = File(path)
            if (!file.exists() || !file.canWrite())
                throw IOException("Path is incorrect!")
            students.map { file.appendText(it.toTxt().trim()
                    + "\n") }
            println("Written to $path!\n")
        }
    }
    init {
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

    fun getContact(): String {
        return when {
            tg != null -> "tg: $tg"
            email != null -> "email: $email"
            else -> "phone: $phone"
        }
    }
    fun getInfo(): String {
        val infoSt = "${getIn()}, $git, ${getContact()}"
        println(infoSt)
        return infoSt
    }
}