# Caps #
## Grammar Definition ##
```
var is a variable
string is a string
number is a number (integer or double)
methodname is the name of a method
vars ::= [var (`,` var)* ] list of variables
type::= `STRING` | `NUMBER` | built-in datatypes 
`(` types `)` `RETURNS` type higher-order function type
types::= [type (`,` type)*] list of types
op ::= `+` | `-` | `*` | `/` arithmetic operations
exp ::= var | string | number variables, strings, and numbers are expressions
	exp op exp arithmetic expressions
	`PRINT` exp prints to the terminal, returns a number
	`CALL` exp `(` exps `)` calls higher-order function with parameters
`(` vars `)` `EXECUTES` exp defines higher-order functions
`(` exp `)` parenthesized expressions 
stmt ::= var `IS` exp`;` | `RETURN` exp`;` | exp`;` | 
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
- IdentifierToken(String)
- IntToken(int)
- DoubleToken(double)
- NumberToken(int)
- BooleanToken(boolean)
- leftParenToken
- VardecToken
- RightParenToken
- TrueToken
- FalseToken
- WhileToken
- SingleEqualsToken
- PlusToken
- MinusToken
- LogicalAndToken
- LogicalOrToken
- LessThanToken
