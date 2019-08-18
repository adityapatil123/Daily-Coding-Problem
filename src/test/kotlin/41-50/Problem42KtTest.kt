import `41-50`.getSubsetWithSumK
import org.junit.Test

import org.junit.Assert.*

class Problem42KtTest {

    @Test
    fun getSubsetWithSumK_1() {
        assertArrayEquals(arrayOf(12, 1, 9, 2), getSubsetWithSumK(arrayOf(12, 1, 61, 5, 9, 2), 24))
    }

    @Test
    fun getSubsetWithSumK_2() {
        assertArrayEquals(arrayOf(12), getSubsetWithSumK(arrayOf(12), 12))
    }

    @Test
    fun getSubsetWithSumK_3() {
        assertArrayEquals(null, getSubsetWithSumK(emptyArray(), 12))
    }

    @Test
    fun getSubsetWithSumK_4() {
        assertArrayEquals(null, getSubsetWithSumK(arrayOf(1, 2, 3), 12))
    }
}