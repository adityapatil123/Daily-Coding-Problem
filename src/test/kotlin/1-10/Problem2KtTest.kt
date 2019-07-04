import org.junit.Assert.*
import org.junit.Test

class Problem2KtTest{
    @Test
    fun testProblem2_1(){
        assertArrayEquals(arrayOf(120,60,40,30,24), productOther2(arrayOf(1, 2, 3, 4, 5)))
    }

    @Test
    fun testProblem2_2(){
        assertArrayEquals(arrayOf(2,3,6), productOther2(arrayOf(3,2,1)))
    }

    @Test
    fun testProblem2_3(){
        assertArrayEquals(arrayOf(6,4), productOther2(arrayOf(4,6)))
    }
}