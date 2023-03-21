package com.caps.lexer;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LexerTest {
    @Test
    public void testIdentifierEquals() {
        assertEquals(new IdentifierToken("foo"),
                new IdentifierToken("foo"));
    }


    @Test
    public void testTokenizeIdentifier() throws TokenizerException {
        final Token[] tokens = Tokenizer.tokenize("bar");
        final Token[] expeted = new Token[]{new IdentifierToken("bar")};
        assertArrayEquals(tokens,expeted);
    }

    
}

