package inno.ppa

import WhilelangParser.*
import java.beans.Expression

fun getUsedVariables(statementContext: StatementContext): Set<String> {
    val usedVariables = mutableSetOf<String>()

    when (statementContext) {
        is AttribContext -> {
            usedVariables.addAll(getUsedVariables(statementContext.expression()))

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

fun getUsedVariablesInExpression(expression: ExpressionContext): Set<String> {
    val usedVariables = mutableSetOf<String>()
    when (expression) {
        is IdContext -> {
            usedVariables.add(expression.ID().text)
        }

        is ReadContext -> {
            //TODO()
        }

        is BoolContext -> {
            //TODO()
        }

        is IntContext -> {
            //TODO()
        }

        is BinOpContext -> {
            //TODO()
        }

        is ExpParenContext -> {
            //TODO()
        }

        is AndContext -> {
            //TODO()
        }

        else -> {
            throw Exception("Unknown expression type")
        }
    }
    return usedVariables
}