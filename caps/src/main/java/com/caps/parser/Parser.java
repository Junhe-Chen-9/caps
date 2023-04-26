package com.caps.parser;

import com.caps.lexer.*;

import javax.management.StringValueExp;

public class Parser {
    private final  Token[] tokens;

    public Parser(final Token[] tokens){
        this.tokens = tokens;
    }

    private Token getToken(final int p) throws ParseException{
        if(p >= 0){
            // valid position
            return tokens[p];
        }else{
            throw new ParseException("out of range");
        }
    }

    public void assertTokenIs (final int p, final Token expected) throws ParseException{
        final Token received = getToken(p);
        if (!expected.equals(received)) {
            throw new ParseException("Expected: " + expected.toString() + "Received: " + received.toString());
        }
    }

    // var is a variable
    public ParseResult<Variable> parseVariable(final int p) throws ParseException {
        final Token token = getToken(p);
        if (token instanceof IdentifierToken) {
            return new ParseResult<Variable>(new Variable(((IdentifierToken)token).name),
                    p + 1);
        } else {
            throw new ParseException("Expected variable; received: " + token.toString());
        }
    }

    // type::= `STRING` | `NUMBER` | `BOOLEAN`
    public ParseResult<Type> parseType(final int p) throws ParseException {
        final Token token = getToken(p);

        if(token instanceof NumberToken){
            return new ParseResult<>(new NumberType(), p + 1);
        }
        else if(token instanceof BooleanToken){
            return new ParseResult<>(new BoolType(), p + 1);
        }
        else if(token instanceof StringToken) {
            return new ParseResult<>(new StrType(), p + 1);
        }
        else {
            throw new ParseException("Expected type; received: " + token);
        }
    }


    // exp ::= var | string | number variables, strings, and numbers are expressions
    public ParseResult<Exp> parseExp(final int p) throws ParseException {
        final Token token = getToken(p);

        if (token instanceof IdentifierToken) {
            return new ParseResult<Exp>(new VariableExp(new Variable(((IdentifierToken) token).name)), p + 1);
        } else if (token instanceof StrToken) {
            return new ParseResult<Exp>(new StringExp(((StringToken) token).value), p + 1);
        } else if (token instanceof NumberToken) {
            return new ParseResult<Exp>(new NumberLiteralExp(((NumberToken) token).value), p + 1);
        } else {
            throw new ParseException("Expected type; received: " + token);
        }
    }

    //`PRINT` exp prints to the terminal, returns a number
    public ParseResult<Exp> parsePrint(final int p) throws ParseException {
        assertTokenIs(p, new PrintToken());
        final ParseResult<Exp> exp = parseExp(p + 1);
        return new ParseResult<Exp>(new PrintExp(exp.result), p + 1);
    }

    // exp op exp arithmetic expressions
    public ParseResult<Exp> parseBinaryOp(final int p) throws ParseException {
        final Token token = getToken(p);
        final ParseResult<Exp> left = parseExp(p);
        final ParseResult<Op> op = parseOp(p + 1);
        final ParseResult<Exp> right = parseExp(p + 2);
        return new ParseResult<Exp>(new ArithmeticExp(left.result, op.result, right.result), p + 1);
    }

    // `CALL` exp `(` exps `)` calls higher-order function with parameters
    public ParseResult<Exp> parseCallHOF(final int p) throws ParseException {
        final Token token = getToken(p);
        assertTokenIs(p, new CallToken());
        final ParseResult<Exp> exp = parseExp(p + 1);
        assertTokenIs(p + 2, new LeftParenToken());
        try {
            ParseResult<Exp> expHOF = parseExp(p + 3);
            // Recursive call?
        } catch (final ParseException e) {
            // do something...
        }
        assertTokenIs(p + 1, new RightParenToken());
        return new ParseResult<Exp>(new CallExp(exp.result), p + 1);
    }


    // `(` vars `)` `EXECUTES` exp defines higher-order functions
    // `(` exp `)` parenthesized expressions*/
    public ParseResult<Exp> parseDefineHOF(final int p) throws ParseException {
        final Token token = getToken(p);
        if (token instanceof LeftParenToken) {
            try {
                final ParseResult<Variable> var = parseVariable(p + 2);
                // Recursive call?
                assertTokenIs(p + 3, new RightParenToken());
                assertTokenIs(p + 4, new ExecutesToken());
                final ParseResult<Exp> exp = parseExp(p + 5);
                return new ParseResult<Exp>(new ExecuteExp(exp.result), p + 1);
            } catch (final ParseException e) {
                // do something...
            }
            try {
                final ParseResult<Exp> exp = parseExp(p + 2);
                assertTokenIs(p + 3, new RightParenToken());
                return new ParseResult<Exp>(new ParenthesizedExp(exp.result), p + 1);
            } catch (final ParseException e) {
                // do something...
            }
        } else {
            throw new ParseException("Expected type; received: " + token);
        }
    }














    /* Example from meeting with prof
    exps:=[exp(`,`exp)*]
    exp::= IDENTIFIER | IDENTIFIER `(` exps `)`
    stmt ::= `while` `(` exp `)` `{` stmt* `}` |
        `if `(` exp `)` stmt `else` stmt |
        IDENTIFIER `=` exp `;` |
        exp `;`

    public ParseResult<Stmt> parseStmt(final int p) throws ParseException {
        final Token token = getToken(p);

        try{
            assertTokenIs(getToken(p), new WhileToken());
            assertTokenIs(getToken(p +1), new LeftParenToken());
            final ParseResult<Exp> guard = parseExp(p + 2);
            ...
            return new ParseResult<Stmt>(new WhileStmt(...), ...);
        }
        catch (final ParseException e) {... }
        try {
            if (token instanceof identifierToken){
                assertTokenIs(getToken(p + 1), new EqualsToken());
            }
        }
        catch (final ParseException e) {...}
    }
     */





    public ParseResult<Op> parseOp (final int p) throws ParseException {
        final Token token = getToken(p);
        Op op = null;

        if (token instanceof PlusToken) {op = new PlusOp();}
        else if (token instanceof MinusToken) {op = new MinusOp();}
        else if (token instanceof AsteriskToken) {op = new MultOp();}
        else if (token instanceof ForwardSlashToken) {op = new DivideOp();}
        else if (token instanceof LogicalAndToken) {op = new LogicalAndOp();}
        else if (token instanceof LogicalOrToken) {op = new LogicalOrOp();}
        else if (token instanceof GreaterThanToken) {op = new GreaterThanOp();}
        else if (token instanceof LessThanToken) {op = new LessThanOp();}
        else {
            throw new ParseException("Expected operator; received: " + token);
        }

        assert(op != null);
        return new ParseResult<Op>(op, p);

    }




    }


