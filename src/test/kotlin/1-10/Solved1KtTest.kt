import org.junit.Assert.*
import org.junit.Test

class Solved1KtTest{
    @Test
    fun testProblemE_1(){
        val listOfLists1 = arrayOf(arrayOf(10, 15, 30), arrayOf(12, 15, 20), arrayOf(17, 20, 32))
        assertArrayEquals(arrayOf(10, 12, 15, 15, 17, 20, 20, 30, 32), sortAndMerge(listOfLists1))
    }

    @Test
    fun testProblemE_2(){
        val listOfLists3 = arrayOf(arrayOf(1,2), emptyArray())
        val listOfLists2:Array<Array<Int>> = emptyArray()
        assertArrayEquals(emptyArray(), sortAndMerge(listOfLists2))
    }

    @Test
    fun testProblemE_3(){
        val listOfLists3:Array<Array<Int>> = arrayOf(emptyArray(), emptyArray(),emptyArray())
        assertArrayEquals(emptyArray(), sortAndMerge(listOfLists3))
    }

    @Test
    fun testProblemE_4(){
        val listOfLists4 = arrayOf(emptyArray(), arrayOf(1), arrayOf(1,2))
        assertArrayEquals(arrayOf(1,1,2), sortAndMerge(listOfLists4))
    }

    @Test
    fun testProblemE_5(){
        val listOfLists5 = arrayOf(arrayOf(1))
        assertArrayEquals(arrayOf(1), sortAndMerge(listOfLists5))
    }

    @Test
    fun testProblemE_6(){
        val listOfLists6 = arrayOf(arrayOf(1), arrayOf(1, 3, 5), arrayOf(1, 10, 20, 30, 40))
        assertArrayEquals(arrayOf(1,1,1,3,5,10,20,30,40), sortAndMerge(listOfLists6))
    }
}