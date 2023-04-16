# Practical Program Analysis
## Assignment 2: Implement a Dataflow Analysis

### Team:
- Iskander Nafikov
- Eduard Zaripov
- Vagif Khalilov

### Task:

Implement data flow analysis for While programming language

### Solution:

#### Language

We have chosen the While programming language to practice with data flow analysis algorithms. This is a simple programming language that has only one loop instruction (while) and a single type (integer). 

Grammar of While language:

```

program : seqStatement;

seqStatement: statement (';' statement)* ;

statement: ID ':=' expression                          # attrib
         | 'skip'                                      # skip
         | 'if' bool 'then' statement 'else' statement # if
         | 'while' bool 'do' statement                 # while
         | 'print' Text                                # print
         | 'print' expression                          # write
         | '{' seqStatement '}'                        # block
         ;

expression: INT                                        # int
          | 'read'                                     # read
          | ID                                         # id
          | expression '*' expression                  # binOp
          | expression ('+'|'-') expression            # binOp
          | '(' expression ')'                         # expParen
          ;

bool: ('true'|'false')                                 # boolean
    | expression '=' expression                        # relOp
    | expression '<=' expression                       # relOp
    | 'not' bool                                       # not
    | bool 'and' bool                                  # and
    | '(' bool ')'                                     # boolParen
    ;

INT: ('0'..'9')+ ;
ID: ('a'..'z')+;
Text: '"' .*? '"';
Space: [ \t\n\r] -> skip;
```

Sample of While program:

```
print "Fibonacci Sequence";
a := 0;
b := 1;
while b <= 1000000 do {
  print b;
  b := a + b;
  a := b - a
}
```

#### DataFlow Analyzer

Our dataflow analyzer is an implementation of the dead code elimination method.

**What is dead code?**

Dead code can be described as any piece of code which will not get executed or is not reachable. By analyzing and eliminating dead code, we can identify redundant code that takes up resources and reduces the overall performance of the program. Removing unnecessary code can also reduce the risk of bugs or vulnerabilities, which contributes to the security of the program.

**How it is implemented?**

To implement this approach, we chose the kotlin programming language. With ANTLR we generated all the necessary files. Our algorithm traverses a concrete syntax tree and separately stores declared variables (`InitializedVariablesObtainer`) and variables that are used in various expressions (`UsedVariablesObtainer`).
If the program does not contain dead code, the two sets will be the same, which we get as a result of calling these functions. Otherwise, the program contains dead code

**Details**

*Domain:* Variable names

*Transfer functions:* print, :=, if, while

**Examples**

Program without dead code:
```
print "Enter the first number:";
a := read;
print "Enter the second number:";
b := read;
sum := a + b;
print "The sum is: ";
print sum
```
Result:
```
The input WHILE program is syntactically correct
```


Program with dead code:

```
print "Enter the first number:";
a := read;
print "Enter the second number:";
b := read;
sum := a;
print "The sum is: ";
print sum
```

Result:
```
The variable is declared but unused: b
The input WHILE program is syntactically correct
```

Also you can run tests for our solution: run `MainTest.kt`
