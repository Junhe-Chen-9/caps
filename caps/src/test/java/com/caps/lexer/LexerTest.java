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

    @Test
    public void testTokenizeWhile() throws TokenizerException {
        final Token[] tokens = Tokenizer.tokenize("WHILE (x IS 2) {x++}");
        final Token[] expected = new Token[]{
                new WhileToken(),
                new LeftParenToken(),
                new IdentifierToken("x"),
                new IsToken(),
                new IntToken(2),
                new RightParenToken(),
                new LeftBracketToken(),
                new IdentifierToken("x"),
                new PlusToken(),
                new PlusToken(),
                new RightBracketToken()
        };
        assertArrayEquals(tokens,expected);
    }

    @Test
    public void testTokenizeMethodDef() throws TokenizerException {
        final Token[] tokens = Tokenizer.tokenize("DEFINE NUMBER addnum(NUMBER x) {sum IS x + x; RETURNS sum;}");
        final Token[] expected = new Token[]{
                new DefineToken(),
                new NumberToken(),
                new IdentifierToken("addnum"),
                new LeftParenToken(),
                new NumberToken(),
                new IdentifierToken("x"),
                new RightParenToken(),
                new LeftBracketToken(),
                new IdentifierToken("sum"),
                new IsToken(),
                new IdentifierToken("x"),
                new PlusToken(),
                new IdentifierToken("x"),
                new SemicolonToken(),
                new ReturnsToken(),
                new IdentifierToken("sum"),
                new SemicolonToken(),
                new RightBracketToken()
        };
        assertArrayEquals(tokens,expected);
    }
    @Test
    public void testTokenizeBooleanMethodDef() throws TokenizerException {
        final Token[] tokens = Tokenizer.tokenize("DEFINE BOOLEAN isEven (NUMBER x) {RETURNS x / 2 = 0);} ");
        final Token[] expected = new Token[]{
                new DefineToken(),
                new BooleanToken(),
                new IdentifierToken("isEven"),
                new LeftParenToken(),
                new NumberToken(),
                new IdentifierToken("x"),
                new LeftBracketToken(),
                new ReturnsToken(),
                new IdentifierToken("x"),
                new FowardSlashToken(),
                new IntToken(2),
                new EqualsToken(),
                new IntToken(0),
                new RightParenToken(),
                new SemicolonToken(),
                new RightBracketToken()
        };
        assertArrayEquals(tokens,expected);
    }

    @Test
    public void testTokenizeHigherOrderFuncDef() throws TokenizerException {
        final Token[] tokens = Tokenizer.tokenize("(x,y) EXECUTES x + y");
        final Token[] expected = new Token[]{
                new LeftParenToken(),
                new IdentifierToken("x"),
                new CommaToken(),
                new IdentifierToken("y"),
                new RightParenToken(),
                new ExecutesToken(),
                new IdentifierToken("x"),
                new PlusToken(),
                new IdentifierToken("y"),
                new RightParenToken()
        };
        assertArrayEquals(tokens,expected);
    }


    public void testTokenizePrint() throws TokenizerException {
        final Token[] tokens = Tokenizer.tokenize("x IS foo; PRINT (x);");
        final Token[] expected = new Token[]{
                new IdentifierToken("x"),
                new IsToken(),
                new StringToken("foo"),
                new SemicolonToken(),
                new PrintToken(),
                new LeftParenToken(),
                new IdentifierToken("x"),
                new RightParenToken(),
                new SemicolonToken()
        };
        assertArrayEquals(tokens,expected);
    }

}

