import `21-30`.originalSentenceInList2
import org.junit.Test

import org.junit.Assert.*

class Problem22KtTest {

    @Test
    fun originalSentenceInList_1() {
        val string = "thequickbrownfox"
        val array = arrayOf("quick", "brown", "the", "fox")
        assertArrayEquals(arrayOf("the", "quick", "brown", "fox"), originalSentenceInList2(array, string))
    }

    @Test
    fun originalSentenceInList_2() {
        val string = "bedbathandbeyond"
        val array = arrayOf("bed", "bath", "bedbath", "and", "beyond")
        assertArrayEquals(arrayOf("bed", "bath", "and", "beyond"), originalSentenceInList2(array, string))
    }
}