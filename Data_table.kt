class Data_table<T>(private val data: Array<Array<T>>) {
    init {
        require(data.isNotEmpty()) { "Таблица не может быть пустой!" }
    }
    fun getElem(row: Int, column: Int): T{
        require (row in data.indices && column in data[row].indices) { "Неверные индексы!" }
        return data[row][column]
    }
    fun getColumnCount(): Int = data[0].size
    fun getRowCount(): Int = data.size
}

abstract class Data_list<T : Comparable<T>>(protected val elements: Array<T>){
    private val selected = mutableSetOf<Int>()
    init {
        require(elements.isNotEmpty()) { "Массив не может быть пустой!" }
        elements.sort()
    }
    fun select(number: Int){
        require(number in elements.indices) { "Неверно указан индекс!" }
        selected.add(number)
    }
    fun getSelected() = selected.toIntArray()
    abstract fun getNames(): Array<String>
    abstract fun getData(): Data_table<T>
}

class Data_list_student_short(elements: Array<Student_short>) : Data_list<Student_short>(elements) {
    override fun getNames(): Array<String> {
        return arrayOf("Фамилия И.О.", "Гит", "Контакт")
    }
    override fun getData(): Data_table<Student_short> {
        val data = elements.map { student ->
            arrayOf(student)
        }.toTypedArray()
        return Data_table(data)
    }
}