import `21-30`.justifyText
import org.junit.Test

import org.junit.Assert.*

class Problem28KtTest {

    @Test
    fun justifyText_1() {
        assertArrayEquals(arrayOf("the  quick brown",
                "fox  jumps  over",
        "the   lazy   dog"),
            justifyText(arrayOf("the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"), 16)
        )
    }

    @Test
    fun justifyText_2() {
        assertArrayEquals(arrayOf("this  man"),
            justifyText(arrayOf("this", "man"), 9)
        )
    }

    @Test
    fun justifyText_3() {
        assertArrayEquals(arrayOf("this "),
            justifyText(arrayOf("this"), 5)
        )
    }
}