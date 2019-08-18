import `41-50`.getOutOfOrderNumber
import org.junit.Test

import org.junit.Assert.*

class Problem44KtTest {

    @Test
    fun getOutOfOrderNumber_1() {
        assertEquals(0, getOutOfOrderNumber(arrayOf(1, 3, 5, 7, 10)))
    }

    @Test
    fun getOutOfOrderNumber_2() {
        assertEquals(3, getOutOfOrderNumber(arrayOf(2, 4, 1, 3, 5)))
    }

    @Test
    fun getOutOfOrderNumber_3() {
        assertEquals(10, getOutOfOrderNumber(arrayOf(5, 4, 3, 2, 1)))
    }

    @Test
    fun getOutOfOrderNumber_4() {
        assertEquals(0, getOutOfOrderNumber(arrayOf(5)))
    }

    @Test
    fun getOutOfOrderNumber_5() {
        assertEquals(0, getOutOfOrderNumber(emptyArray<Int>()))
    }
}