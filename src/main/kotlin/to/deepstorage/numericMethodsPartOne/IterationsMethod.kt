package to.deepstorage.numericMethodsPartOne

import kotlin.math.abs
import to.deepstorage.numericMethodsPartOne.Function.derivative
import to.deepstorage.numericMethodsPartOne.Function.initial

object IterationsMethod {
    private const val MAX_NUMBER_OF_ITERATIONS: Int = 100
    private const val epsilon = 0.00001

    fun iterationsCalculation(edges: List<Edge>, initialGuesses: List<Double>): List<CalculationResult> {
        if (edges.count() != initialGuesses.count())
            throw IllegalArgumentException("The number of edges and the number of initial guesses must be equal.")
        val solutions = mutableListOf<CalculationResult>()
        edges.zip(initialGuesses).forEach { ( edge, initialGuess ) ->
            solutions.add(findRoot(edge.a, edge.b, initialGuess))
        }

        return solutions
    }

    private fun findRoot(a: Double, b: Double, initialGuess: Double): CalculationResult {
        var numberOfIterations = 0
        var x = initialGuess
        var xPrev: Double
        val tau = calculateOptimalTau(a, b)

        do {
            numberOfIterations++
            xPrev = x
            x = xPrev + tau * initial(xPrev)

        } while (!(abs(x - xPrev) < epsilon && abs(initial(x)) < epsilon))

        if (numberOfIterations >= MAX_NUMBER_OF_ITERATIONS)
            throw IllegalStateException("There were more than $MAX_NUMBER_OF_ITERATIONS iterations.")

        return CalculationResult(x, numberOfIterations)
    }

    private fun calculateOptimalTau(a: Double, b: Double): Double = when {
        derivative(a) > 0 && derivative(b) > 0 -> -2 / (derivative(a) + derivative(b))
        derivative(a) < 0 && derivative(b) < 0 -> 2 / abs(derivative(a) + derivative(b))
        else -> throw IllegalStateException("The derivative of the function must be positive on both edges.")
    }
}
