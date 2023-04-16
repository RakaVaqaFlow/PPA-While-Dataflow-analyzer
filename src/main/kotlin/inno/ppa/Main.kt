package inno.ppa

import WhilelangParser.*
import WhilelangLexer
import WhilelangParser
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream

fun getUsedVariables(statementContext: StatementContext): Set<String> {
    val usedVariables = emptySet<String>()
    when (statementContext) {
        is AttribContext ->{
            //TODO()
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

fun main() {
    // Init part
    val cs = CharStreams.fromFileName("sample.while")
    val lexer = WhilelangLexer(cs)
    val stream = CommonTokenStream(lexer)
    val parser = WhilelangParser(stream)

    parser.program()

    if (parser.numberOfSyntaxErrors == 0) {
        println("The input WHILE program is syntactically correct")
    } else {
        println(
            "The input WHILE program has " + parser.numberOfSyntaxErrors + " syntax errors"
        )
    }
}
