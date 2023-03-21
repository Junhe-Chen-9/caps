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

    @Test
    public void testTokenizeExp() throws TokenizerException {
        final Token[] tokens = Tokenizer.tokenize("(1 + 2)");
        final Token[] expeted = new Token[]{
                new LeftParenToken(),
                new IntToken(1),
                new PlusToken(),
                new IntToken(2),
                new RightParenToken()
        };
        assertArrayEquals(tokens,expeted);
    }
    
}

