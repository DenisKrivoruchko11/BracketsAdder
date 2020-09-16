package utils

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.UnsupportedOperationException

class ParserTests {

    private val parser = Parser()

    @Test
    fun parseInputShouldThrowsKotlinNullPointerExceptionWhenStringIsEmpty() {
        assertThrows<KotlinNullPointerException> { parser.parseInput("") }
    }

    @Test
    fun parseInputShouldThrowsKotlinNullPointerExceptionWhenStringIsBlank() {
        assertThrows<KotlinNullPointerException> { parser.parseInput("   ") }
    }

    @Test
    fun parseInputShouldReturnsRightValueWhenStringIsCorrect() {
        assertEquals("Example", parser.parseInput(" Example  "))
    }

    @Test
    fun parseYesNoStringShouldThrowsKotlinNullPointerExceptionWhenStringIsEmpty() {
        assertThrows<KotlinNullPointerException> { parser.parseYesNoString("") }
    }

    @Test
    fun parseYesNoStringShouldThrowsKotlinNullPointerExceptionWhenStringIsBlank() {
        assertThrows<KotlinNullPointerException> { parser.parseYesNoString(" ") }
    }

    @Test
    fun parseYesNoStringShouldThrowsUnsupportedOperationExceptionWhenStringIsIncorrect() {
        assertThrows<UnsupportedOperationException> { parser.parseYesNoString("Example") }
    }

    @Test
    fun parseYesNoStringShouldReturnsTrueWhenStringIsYes() {
        assertTrue(parser.parseYesNoString("  Yes  "))
    }

    @Test
    fun parseYesNoStringShouldFalseTrueWhenStringIsNo() {
        assertFalse(parser.parseYesNoString("  No  "))
    }

    @Test
    fun parseBracketsListShouldThrowsKotlinNullPointerExceptionWhenStringIsEmpty() {
        assertThrows<KotlinNullPointerException> { parser.parseBracketsList("") }
    }

    @Test
    fun parseBracketsListShouldThrowsKotlinNullPointerExceptionWhenStringIsBlank() {
        assertThrows<KotlinNullPointerException> { parser.parseBracketsList("   ") }
    }

    @Test
    fun parseBracketsListShouldThrowsUnsupportedOperationExceptionWhenStringIsIncorrect() {
        assertThrows<UnsupportedOperationException> { parser.parseBracketsList("Example") }
    }

    @Test
    fun parseBracketsListShouldThrowsCloneNotSupportedExceptionWhenStringContainClones() {
        assertThrows<CloneNotSupportedException> { parser.parseBracketsList("  { [ {   ") }
    }

    @Test
    fun parseBracketsListShouldReturnsRightValueWhenStringContainAllTypesOfBrackets() {
        val expectedResult = listOf(Pair('{', '}'), Pair('[', ']'), Pair('(', ')'))
        val result = parser.parseBracketsList("{ [ (")

        assertEquals(expectedResult.size, result.size)

        for (i in 0..result.lastIndex) assertEquals(expectedResult[i], result[i])
    }

    @Test
    fun parseBracketsListShouldReturnsRightValueWhenStringContainOneTypeOfBrackets() {
        val expectedResult = listOf(Pair('{', '}'))
        val result = parser.parseBracketsList(" {   ")

        assertEquals(expectedResult.size, result.size)

        for (i in 0..result.lastIndex) assertEquals(expectedResult[i], result[i])
    }
}