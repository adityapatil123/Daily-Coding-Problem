import org.junit.Assert.*
import org.junit.Test

class Problem4KtTest{
    @Test
    fun testProblem4_1(){
        assertEquals(2, getMinPosAbsent2(arrayOf(3, 4, -1, 1)))
    }

    @Test
    fun testProblem4_2(){
        assertEquals(3, getMinPosAbsent2(arrayOf(1, 2, 0)))
    }
}