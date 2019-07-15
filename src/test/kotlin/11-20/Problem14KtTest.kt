import `11-20`.estimatePiByOrder
import `11-20`.estimatePiRandom
import org.junit.Test

import org.junit.Assert.*

class Problem14KtTest {

    @Test
    fun estimatePi() {
        assertEquals(3.141, estimatePiByOrder(1000))
    }

    @Test
    fun estimatePiGivenNPts() {
        assertEquals(3.141, estimatePiRandom(20000000))
    }
}