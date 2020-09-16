package utils

class Adder(private val input: String) {

    fun add(addToMiddle: Boolean, placeAroundEdges: Boolean, brackets: List<Pair<Char, Char>>): String {
        val firstHalfBuilder = StringBuilder()
        val secondHalfBuilder = StringBuilder()

        var bracketsNumber = 0

        if (placeAroundEdges) {
            firstHalfBuilder.append(brackets[bracketsNumber % brackets.size].first)
            secondHalfBuilder.append(brackets[bracketsNumber % brackets.size].second)

            bracketsNumber++
        }

        val steps = input.length / 2 + input.length % 2

        for (i in 0 until steps) {
            if (i < steps - 1 || addToMiddle) {
                firstHalfBuilder.append("${input[i]}${brackets[bracketsNumber % brackets.size].first}")
                secondHalfBuilder
                    .append("${input[input.lastIndex - i]}${brackets[bracketsNumber % brackets.size].second}")

                bracketsNumber++
            } else {
                firstHalfBuilder.append("${input[i]}")

                if (i != input.lastIndex - i) secondHalfBuilder.append("${input[input.lastIndex - i]}")
            }
        }

        return firstHalfBuilder.toString() + secondHalfBuilder.toString().reversed()
    }
}
