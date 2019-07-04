import org.junit.Assert.*
import org.junit.Test


class Problem5KtTest{
    @Test
    fun testProblem5_car(){
        val pair = cons(1,2)
        assertEquals(car(pair),1)
    }

    @Test
    fun testProblem5_cdr(){
        val pair = cons(1,2)
        assertEquals(cdr(pair),2)
    }
}