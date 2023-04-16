package inno.ppa

import WhilelangParser.ProgramContext
import WhilelangParser.SeqStatementContext

fun ProgramContext.highlightUnusedVars() = seqStatement().highlightUnusedVars()

fun SeqStatementContext.highlightUnusedVars() {
    val allInitializedVars = statement()
        .flatMap { getInitializedVariables(it) }
        .toSet()
    val allUsedVars = statement()
        .flatMap { getUsedVariables(it) }
        .toSet()

    (allInitializedVars - allUsedVars).forEach {
        println("The variable is declared but unused: $it")
    }
}
