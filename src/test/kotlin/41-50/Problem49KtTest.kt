import `41-50`.getMaxSumContiguousSubarray
import org.junit.Test

import org.junit.Assert.*

class Problem49KtTest {

    @Test
    fun getMaxSumContiguousSubarray_1() {
        assertEquals(137, getMaxSumContiguousSubarray(arrayOf(34, -50, 42, 14, -5, 86)))
    }

    @Test
    fun getMaxSumContiguousSubarray_2() {
        assertEquals(0, getMaxSumContiguousSubarray(arrayOf(-5, -1, -8, -9)))
    }
}