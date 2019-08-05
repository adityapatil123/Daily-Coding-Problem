import `31-40`.segregateRGB
import org.junit.Test

import org.junit.Assert.*

class Problem35KtTest {

    @Test
    fun segregateRGB_1() {
        assertArrayEquals(arrayOf('R', 'G'), segregateRGB(arrayOf('G', 'R')))
    }

    @Test
    fun segregateRGB_2() {
        assertArrayEquals(arrayOf('R', 'G', 'B'), segregateRGB(arrayOf('G', 'B', 'R')))
    }

    @Test
    fun segregateRGB_3() {
        assertArrayEquals(arrayOf('R', 'G', 'B'), segregateRGB(arrayOf('B', 'G', 'R')))
    }

    @Test
    fun segregateRGB_4() {
        assertArrayEquals(arrayOf('R', 'R', 'R', 'G', 'G', 'B', 'B'),
            segregateRGB(arrayOf('G', 'B', 'R', 'R', 'B', 'R', 'G'))
        )
    }
}