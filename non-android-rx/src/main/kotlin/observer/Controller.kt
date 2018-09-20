package observer

class Controller {
    val model = Model()
    val view = View( model ).apply {init()}

    fun operate(n : Int){
        model.n = n
    }

}

fun main(args: Array<String>) {
    Controller().run {
        operate(1)
        operate(2)
        operate(3)
    }
}