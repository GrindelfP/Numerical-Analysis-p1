package to.deepstorage.numericMethodsPartOne

import kotlin.math.cos
import kotlin.math.pow
import kotlin.math.sin

object Function {
    const val initialFunctionName = "f(x) = x - 4 * cos(x)^2 + 3"
    const val functionDerivativeName = "f'(x) = 1 + 4 * sin(2 * x)"

    fun initial(x: Double): Double = x - 4 * cos(x).pow(2) + 3

    fun derivative(x: Double): Double = 1 + 4 * sin(2 * x)
}
