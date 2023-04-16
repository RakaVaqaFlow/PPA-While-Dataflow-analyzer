package inno.ppa

import WhilelangLexer
import WhilelangParser
import WhilelangParser.ProgramContext
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream


fun getInitializedVariables(program: ProgramContext): Set<String> {
    return emptySet()
}


fun getUsedVariables(program: ProgramContext): Set<String> {
    return emptySet()
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
