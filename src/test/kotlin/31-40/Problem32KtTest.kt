import `31-40`.isThereArbitrage
import org.junit.Test

class Problem32KtTest {

    @Test
    fun isThereArbitrage_1() {
        assert(isThereArbitrage(arrayOf(arrayOf(1, 2), arrayOf(2, 1)))) // true
    }

    @Test
    fun isThereArbitrage_2() {
        assert(!isThereArbitrage(arrayOf(arrayOf(1, 1), arrayOf(1, 1)))) // false
    }
}