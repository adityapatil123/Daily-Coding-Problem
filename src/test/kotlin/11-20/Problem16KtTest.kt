import org.junit.Assert.*
import org.junit.Test

class Problem16KtTest{

    @Test
    fun testProblem16_1(){
        record(1)
        record(2)
        record(3)
        assertEquals(2, getLast(1))
    }

    @Test
    fun testProblem16_2(){
        record(1)
        record(2)
        record(3)
        assertEquals(null, getLast(3))
    }
}

