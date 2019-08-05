import `31-40`.getQueenConfigurationsMain
import org.junit.Test

import org.junit.Assert.*

class Problem38KtTest {

    @Test
    fun getQueenConfigurationsMain_1() {
        assertEquals(0, getQueenConfigurationsMain(2))
    }

    @Test
    fun getQueenConfigurationsMain_2() {
        assertEquals(2, getQueenConfigurationsMain(4))
    }

    @Test
    fun getQueenConfigurationsMain_3() {
        assertEquals(10, getQueenConfigurationsMain(5))
    }

    @Test
    fun getQueenConfigurationsMain_4() {
        assertEquals(92, getQueenConfigurationsMain(8))
    }
}