package com.caps.parser;

import com.caps.lexer.*;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ParserTest {
    @Test
    public void testTypeEquals() {
        assertEquals(new IntType(), new IntType());
    }

    @Test
    public void testParseIntType() throws ParseException {
        final Token[] input = new Token[]{
                new IntToken(777)
        };
        final Parser parser = new Parser(input);
        assertEquals(new ParseResult<Type>(new IntType(), 1), parser.parseType(0));
    }

    @Test
    public void testParseStrType() throws ParseException {
        final Token[] input = new Token[]{
                new StringToken("hello")
        };
        final Parser parser = new Parser(input);
        assertEquals(new ParseResult<Type>(new StrType(), 1), parser.parseType(0));
    }


    // 1 + 10
   /* @Test
    public void testArithmeticExp() throws ParseException {
        final Token[] input = new Token[]{
                new IntToken(1),
                new PlusToken(),
                new IntToken(10)
        };
        final Parser parser = new Parser(input);
        assertEquals(new ParseResult<Exp>(new NumberType(), new PlusOp(), new NumberType()), parser.parseExp(0));
    }*/
}




