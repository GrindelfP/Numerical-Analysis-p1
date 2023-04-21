package to.deepstorage.numericMethodsPartOne

/**
 * Container-type for storing results of calculations as well, as the number of operations
 */
data class CalculationResult ( val result: Double, val numberOfOperations: Int ) {
    override fun toString(): String =
        "The root is %.6f".format(result) + "; there was %d divisions".format(numberOfOperations)
}
