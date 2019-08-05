import `31-40`.getMediansFromStartToEnd
import org.junit.Test

import org.junit.Assert.*

class Problem33KtTest {

    @Test
    fun getMediansFromStartToEnd_1() {
        assertArrayEquals(arrayOf(2.0, 1.5, 2.0, 3.5, 2.0, 2.0, 2.0),
            getMediansFromStartToEnd(arrayOf(2, 1, 5, 7, 2, 0, 5))
        )
    }

    @Test
    fun getMediansFromStartToEnd_2() {
        assertArrayEquals(arrayOf(2.0), getMediansFromStartToEnd(arrayOf(2)))
    }

    @Test
    fun getMediansFromStartToEnd_3() {
        assertArrayEquals(emptyArray(), getMediansFromStartToEnd(emptyArray()))
    }
}