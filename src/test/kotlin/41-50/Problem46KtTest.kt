import `41-50`.getMaxLengthPalindrome
import org.junit.Test

import org.junit.Assert.*

class Problem46KtTest {

    @Test
    fun getMaxLengthPalindrome_1() {
        assertEquals("bcdcb", getMaxLengthPalindrome("aabcdcb"))
    }

    @Test
    fun getMaxLengthPalindrome_2() {
        assertEquals("anana", getMaxLengthPalindrome("banana"))
    }

    @Test
    fun getMaxLengthPalindrome_3() {
        assertEquals("a", getMaxLengthPalindrome("a"))
    }
}