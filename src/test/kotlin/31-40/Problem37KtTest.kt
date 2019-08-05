import `31-40`.getPowerSet2
import org.junit.Test

import org.junit.Assert.*

class Problem37KtTest {

    @Test
    fun getPowerSet2_1() {
        assertArrayEquals(arrayOf(emptyArray<Int>()), getPowerSet2(emptyArray()))
    }

    @Test
    fun getPowerSet2_2() {
        assertArrayEquals(arrayOf(emptyArray<Int>(), arrayOf(1)), getPowerSet2(arrayOf(1)))
    }

    @Test
    fun getPowerSet2_3() {
        assertArrayEquals(arrayOf(emptyArray<Int>(), arrayOf(2), arrayOf(2,3), arrayOf(3),
            arrayOf(1), arrayOf(1,2), arrayOf(1,2,3), arrayOf(1,3)), getPowerSet2(arrayOf(1, 2, 3))
        )
    }
}