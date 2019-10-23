import org.junit.jupiter.api.Test

internal class MatrixTest {

    val a = Matrix(3)
    val b = Matrix(3)
    val d = Matrix(3)
    val c = doubleArrayOf(1.0, 2.0, 3.0)

    init {
        a.setElements(
            1, 2, 3,
            4, 5, 6,
            7, 8, 9
        )
        b.setElements(
            1, 1, 1,
            1, 1, 1,
            1, 1, 1
        )
        d.setElements(
            1, 0, 0,
            0, 5, 0,
            0, 0, 2
        )
    }

    @Test
    fun plus() {
        val res = Matrix(3)
        res.setElements(
            2, 3, 4,
            5, 6, 7,
            8, 9, 10
        )
        assert(a + b == res)
    }

    @Test
    fun minus() {
        val res = Matrix(3)
        res.setElements(
            0, 1, 2,
            3, 4, 5,
            6, 7, 8
        )
        assert(a - b == res)
    }

    @Test
    fun times() {
        val res = Matrix(3)
        res.setElements(
            6, 6, 6,
            15, 15, 15,
            24, 24, 24
        )
        assert(a * b == res)
    }

    @Test
    fun testVector() {
        val res = doubleArrayOf(14.0, 32.0, 50.0)
        assert((a * c).contentEquals(res))
    }

    @Test
    fun invert() {
        val res = Matrix(3)
        res.setElements(
            1.0, 0, 0,
            0, 0.2, 0,
            0, 0, 0.5
        )
        val sub = Matrix(d)
        sub.invert()
        assert(sub == res)
    }

    @Test
    fun getDiagonal() {
        val sub = a.getDiagonal()
        val res = Matrix(3)
        res.setElements(
            1, 0, 0,
            0, 5, 0,
            0, 0, 9
        )
        assert(sub == res)
    }

    @Test
    fun equals() {
        val sub = Matrix(3)
        sub.setElements(
            1, 2, 3,
            4, 5, 6,
            7, 8, 9
        )
        assert(sub == a)
        assert(sub != b)
    }

    @Test
    fun getUpperTriangle() {
        val res = Matrix(3)
        res.setElements(
            0, 2, 3,
            0, 0, 6,
            0, 0, 0
        )
        assert(a.getUpperTriangle() == res)
    }

    @Test
    fun getLowerTriangle() {
        val res = Matrix(3)
        res.setElements(
            0, 0, 0,
            4, 0, 0,
            7, 8, 0
        )
        assert(a.getLowerTriangle() == res)
    }
}