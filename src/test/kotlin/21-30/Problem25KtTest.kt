import `21-30`.checkIfStringMatchesExpression
import org.junit.Test

import org.junit.Assert.*

class Problem25KtTest {

    @Test
    fun checkIfStringMatchesExpression_1() {
        assertEquals(true, checkIfStringMatchesExpression("ra.", "ray"))
    }

    @Test
    fun checkIfStringMatchesExpression_2() {
        assertEquals(false, checkIfStringMatchesExpression("ra.", "raymond"))
    }

    @Test
    fun checkIfStringMatchesExpression_3() {
        assertEquals(true, checkIfStringMatchesExpression(".*at", "chat"))
    }

    @Test
    fun checkIfStringMatchesExpression_4() {
        assertEquals(false, checkIfStringMatchesExpression(".*at", "chats"))
    }

    @Test
    fun checkIfStringMatchesExpression_5() {
        assertEquals(false, checkIfStringMatchesExpression("", "chats"))
    }

    @Test
    fun checkIfStringMatchesExpression_6() {
        assertEquals(true, checkIfStringMatchesExpression(".*", "chats"))
    }
}