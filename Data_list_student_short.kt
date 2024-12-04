class Data_list_student_short(elements: Array<Student_short>) : Data_list<Student_short>(elements) {
    override fun getNames(): Array<String> {
        return arrayOf("№","Фамилия И.О.", "Гит", "Контакт")
    }
    override fun getData(item: Student_short): Array<Any> {
        curN++
        return arrayOf(curN,item.surnameIn, item.git!!, item.contact)
    }
}