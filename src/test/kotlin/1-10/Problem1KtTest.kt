import org.junit.Assert.*
import org.junit.Test

class Problem1KtTest{
    @Test
    fun testProblem1_1(){
        assertEquals(true, addUptoK2(arrayOf(10, 15, 3, 7),17))
    }

    @Test
    fun testProblem1_2(){
        assertEquals(false, addUptoK2(emptyArray(),17))
    }

    @Test
    fun testProblem1_3(){
        assertEquals(true, addUptoK2(arrayOf(10, 10),20))
    }
}