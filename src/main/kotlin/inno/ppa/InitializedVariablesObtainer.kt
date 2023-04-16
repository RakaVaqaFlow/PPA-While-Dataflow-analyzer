package inno.ppa

import WhilelangParser.*

fun getInitializedVariables(statementContext: StatementContext): Set<String> {
    val initializedVariables = mutableSetOf<String>()
    when (statementContext) {
        is AttribContext -> {
            initializedVariables.add(statementContext.ID().text)
        }

        is IfContext -> {
            initializedVariables.addAll(getInitializedVariables(statementContext.statement()[0]))
            initializedVariables.addAll(getInitializedVariables(statementContext.statement()[1]))
        }

        is WhileContext -> {
            initializedVariables.addAll(getInitializedVariables(statementContext.statement()))
        }

        is BlockContext -> {
            statementContext.seqStatement().statement().forEach {
                initializedVariables.addAll(getInitializedVariables(it))
            }
        }
    }
    return initializedVariables
}
