import org.junit.Assert.*
import org.junit.Test


class Problem7KtTest{
    @Test
    fun testProblem7_1(){
        assertEquals(3, getNoOfDecodingWays("111"))
    }

    @Test
    fun testProblem7_2(){
        assertEquals(1, getNoOfDecodingWays("876"))
    }

    @Test
    fun testProblem7_3(){
        assertEquals(1, getNoOfDecodingWays("4"))
    }
}