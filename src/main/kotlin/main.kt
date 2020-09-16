import utils.Adder
import utils.Parser

private fun start() {
    val parser = Parser()

    println("Type your string:")
    val input = parser.parseInput(readLine())

    val addToMiddle = if (input.length % 2 == 0) {
        println("Add brackets to the middle? (Yes/No)")

        parser.parseYesNoString(readLine())
    } else false

    println("Place brackets around the edges? (Yes/No)")
    val placeAroundEdges = parser.parseYesNoString(readLine())

    println("Type brackets to insert (Separated by space)")
    val brackets = parser.parseBracketsList(readLine())

    println("Result string:")
    println(Adder(input).add(addToMiddle, placeAroundEdges, brackets))
}

fun main() {
    try {
        start()
    } catch (e: KotlinNullPointerException) {
        println(e.message)
    } catch (e: UnsupportedOperationException) {
        println(e.message)
    } catch (e: CloneNotSupportedException) {
        println(e.message)
    } finally {
        println("Program stopped.")
    }
}
