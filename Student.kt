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
    init {
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