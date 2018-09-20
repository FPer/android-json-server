package observer

class View(val model: Model) {
    fun init(){
        model.addListener(object: MyListener {
            override fun invoke(n : Int) {
                draw("hello $n")
            }
        })
    }

    fun draw(message: String): Unit {
        println(message)
    }
}


