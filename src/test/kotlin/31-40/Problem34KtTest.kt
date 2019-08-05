import `31-40`.findPalindromeByAddingChars
import org.junit.Test

import org.junit.Assert.*

class Problem34KtTest {

    @Test
    fun findPalindromeByAddingChars_1() {
        assertEquals("elgoogle", findPalindromeByAddingChars("google"))
    }

    @Test
    fun findPalindromeByAddingChars_2() {
        assertEquals("ecarace", findPalindromeByAddingChars("race"))
    }

    @Test
    fun findPalindromeByAddingChars_3() {
        assertEquals("abcdcba", findPalindromeByAddingChars("abcda"))
    }
}