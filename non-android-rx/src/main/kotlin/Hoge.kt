import io.reactivex.Observable

fun main(args: Array<String>) {
    Observable
            .just(1,2,3)
            .map {it + 1}
            .subscribe(::println)
}