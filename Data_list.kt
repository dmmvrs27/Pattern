abstract class Data_list<T : Comparable<T>>(protected val elements: Array<T>){
    private val selected = mutableSetOf<Int>()
    protected var curN = 0
    init {
        require(elements.isNotEmpty()) { "Массив не может быть пустой!" }
        elements.sort()
    }
    fun select(number: Int){
        require(number in elements.indices) { "Неверно указан индекс!" }
        selected.add(number)
    }
    fun getSelected() = selected.toIntArray()
    fun buildNames(): Array<String> {
        return getNames()
    }
    fun buildData(): Data_table<Any> {
        curN = 0
        val data = elements.map { getData(it) }.toTypedArray()
        return Data_table(data)
    }
    abstract fun getNames(): Array<String>
    abstract fun getData(item: T): Array<Any>
}