import `21-30`.isBracketsBalanced
import org.junit.Test

import org.junit.Assert.*

class Problem27KtTest {

    @Test
    fun isBracketsBalanced_1() {
        assertEquals(true, isBracketsBalanced("([])[]({})"))
    }

    @Test
    fun isBracketsBalanced_2() {
        assertEquals(false, isBracketsBalanced("([)]"))
    }

    @Test
    fun isBracketsBalanced_3() {
        assertEquals(false, isBracketsBalanced("((()"))
    }
}