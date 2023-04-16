package inno.ppa

import WhilelangParser.*;
import WhilelangLexer
import WhilelangParser
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream

fun getInitializedVariables(statementContext: StatementContext): Set<String> {
    val initializedVariables = mutableSetOf<String>();
    when (statementContext) {
        is AttribContext -> {
            initializedVariables.add(statementContext.ID().text)
        }

        is IfContext -> {
            initializedVariables.addAll(getInitializedVariables(statementContext.statement()[0]))
            initializedVariables.addAll(getInitializedVariables(statementContext.statement()[1]))
        }
    }
}
}

fun getUsedVariables(statements: List<WhilelangParser.StatementContext>): Set<String> {
    var usedVariables = emptySet<String>()

    for (statement in statements) {
        when (statement) {
            is WhilelangParser.AttribContext ->{
                //TODO()
            }
            is WhilelangParser.WriteContext -> {
                //TODO()
            }
            is WhilelangParser.PrintContext -> {
                //TODO()
            }
            is WhilelangParser.IdContext -> {
                //TODO()
            }
            is WhilelangParser.IfContext -> {
                //TODO()
            }
            is WhilelangParser.WhileContext -> {
                //TODO()
            }
            is WhilelangParser.BlockContext -> {
                //TODO()
            }
            is WhilelangParser.SkipContext -> {
                //TODO()
            }
            is WhilelangParser.SeqStatementContext -> {
                //TODO()
            }
            else -> {
                throw Exception("Unknown statement type")
            }

        }
    }
}

fun main() {
    // Init part
    val cs = CharStreams.fromFileName("sample.while")
    val lexer = WhilelangLexer(cs)
    val stream = CommonTokenStream(lexer)
    val parser = WhilelangParser(stream)

    parser.program()
    parser.program()

    if (parser.numberOfSyntaxErrors == 0) {
        println("The input WHILE program is syntactically correct")
    } else {
        println(
            "The input WHILE program has " + parser.numberOfSyntaxErrors + " syntax errors"
        )
    }
}