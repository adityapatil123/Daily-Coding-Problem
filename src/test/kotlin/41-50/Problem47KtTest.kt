import `41-50`.buyAtStockPrice
import org.junit.Test

import org.junit.Assert.*

class Problem47KtTest {

    @Test
    fun buyAtStockPrice_1() {
        assertEquals(5, buyAtStockPrice(arrayOf(9, 11, 8, 5, 7, 10)))
    }

    @Test
    fun buyAtStockPrice_2() {
        assertEquals(5, buyAtStockPrice(arrayOf(9, 11, 8, 5, 7, 10, 2)))
    }

    @Test
    fun buyAtStockPrice_3() {
        assertEquals(null, buyAtStockPrice(arrayOf(11, 8)))
    }

    @Test
    fun buyAtStockPrice_4() {
        assertEquals(null, buyAtStockPrice(emptyArray()))
    }
}