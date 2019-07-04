import org.junit.Assert.*
import org.junit.Test

class Problem9KtTest{
    @Test
    fun testProblem9_1(){
        assertEquals(13, largestSumNonAdjacent(arrayOf(2,4,6,2,5)))
    }

    @Test
    fun testProblem9_2(){
        assertEquals(10, largestSumNonAdjacent(arrayOf(5,1,1,5)))
    }

    @Test
    fun testProblem9_3(){
        assertEquals(-5, largestSumNonAdjacent(arrayOf(-5)))
    }

    @Test
    fun testProblem9_4(){
        assertEquals(null, largestSumNonAdjacent(emptyArray()))
    }
}