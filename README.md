# Compiler-Construction---Lexical-Analyzer
The was my final Compiler Construction project. This project basically scans the source file finds lexmes and identify the tokens. These token are then stored in symbol table.

I was assigned these requirements by my teacher Sir Khawaja:
# Project Step - 1
• Write a program in java that reads its input from the following file: “C:/temp/sourcecode.txt” • The program then prints each character of the input file on a separate line on the screen.

# Project Step - 2
Add following code to your project: • Your program should eliminate the comments enclosed in /* and */ or following // on the same line. • Your program should eliminate the white spaces (blank, tab or newline). (Eliminate means you should ignore and do not do anything about them)

#  Project Step - 3
• Add code to your project to recognize the Relational Operators <, <=, ==, <>, >= and > (use the logic similar to the code given in figure 3.18). • Whenever any of these relational operators are matched, your project should also print the token name “relop” and the attribute value LT, LE, EQ, NE, GE or GT respectively (after printing the relational operator.

# Project Step - 4
• Add code to your project to recognize: • Arithmetic Operators (arop): +, -, *, / • Other Operators (otop): assignment: =, parenthesis: (, ), braces: {, }, line terminator: ; . • Whenever any of the above operators are matched, your project should also print the respective token name “arop” or “otop” and the attribute value ADD, SUB, MUL, DIV, ASN, LPRN, RPRN, LBRC, RBRC or LNTR respectively (after printing the relational operator).

#  #Project Step - 5
• Add code to your project to recognize: • Keywords (keyword): begin, end, if, then, else, int, float, char, string • Identifiers (id): letter followed by zero or more letters or digits. • Whenever any of the above tokens are matched, your project should also print the respective token name “keyword” or “id” and for keywords, some attribute value (any numeric value for now) after printing the lexeme.

# Project Step - 6
• Add code to your project to recognize: • Unsigned Integer (uint): unsigned integer value • String Literal: (sliteral): anything that is surrounded by double quotes (“ ’s) • Whenever any of the above tokens are matched, your project should also print the respective token name (“uint” or “sliteral”) and the attribute value (the unsigned integer value or the string literal value) after printing the lexeme. • If the input (source code to be compiled) to your project (compiler) contains something other than the comments, white spaces or the lexemes mentioned above or in previous project steps, then your compiler should generate and display the error with: • The line number • The unrecognized lexeme in the source code and • A meaningful error message

#  Project Step - 7
• Add code to your project to • Create a symbol table to store tokens in it • Every time you recognize a lexeme, you need to decide whether you want to store the token in the symbol table or not and then if needed, you store it. • One way is to keep symbol table in the form of an array of objects that store token name, type and attribute value. (if you like you can use any other type of data structure) • Before exiting, your program should print out the tokens stored in the symbol table.

#  Project Step - 8
• Add the code to your project to store the data of:

The productions of the given grammar.
The parsing table. • Print the data of the productions and the parsing table.
