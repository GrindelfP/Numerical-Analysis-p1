package to.deepstorage.numericMethodsPartOne

object GraphPlotting {
    fun plot(function: (Double) -> Double, name: String) {
        val graph = Graph(function)
        graph.title = name
        graph.setSize(800,600)
        graph.isVisible = true
    }
}