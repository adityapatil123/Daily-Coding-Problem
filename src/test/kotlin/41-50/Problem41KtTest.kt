import `41-50`.findBestItinerary
import org.junit.Test

import org.junit.Assert.*

class Problem41KtTest {

    @Test
    fun findBestItinerary_1() {
        assertArrayEquals(arrayOf("YUL", "YYZ", "SFO", "HKO", "ORD"),
            findBestItinerary(
                arrayOf(
                    Pair("SFO", "HKO"),
                    Pair("YYZ", "SFO"),
                    Pair("YUL", "YYZ"),
                    Pair("HKO", "ORD")
                ), "YUL"
            )
        )
    }

    @Test
    fun findBestItinerary_2() {
        assertArrayEquals(null, findBestItinerary(arrayOf(Pair("SFO", "HKO"), Pair("YYZ", "SFO")), "SFO"))
    }

    @Test
    fun findBestItinerary_3() {
        assertArrayEquals(arrayOf("A", "B", "C", "A", "C"),
            findBestItinerary(arrayOf(Pair("A", "B"), Pair("A", "C"), Pair("B", "C"), Pair("C", "A")), "A")
        )
    }
}