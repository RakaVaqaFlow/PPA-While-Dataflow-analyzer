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
