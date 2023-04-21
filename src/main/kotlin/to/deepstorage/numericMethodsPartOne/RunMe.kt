package to.deepstorage.numericMethodsPartOne

import to.deepstorage.numericMethodsPartOne.GraphPlotting.plot
import to.deepstorage.numericMethodsPartOne.Function.initial
import to.deepstorage.numericMethodsPartOne.Function.derivative
import to.deepstorage.numericMethodsPartOne.Function.initialFunctionName
import to.deepstorage.numericMethodsPartOne.Function.functionDerivativeName
import to.deepstorage.numericMethodsPartOne.BisectionMethod.bisectionCalculation
import to.deepstorage.numericMethodsPartOne.IterationsMethod.iterationsCalculation

object RunMe {
    @JvmStatic
    fun main(args: Array<String>) {
        // graph plotting
        plot(function = ::initial, name = initialFunctionName)
        plot(function = ::derivative,  name = functionDerivativeName)

        // bisection method
        println("Bisection method is performed on function $initialFunctionName:\n" +
                bisectionCalculation(
                    edges = listOf(
                        Edge(-2.1, -1.9),
                        Edge(-0.8, -0.6),
                        Edge(0.3, 0.4)
                    )
                ))

        // simple iterations method
        println(
            "Simple iterations method is performed on function $initialFunctionName:\n" +
                    iterationsCalculation(
                        edges =  listOf(
                            Edge(-2.1, -1.9),
                            Edge(-0.8, -0.6),
                            Edge(0.3, 0.4)
                        ),
                        initialGuesses = listOf(-2.0, -0.7, 0.35)
                    )
        )
    }
}
