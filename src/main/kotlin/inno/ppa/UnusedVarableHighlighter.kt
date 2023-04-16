package inno.ppa

import WhilelangParser.ProgramContext
import WhilelangParser.SeqStatementContext

fun ProgramContext.highlight() = seqStatement().highlight()

fun SeqStatementContext.highlight() = statement().forEach { statement ->
    val initializedVars = getInitializedVariables(statement)
    val usedVars = getUsedVariables(statement)

    val unusedVars = initializedVars - usedVars
    val usedButNotInitializedVars = usedVars - initializedVars

    usedButNotInitializedVars.forEach {
        println("The variable is used but was not declared: $it")
    }

    unusedVars.forEach {
        println("The variable is declared but not used: $it")
    }
}
