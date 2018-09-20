import io.reactivex.Observable
import org.junit.Test

class BasicTest {
    @Test
    fun きほんのき(): Unit {
        Observable
                .just(1, 2, 3)
                .test()
                .assertValues(1, 2, 3)
    }

    @Test
    fun 分岐して合流(): Unit {
        Observable
                .range(1, 6)
                .publish{ shared ->
                    Observable.merge(
                            shared.filter{ it % 2 == 0 }.map{ it * 100 },
                            shared.filter{ it % 2 == 1 })
                    }
                .test()
                .assertValues(1, 200, 3, 400, 5, 600)
    }
}