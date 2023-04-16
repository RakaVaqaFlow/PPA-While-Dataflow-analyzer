package inno.ppa

import WhilelangParser.*
fun getUsedVariables(statementContext: StatementContext): Set<String> {
    val usedVariables = emptySet<String>()

    val tokens =
        when (statementContext) {
            is AttribContext ->{
                statementContext.expression()

            }
            is WriteContext -> {
                //TODO()
            }
            is PrintContext -> {
                //TODO()
            }
            is IdContext -> {
                //TODO()
            }
            is IfContext -> {
                //TODO()
            }
            is WhileContext -> {
                //TODO()
            }
            is BlockContext -> {
                //TODO()
            }
            is SkipContext -> {
                //TODO()
            }
            is SeqStatementContext -> {
                //TODO()
            }
            else -> {
                throw Exception("Unknown statement type")
            }
        }
    return usedVariables
}