package inno.ppa

import WhilelangParser.ProgramContext
import WhilelangParser.SeqStatementContext

fun ProgramContext.highlight() = seqStatement().highlight()

fun SeqStatementContext.highlight() = statement().forEach { statement ->
    val initializedVars = getInitializedVariables(statement)
    val usedVars = getUsedVariables(statement)

    val unusedVars = initializedVars - usedVars

    unusedVars.forEach { unusedVar ->
        println("The variable is declared but not used: $unusedVar")
    }
}
