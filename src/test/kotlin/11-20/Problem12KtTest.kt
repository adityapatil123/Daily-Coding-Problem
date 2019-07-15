import org.junit.Test

import org.junit.Assert.*

class Problem12KtTest {

    @Test
    fun getStepsFor1_2() {
        assertEquals(5,getStepsFor1_2(4))
    }

    @Test
    fun getStepsForAny() {
        assertEquals(7,getStepsForAny(4, arrayOf(1,2,3)))
    }
}