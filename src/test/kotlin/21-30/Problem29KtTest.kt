import org.junit.Test

import org.junit.Assert.*

class Problem29KtTest {

    @Test
    fun encodeString() {
        assertEquals("4A3B2C1D2A", `21-30`.encodeString("AAAABBBCCDAA"))
    }

    @Test
    fun decodeString() {
        assertEquals("AAAABBBCCDAA", `21-30`.decodeString("4A3B2C1D2A"))
    }
}