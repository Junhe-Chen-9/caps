package com.caps.parser;

import com.caps.lexer.IntToken;
import com.caps.lexer.Token;

public class Parser {
    private final  Token[] tokens;
    private int p;

    public Parser(final Token[] tokens, final int p){
        this.tokens = tokens;
        this.p = p;
    }

    public ParseResult<Type> parseType() throws ParseException {
        final Token token = getToken(p);

        if(tokens.length > 0 && token instanceof IntToken){
            p ++;
            return new ParseResult<>(new IntType() , p + 1);
        }else{
            throw new ParseException("Expected type; received: " + token);
        }
    }
    private Token getToken(final int p) throws ParseException{
        if(p >= 0 && p < tokens.length){
            // valid position
            return tokens[p];
        }else{
            throw new ParseException("out of range");
        }
    }
}
