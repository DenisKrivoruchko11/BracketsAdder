package utils

private fun getBracketsList(input: String): MutableList<Pair<Char, Char>> {
    val result = mutableListOf<Pair<Char, Char>>()

    input.trim().split(" ").forEach {
        if (it != "(" && it != "[" && it != "{") {
            throw UnsupportedOperationException("String must be correct (Contain only '(', '[' or '{').")
        }

        val openBracket = it.first()
        val closeBracket = when (it.first()) {
            '(' -> ')'
            '[' -> ']'
            else -> '}'
        }

        if (result.contains(Pair(openBracket, closeBracket))) {
            throw CloneNotSupportedException("String must not contain clones.")
        }

        result.add(Pair(openBracket, closeBracket))
    }

    return result
}

class Parser {

    fun parseInput(input: String?): String {
        if (input.isNullOrBlank()) throw KotlinNullPointerException("String must be non-empty.")

        return input.trim()
    }

    fun parseYesNoString(input: String?): Boolean {
        if (input.isNullOrBlank()) throw KotlinNullPointerException("String must be non-empty.")

        return when (input.trim()) {
            "Yes" -> true
            "No" -> false
            else -> throw UnsupportedOperationException("String must be correct (Yes/No).")
        }
    }

    fun parseBracketsList(input: String?): List<Pair<Char, Char>> {
        if (input.isNullOrBlank()) throw KotlinNullPointerException("String must be non-empty.")

        return getBracketsList(input)
    }
}
