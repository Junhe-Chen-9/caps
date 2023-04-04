package com.caps.parser;

import com.caps.lexer.*;

public class Parser {
    private final  Token[] tokens;
    private int p;

    public Parser(final Token[] tokens, final int p){
        this.tokens = tokens;
        this.p = p;
    }

    private Token getToken(final int p) throws ParseException{
        if(p >= 0 && p < tokens.length){
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

    // type::= `STRING` | `NUMBER` | `BOOLEAN`
    // todo: should this return Number instead of int?
    public ParseResult<Type> parseType(int p) throws ParseException {
        final Token token = getToken(p);

        if(tokens.length > 0 && token instanceof IntToken){
            p ++;
            return new ParseResult<>(new IntType(), p + 1);
        }
        else if(tokens.length > 0 && token instanceof BooleanToken){
            p ++;
            return new ParseResult<>(new BoolType(), p + 1);
        }
        else if(tokens.length > 0 && token instanceof StringToken) {
            p++;
            return new ParseResult<>(new StrType(), p + 1);
        }
        else {
            throw new ParseException("Expected type; received: " + token);
        }
    }


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
        return new ParseResult<Op>(op, p + 1);

    }




    }


