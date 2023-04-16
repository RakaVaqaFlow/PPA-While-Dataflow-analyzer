package inno.ppa

import WhilelangParser.ProgramContext
import WhilelangParser.SeqStatementContext

fun ProgramContext.highlightUnusedVars() = seqStatement().highlightUnusedVars()

fun ProgramContext.highlightUndeclaredVars() = seqStatement().highlightUndeclaredVars()

fun SeqStatementContext.getInitializedAndUsed(): Pair<Set<String>, Set<String>> {
    val allInitializedVars = statement()
        .flatMap { getInitializedVariables(it) }
        .toSet()
    val allUsedVars = statement()
        .flatMap { getUsedVariables(it) }
        .toSet()

    return allInitializedVars to allUsedVars
}

fun SeqStatementContext.highlightUnusedVars() {
    getInitializedAndUsed().also { (initializedVars, usedVars) ->
        (initializedVars - usedVars).forEach {
            println("The variable is declared but unused: $it")
        }
    }
}
fun SeqStatementContext.highlightUndeclaredVars() {
    getInitializedAndUsed().also { (initializedVars, usedVars) ->
        (usedVars - initializedVars).forEach {
            println("The variable is used but undeclared: $it")
        }
    }
}
