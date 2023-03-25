# Caps #
## Grammar Definition ##
```
var is a variable
string is a string
number is a number (integer or double)
methodname is the name of a method
vars ::= [var (`,` var)* ] list of variables
type::= `STRING` | `NUMBER` | `BOOLEAN` built-in datatypes 
`(` types `)` `RETURNS` type higher-order function type
types::= [type (`,` type)*] list of types
op ::= `+` | `-` | `*` | `/` | `&&` | `||` | `<` arithmetic operations
exp ::= var | string | number variables, strings, and numbers are expressions
	exp op exp arithmetic expressions
	`PRINT` exp prints to the terminal, returns a number
	`CALL` exp `(` exps `)` calls higher-order function with parameters
`(` vars `)` `EXECUTES` exp defines higher-order functions
`(` exp `)` parenthesized expressions 
stmt ::= var `IS` exp`;` | `RETURNS` exp`;` | exp`;` | 
`{` stmt* `}`|  statement blocks 
`IF` `(` exp `)` stmt `ELSE` `stmt` | if-else statements
`WHILE` `(` exp `)` stmt  loop statements
param::= type var
params ::= [param (`,` param)*] list of parameters
Methoddef ::= `DEFINE` type methodname `(` params `)` `{` stmt* `}`
Program ::= methoddef* exp entry point	
```
Object language (Our language): Caps
Metalanguage : Java
Target Language: C

## Tokens ##
Possible Tokens:
<!--- covers the var, string, number and types -->
- IdentifierToken(String)
- StringToken(String)
- IntToken(int)
- DoubleToken(double)
- NumberToken : 20 <!--- leave this alone for now -->
- BooleanToken : 21
- StrToken : 22
<!--- covers methoddef -->
- leftParenToken : 0
- DefineToken : 1
- RightParenToken : 2
<!--- covers ops -->
- TrueToken : 3
- FalseToken : 4
- WhileToken : 5
- PlusToken : 6
- MinusToken : 7
- LogicalAndToken : 8
- LogicalOrToken : 9 
- LessThanToken : 10
- AsteriskToken : 11
- FowardSlashToken : 12
- IfToken : 13 
- ElseToken : 14
- RetrunsToken : 15
<!-- covers assign -->
- IsToken : 16
<!-- covers blocks -->
- LeftBracketToken : 17
- RightBracketToken : 18
- CommaToken : 19
- SemicolonToken : 23
- ExecutesToken : 24
- PrintToken : 25
- EqualsToken : 26
- GreaterThanToken : 27
