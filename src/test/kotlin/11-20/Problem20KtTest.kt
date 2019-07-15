import `11-20`.getIntersectedFirstElemValue
import org.junit.Test

import org.junit.Assert.*

class Problem20KtTest {

    @Test
    fun getIntersectedFirstElemValue_1() {
        assertEquals(1, getIntersectedFirstElemValue(arrayOf(1, 2, 3, 4), arrayOf(1, 2, 3)))
    }

    @Test
    fun getIntersectedFirstElemValue_2() {
        assertEquals(8, getIntersectedFirstElemValue(arrayOf(3, 7, 8, 10), arrayOf(99, 1, 8, 10)))
    }

    @Test
    fun getIntersectedFirstElemValue_3() {
        assertEquals(null, getIntersectedFirstElemValue(arrayOf(3, 7, 8, 10), arrayOf(99, 1, 45, 40)))
    }
}