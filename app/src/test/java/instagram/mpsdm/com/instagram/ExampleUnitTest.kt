package instagram.mpsdm.com.instagram

import io.reactivex.Observable
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 3)
    }

    var result = ""

    // Simple subscription to a fix value
    @Test
    fun returnAValue() {
        result = ""
        val observer = Observable.just("Hello") // provides data
        observer.subscribe({ s -> result = s }) // Callable as subscriber
        assertTrue(result == "Hello")
    }


}
