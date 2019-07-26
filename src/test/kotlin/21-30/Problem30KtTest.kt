import `21-30`.getSpotsFilled
import org.junit.Test

import org.junit.Assert.*

class Problem30KtTest {

    @Test
    fun getSpotsFilled_1() {
        assertEquals(1, getSpotsFilled(arrayOf(2, 1, 2)))
    }

    @Test
    fun getSpotsFilled_2() {
        assertEquals(8, getSpotsFilled(arrayOf(3, 0, 1, 3, 0, 5)))
    }
}