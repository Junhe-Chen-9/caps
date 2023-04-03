package com.caps.parser;

import com.caps.lexer.*;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ParserTest {
    @Test
    public void testTypeEquals(){
        assertEquals(new IntType(), new IntType());
    }

    @Test
    public void testParseIntType(){
        final Token[] input = new Token[]{
                new IntToken(777)
        };
        assertEquals(new IntType(),Parser.parse(input));
    }
}
