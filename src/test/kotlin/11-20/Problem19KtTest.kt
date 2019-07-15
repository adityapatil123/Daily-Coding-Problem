import `11-20`.getMinColoringOfHomes
import org.junit.Test

import org.junit.Assert.*

class Problem19KtTest {

    @Test
    fun getMinColoringOfHomes_1() {
        val matrix = arrayOf(arrayOf(4,1,5,3), arrayOf(5,2,4,3))
        assertEquals(4, getMinColoringOfHomes(matrix))
    }

    @Test
    fun getMinColoringOfHomes_2() {
        val matrix = arrayOf(
            arrayOf(7, 3, 8, 6, 1, 2),
            arrayOf(5, 6, 7, 2, 4, 3),
            arrayOf(10, 1, 4, 9, 7, 6)
        )
        assertEquals(4, getMinColoringOfHomes(matrix))
    }

    @Test
    fun getMinColoringOfHomes_3() {
        val matrix = arrayOf(
            arrayOf(7, 3, 8, 6, 1, 2),
            arrayOf(5, 6, 7, 2, 4, 3),
            arrayOf(10, 1, 4, 9, 7, 6),
            arrayOf(10, 1, 4, 9, 7, 6)
        )
        assertEquals(8, getMinColoringOfHomes(matrix))
    }
}