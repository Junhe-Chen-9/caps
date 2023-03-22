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
    @Test
    public void testTokenizeStmt() throws TokenizerException {
        final Token[] tokens = Tokenizer.tokenize("s IS stringvalue");
        final Token[] expeted = new Token[]{
                new IdentifierToken("s"),
                new IsToken(),
                new StringToken("stringvalue")
        };
        assertArrayEquals(tokens,expeted);
    }



    @Test
    public void testTokenizeOp() throws TokenizerException {
        final Token[] tokens = Tokenizer.tokenize("+ - && || / () {}");
        final Token[] expected = new Token[]{
                new PlusToken(),
                new MinusToken(),
                new LogicalAndToken(),
                new LogicalOrToken(),
                new FowardSlashToken(),
                new LeftParenToken(),
                new RightParenToken(),
                new LeftBracketToken(),
                new RightBracketToken()
        };
        assertArrayEquals(tokens,expected);
    }
    @Test
    public void testTokenizeIf() throws TokenizerException {
        final Token[] tokens = Tokenizer.tokenize("IF (x IS 1) {RETURNS 3} ELSE {RETURNS 7}");
        final Token[] expected = new Token[]{
                new IfToken(),
                new LeftParenToken(),
                new IdentifierToken("x"),
                new IsToken(),
                new IntToken(1),
                new RightParenToken(),
                new LeftBracketToken(),
                new ReturnsToken(),
                new IntToken(3),
                new RightBracketToken(),
                new ElseToken(),
                new LeftBracketToken(),
                new ReturnsToken(),
                new IntToken(7),
                new RightBracketToken()
        };
        assertArrayEquals(tokens,expected);
    }

}

