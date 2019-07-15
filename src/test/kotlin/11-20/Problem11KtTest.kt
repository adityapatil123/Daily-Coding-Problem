import `11-20`.autoComplete
import org.junit.Test

import org.junit.Assert.*

class Problem11KtTest {

    @Test
    fun autoComplete_1() {
        assertArrayEquals(arrayOf( "deer", "deal"), autoComplete("de", arrayOf("dog", "deer", "deal")))
    }

    @Test
    fun autoComplete_2() {
        assertArrayEquals(arrayOf("dog", "deer", "deal"), autoComplete("d", arrayOf("dog", "deer", "deal")))
    }
}