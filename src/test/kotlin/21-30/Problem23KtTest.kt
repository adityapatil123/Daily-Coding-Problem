import `21-30`.getMinNoOfStepsInBoard
import org.junit.Test

import org.junit.Assert.*

class Problem23KtTest {

    @Test
    fun getMinNoOfStepsInBoard_1() {
        val boardOfBooleans = arrayOf(
            arrayOf(false, false, false, false),
            arrayOf(true, true, false, true),
            arrayOf(false, false, false, false),
            arrayOf(false, false, false, false)
        )
        val start = Pair(3,0)
        val end = Pair(0,0)

        assertEquals(7, getMinNoOfStepsInBoard(boardOfBooleans, start, end))
    }

    @Test
    fun getMinNoOfStepsInBoard_2() {
        val boardOfBooleans = arrayOf(
            arrayOf(false, false, false, false),
            arrayOf(true, true, false, true),
            arrayOf(false, false, false, false),
            arrayOf(false, false, false, false)
        )
        val start = Pair(0,0)
        val end = Pair(2,0)

        assertEquals(6, getMinNoOfStepsInBoard(boardOfBooleans, start, end))
    }

    @Test
    fun getMinNoOfStepsInBoard_3() {
        val boardOfBooleans = arrayOf(
            arrayOf(false, false, false, false),
            arrayOf(true, true, false, true),
            arrayOf(false, false, false, false),
            arrayOf(false, false, false, false)
        )
        val start = Pair(0,0)
        val end = Pair(0,0)

        assertEquals(0, getMinNoOfStepsInBoard(boardOfBooleans, start, end))
    }
}