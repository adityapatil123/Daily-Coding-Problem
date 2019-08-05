import `31-40`.getEditDistance
import org.junit.Test

import org.junit.Assert.*

class Problem31KtTest {

    @Test
    fun getEditDistance_1() {
        assertEquals(3, getEditDistance("kitten", "sitting"))
    }

    @Test
    fun getEditDistance_2() {
        assertEquals(0, getEditDistance("", ""))
    }

    @Test
    fun getEditDistance_3() {
        assertEquals(3, getEditDistance("", "abc"))
    }
}