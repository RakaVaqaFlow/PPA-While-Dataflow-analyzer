package inno.ppa

import WhilelangParser.*

fun getUsedVariables(statementContext: StatementContext): Set<String> {
    val usedVariables = mutableSetOf<String>()

    when (statementContext) {
        is AttribContext -> {
            usedVariables.addAll(getUsedVariablesInExpression(statementContext.expression()))
        }

        is IfContext -> {
            usedVariables.addAll(getUsedVariablesInBool(statementContext.bool()))
            usedVariables.addAll(getUsedVariables(statementContext.statement()[0]))
            usedVariables.addAll(getUsedVariables(statementContext.statement()[1]))
        }

        is WhileContext -> {
            usedVariables.addAll(getUsedVariablesInBool(statementContext.bool()))
            usedVariables.addAll(getUsedVariables(statementContext.statement()))
        }

        is WriteContext -> {
            usedVariables.addAll(getUsedVariablesInExpression(statementContext.expression()))
        }

        is BlockContext -> {
            statementContext.seqStatement().statement().forEach {
                usedVariables.addAll(getInitializedVariables(it))
            }
        }
    }

    return usedVariables
}


private fun getUsedVariablesInBool(expression: BoolContext): Set<String> {
    val usedVariables = mutableSetOf<String>()
    when (expression) {
        is RelOpContext -> {
            usedVariables.addAll(getUsedVariablesInExpression(expression.expression()[0]))
            usedVariables.addAll(getUsedVariablesInExpression(expression.expression()[1]))
        }

        is NotContext -> {
            usedVariables.addAll(getUsedVariablesInBool(expression.bool()))
        }

        is AndContext -> {
            usedVariables.addAll(getUsedVariablesInBool(expression.bool()[0]))
            usedVariables.addAll(getUsedVariablesInBool(expression.bool()[1]))
        }

        is BoolParenContext -> {
            usedVariables.addAll(getUsedVariablesInBool(expression.bool()))
        }
    }
    return usedVariables
}

private fun getUsedVariablesInExpression(expression: ExpressionContext): Set<String> {
    val usedVariables = mutableSetOf<String>()
    when (expression) {
        is IdContext -> {
            usedVariables.add(expression.ID().text)
        }

        is BinOpContext -> {
            usedVariables.addAll(getUsedVariablesInExpression(expression.expression()[0]))
            usedVariables.addAll(getUsedVariablesInExpression(expression.expression()[1]))
        }

        is ExpParenContext -> {
            usedVariables.addAll(getUsedVariablesInExpression(expression.expression()))
        }
    }

    return usedVariables
}