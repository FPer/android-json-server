package observer

class Model {
    var _n : Int = 0
    var n : Int
        get() = _n
        set(value) {
            _n = value
            listeners.forEach{it.invoke(value)}
        }

    private val listeners : MutableList<MyListener> = mutableListOf()
    fun addListener(listener: MyListener){
        listeners.add(listener)
    }
}