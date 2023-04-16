package inno.ppa

import WhilelangLexer
import WhilelangParser
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream

fun main(filepath: String) {
    // Init part
    val cs = CharStreams.fromFileName(filepath)
    val lexer = WhilelangLexer(cs)
    val stream = CommonTokenStream(lexer)
    val parser = WhilelangParser(stream)

    parser.program().highlightUnusedVars()

    if (parser.numberOfSyntaxErrors == 0) {
        println("The input WHILE program is syntactically correct")
    } else {
        println(
            "The input WHILE program has " + parser.numberOfSyntaxErrors + " syntax errors"
        )
    }
}
