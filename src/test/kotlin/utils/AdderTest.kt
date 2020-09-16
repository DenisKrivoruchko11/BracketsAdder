package utils

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class AdderTest {

    @Test
    fun addShouldReturnsRightValueWhenCharsQuantityIsOddPlaceAroundEdgesTrueBracketsContainAllTypes() {
        val adder = Adder("Example")

        val expectedResult = "{E[x(a{m}p)l]e}"

        val addToMiddle = false
        val placeAroundEdges = true
        val brackets = listOf(Pair('{', '}'), Pair('[', ']'), Pair('(', ')'))

        assertEquals(expectedResult, adder.add(addToMiddle, placeAroundEdges, brackets))
    }

    @Test
    fun addShouldReturnsRightValueWhenCharsQuantityIsOddPlaceAroundEdgesTrueBracketsContainOneType() {
        val adder = Adder("a")

        val expectedResult = "(a)"

        val addToMiddle = false
        val placeAroundEdges = true
        val brackets = listOf(Pair('(', ')'))

        assertEquals(expectedResult, adder.add(addToMiddle, placeAroundEdges, brackets))
    }

    @Test
    fun addShouldReturnsRightValueWhenCharsQuantityIsOddPlaceAroundEdgesFalseBracketsContainAllTypes() {
        val adder = Adder("a")

        val expectedResult = "a"

        val addToMiddle = false
        val placeAroundEdges = false
        val brackets = listOf(Pair('{', '}'), Pair('[', ']'), Pair('(', ')'))

        assertEquals(expectedResult, adder.add(addToMiddle, placeAroundEdges, brackets))
    }

    @Test
    fun addShouldReturnsRightValueWhenCharsQuantityIsOddPlaceAroundEdgesFalseBracketsContainOneType() {
        val adder = Adder("Example")

        val expectedResult = "E{x{a{m}p}l}e"

        val addToMiddle = false
        val placeAroundEdges = false
        val brackets = listOf(Pair('{', '}'))

        assertEquals(expectedResult, adder.add(addToMiddle, placeAroundEdges, brackets))
    }

    @Test
    fun addShouldReturnsRightValueWhenCharsQuantityIsEvenAddToMiddleTruePlaceAroundEdgesTrueBracketsContainAllTypes() {
        val adder = Adder("Example1")

        val expectedResult = "{E[x(a{m[]p}l)e]1}"

        val addToMiddle = true
        val placeAroundEdges = true
        val brackets = listOf(Pair('{', '}'), Pair('[', ']'), Pair('(', ')'))

        assertEquals(expectedResult, adder.add(addToMiddle, placeAroundEdges, brackets))
    }

    @Test
    fun addShouldReturnsRightValueWhenCharsQuantityIsEvenAddToMiddleTruePlaceAroundEdgesTrueBracketsContainOneType() {
        val adder = Adder("ab")

        val expectedResult = "{a{}b}"

        val addToMiddle = true
        val placeAroundEdges = true
        val brackets = listOf(Pair('{', '}'))

        assertEquals(expectedResult, adder.add(addToMiddle, placeAroundEdges, brackets))
    }

    @Test
    fun addShouldReturnsRightValueWhenCharsQuantityIsEvenAddToMiddleTruePlaceAroundEdgesFalseBracketsContainAllTypes() {
        val adder = Adder("Example1")

        val expectedResult = "E[x(a{m[]p}l)e]1"

        val addToMiddle = true
        val placeAroundEdges = false
        val brackets = listOf(Pair('[', ']'), Pair('(', ')'), Pair('{', '}'))

        assertEquals(expectedResult, adder.add(addToMiddle, placeAroundEdges, brackets))
    }

    @Test
    fun addShouldReturnsRightValueWhenCharsQuantityIsEvenAddToMiddleTruePlaceAroundEdgesFalseBracketsContainOneType() {
        val adder = Adder("ab")

        val expectedResult = "a()b"

        val addToMiddle = true
        val placeAroundEdges = false
        val brackets = listOf(Pair('(', ')'))

        assertEquals(expectedResult, adder.add(addToMiddle, placeAroundEdges, brackets))
    }

    @Test
    fun addShouldReturnsRightValueWhenCharsQuantityIsEvenAddToMiddleFalsePlaceAroundEdgesTrueBracketsContainAllTypes() {
        val adder = Adder("ab")

        val expectedResult = "{ab}"

        val addToMiddle = false
        val placeAroundEdges = true
        val brackets = listOf(Pair('{', '}'), Pair('[', ']'), Pair('(', ')'))

        assertEquals(expectedResult, adder.add(addToMiddle, placeAroundEdges, brackets))
    }

    @Test
    fun addShouldReturnsRightValueWhenCharsQuantityIsEvenAddToMiddleFalsePlaceAroundEdgesTrueBracketsContainOneType() {
        val adder = Adder("Example1")

        val expectedResult = "(E(x(a(mp)l)e)1)"

        val addToMiddle = false
        val placeAroundEdges = true
        val brackets = listOf(Pair('(', ')'))

        assertEquals(expectedResult, adder.add(addToMiddle, placeAroundEdges, brackets))
    }

    @Test
    fun addShouldReturnsRightValueWhenCharsQuantityIsEvenAddToMiddleFalsePlaceAroundEdgesFalseBracketsContainAllTypes() {
        val adder = Adder("ab")

        val expectedResult = "ab"

        val addToMiddle = false
        val placeAroundEdges = false
        val brackets = listOf(Pair('{', '}'), Pair('[', ']'), Pair('(', ')'))

        assertEquals(expectedResult, adder.add(addToMiddle, placeAroundEdges, brackets))
    }

    @Test
    fun addShouldReturnsRightValueWhenCharsQuantityIsEvenAddToMiddleFalsePlaceAroundEdgesFalseBracketsContainOneType() {
        val adder = Adder("Example1")

        val expectedResult = "E{x{a{mp}l}e}1"

        val addToMiddle = false
        val placeAroundEdges = false
        val brackets = listOf(Pair('{', '}'))

        assertEquals(expectedResult, adder.add(addToMiddle, placeAroundEdges, brackets))
    }
}
