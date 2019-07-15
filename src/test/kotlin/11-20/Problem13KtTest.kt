import `11-20`.getMaxSubstringFromK
import org.junit.Test

import org.junit.Assert.*

class Problem13KtTest {

    @Test
    fun getMaxSubstringFromK_1() {
        assertEquals("bcb", getMaxSubstringFromK("abcba", 2))
    }

    @Test
    fun getMaxSubstringFromK_2() {
        assertEquals("aab", getMaxSubstringFromK("aabcba", 2))
    }

    @Test
    fun getMaxSubstringFromK_3() {
        assertEquals("abab", getMaxSubstringFromK("abab", 5))
    }
}