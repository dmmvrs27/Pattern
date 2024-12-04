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
    override fun toString(): String {
        return data.joinToString("\n") { row -> row.joinToString() }
    }
}