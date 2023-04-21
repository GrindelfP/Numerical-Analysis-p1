package to.deepstorage.numericMethodsPartOne

import kotlin.math.abs

object BisectionMethod {
    private const val epsilon = 0.00001

    fun bisectionCalculation(edges: List<Edge>): List<CalculationResult> {
        val solutions = mutableListOf<CalculationResult>()
        edges.forEach {
            solutions.add(getSolution(it.a, it.b))
        }

        return solutions
    }

    private fun edgesAreApartEnough(a: Double, b: Double): Boolean = abs(b - a) >= epsilon

    private fun edgesProductSign(left: Double, right: Double): Double = Function.initial(left) * Function.initial(right)

    private fun getSolution(aP: Double, bP: Double): CalculationResult {
        var a = aP
        var b = bP
        var c = 0.0
        var numberOfDivisions = 0
        var edgesAreDistanced = true
        while (edgesAreApartEnough(a, b) && edgesAreDistanced) {
            c = (a + b) / 2
            numberOfDivisions++
            if (edgesProductSign(a, c) < 0) b = c
            else if (edgesProductSign(c, b) < 0) a = c
            else edgesAreDistanced = false
        }

        return if (edgesAreDistanced) CalculationResult((a + b) / 2, numberOfDivisions)
        else CalculationResult(c, numberOfDivisions)
    }
}
