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
        final Token[] expected = new Token[]{new IdentifierToken("bar")};
        assertArrayEquals(tokens,expected);
    }

    @Test
    public void testTokenizeExp() throws TokenizerException {
        final Token[] tokens = Tokenizer.tokenize("(1 + 2)");
        final Token[] expected = new Token[]{
                new LeftParenToken(),
                new IntToken(1),
                new PlusToken(),
                new IntToken(2),
                new RightParenToken()
        };
        assertArrayEquals(tokens,expected);
    }
    @Test
    public void testTokenizeStmt() throws TokenizerException {
        final Token[] tokens = Tokenizer.tokenize("s IS \"stringvalue\"");
        final Token[] expected = new Token[]{
                new IdentifierToken("s"),
                new IsToken(),
                new StringStartToken(),
                new StringToken("stringvalue"),
                new StringEndToken()
        };
        assertArrayEquals(expected,tokens);
    }



    @Test
    public void testTokenizeOp() throws TokenizerException {
        final Token[] tokens = Tokenizer.tokenize("IF ((x < 1) && (y < 2) || (x EQUALS 10)) {x EQUALS x - 1;} ELSE {y EQUALS y + 1;}");
        final Token[] expected = new Token[]{
                new IfToken(),
                new LeftParenToken(),
                new LeftParenToken(),
                new IdentifierToken("x"),
                new LessThanToken(),
                new IntToken(1),
                new RightParenToken(),
                new LogicalAndToken(),
                new LeftParenToken(),
                new IdentifierToken("y"),
                new LessThanToken(),
                new IntToken(2),
                new RightParenToken(),
                new LogicalOrToken(),
                new LeftParenToken(),
                new IdentifierToken("x"),
                new EqualsToken(),
                new IntToken(10),
                new RightParenToken(),
                new RightParenToken(),
                new LeftBracketToken(),
                new IdentifierToken("x"),
                new EqualsToken(),
                new IdentifierToken("x"),
                new MinusToken(),
                new IntToken(1),
                new SemicolonToken(),
                new RightBracketToken(),
                new ElseToken(),
                new LeftBracketToken(),
                new IdentifierToken("y"),
                new EqualsToken(),
                new IdentifierToken("y"),
                new PlusToken(),
                new IntToken(1),
                new SemicolonToken(),
                new RightBracketToken(),
        };
        assertArrayEquals(tokens,expected);
    }
    @Test
    public void testTokenizeIf() throws TokenizerException {
        final Token[] tokens = Tokenizer.tokenize("IF (x IS 1) {RETURNS 3;} ELSE {RETURNS 7;}");
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
                new SemicolonToken(),
                new RightBracketToken(),
                new ElseToken(),
                new LeftBracketToken(),
                new ReturnsToken(),
                new IntToken(7),
                new SemicolonToken(),
                new RightBracketToken()
        };
        assertArrayEquals(tokens,expected);
    }

    @Test
    public void testTokenizeWhile() throws TokenizerException {
        final Token[] tokens = Tokenizer.tokenize("WHILE (x IS 2) {x EQUALS x + 1;}");
        final Token[] expected = new Token[]{
                new WhileToken(),
                new LeftParenToken(),
                new IdentifierToken("x"),
                new IsToken(),
                new IntToken(2),
                new RightParenToken(),
                new LeftBracketToken(),
                new IdentifierToken("x"),
                new EqualsToken(),
                new IdentifierToken("x"),
                new PlusToken(),
                new IntToken(1),
                new SemicolonToken(),
                new RightBracketToken()
        };
        assertArrayEquals(tokens,expected);
    }

    @Test
    public void testTokenizeMethodDef() throws TokenizerException {
        final Token[] tokens = Tokenizer.tokenize("DEFINE NUMBER addnum (NUMBER x) {sum IS x + x; RETURNS sum;}");
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
        final Token[] tokens = Tokenizer.tokenize("DEFINE BOOLEAN isEven (NUMBER x) {RETURNS (x / 2) EQUALS 0;} ");
        final Token[] expected = new Token[]{
                new DefineToken(),
                new BooleanToken(),
                new IdentifierToken("isEven"),
                new LeftParenToken(),
                new NumberToken(),
                new IdentifierToken("x"),
                new RightParenToken(),
                new LeftBracketToken(),
                new ReturnsToken(),
                new LeftParenToken(),
                new IdentifierToken("x"),
                new ForwardSlashToken(),
                new IntToken(2),
                new RightParenToken(),
                new EqualsToken(),
                new IntToken(0),
                new SemicolonToken(),
                new RightBracketToken()
        };
        assertArrayEquals(tokens,expected);
    }

    @Test
    public void testStrToken() throws TokenizerException{
        final Token[] tokens = Tokenizer.tokenize("STRING");
        final Token[] expected = new Token[]{new StrToken()};
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
        };
        assertArrayEquals(tokens,expected);
    }

    @Test
    public void testTokenizePrint() throws TokenizerException {
        final Token[] tokens = Tokenizer.tokenize("x IS \"foo\"; PRINT (x);");
        final Token[] expected = new Token[]{
                new IdentifierToken("x"),
                new IsToken(),
                new StringStartToken(),
                new StringToken("foo"),
                new StringEndToken(),
                new SemicolonToken(),
                new PrintToken(),
                new LeftParenToken(),
                new IdentifierToken("x"),
                new RightParenToken(),
                new SemicolonToken()
        };
        assertArrayEquals(tokens,expected);
    }

    @Test
    public void testTokenizeSingleDigitInt() {
        assertEquals(new IntToken(1), new IntToken(1));
    }


    @Test
    public void testTokenizeMultiDigitInt() {
        assertEquals(new IntToken(12345), new IntToken(12345));
    }

    @Test
    public void testTokenizeDouble() throws TokenizerException {
        final Token[] tokens = Tokenizer.tokenize("3.1415");
        final Token[] expected = new Token[]{new DoubleToken(3.1415)};
        assertArrayEquals(tokens,expected);
    }


    @Test
    public void testTokenizeIdentifierWithUppercase() throws TokenizerException{
        final Token[] tokens = Tokenizer.tokenize("fooBAR");
        final Token[] expected = new Token[]{new IdentifierToken("fooBAR")};
        assertArrayEquals(tokens,expected);
    }


    @Test
    public void testTokenizeStringSingleWord() throws TokenizerException {
        final Token[] tokens = Tokenizer.tokenize("\"hello\"");
        final Token[] expected = new Token[]{
                new StringStartToken(),
                new StringToken("hello"),
                new StringEndToken()
        };
        assertArrayEquals(tokens,expected);
    }

    @Test(expected = TokenizerException.class)
    public void testCannotTokenize() throws TokenizerException {
        Tokenizer.tokenize("$");
    }

    @Test(expected = TokenizerException.class)
    public void testInvalidDouble() throws TokenizerException {
        Tokenizer.tokenize("3.13.12");
    }

    /* this is not in grammar so it should not be tested
   @Test
   public void testTokenizeStringMultipleWords() throws TokenizerException {
       final Token[] tokens = Tokenizer.tokenize("hello world");
       final Token[] expected = new Token[]{
               new StringToken("hello world")
       };
       assertArrayEquals(tokens,expected);
   }

   @Test
   public void testTokenizeStringWithInt() throws TokenizerException {
       final Token[] tokens = Tokenizer.tokenize("May 19");
       final Token[] expected = new Token[]{
               new StringToken("May 19")
       };
       assertArrayEquals(tokens,expected);
   }

   @Test
   public void testTokenizeLowercaseReservedWords() throws TokenizerException {
       final Token[] tokens = Tokenizer.tokenize("define");
       final Token[] expected = new Token[]{
               new StringToken("define")
       };
       assertArrayEquals(tokens,expected);
   }


    */
    @Test
    public void testTokenizeIfTrueString() throws TokenizerException {
        final Token[] tokens = Tokenizer.tokenize("IF(TRUE) {name EQUALS \"Bob\";}");
        final Token[] expected = new Token[]{
                new IfToken(),
                new LeftParenToken(),
                new TrueToken(),
                new RightParenToken(),
                new LeftBracketToken(),
                new IdentifierToken("name"),
                new EqualsToken(),
                new StringStartToken(),
                new StringToken("Bob"),
                new StringEndToken(),
                new SemicolonToken(),
                new RightBracketToken(),
        };
        assertArrayEquals(tokens,expected);
    }

    @Test
    public void testTokenizeHigherOrderFunctionCall() throws TokenizerException {
        final Token[] tokens = Tokenizer.tokenize("f IS (x) EXECUTES x * 2; retval IS CALL f (2);");
        final Token[] expected = new Token[]{
                new IdentifierToken("f"),
                new IsToken(),
                new LeftParenToken(),
                new IdentifierToken("x"),
                new RightParenToken(),
                new ExecutesToken(),
                new IdentifierToken("x"),
                new AsteriskToken(),
                new IntToken(2),
                new SemicolonToken(),
                new IdentifierToken("retval"),
                new IsToken(),
                new CallToken(),
                new IdentifierToken("f"),
                new LeftParenToken(),
                new IntToken(2),
                new RightParenToken(),
                new SemicolonToken(),
        };
        assertArrayEquals(expected,tokens);
    }

    @Test
    public void testTokenizeFalse() throws TokenizerException {
        final Token[] tokens = Tokenizer.tokenize("IF(x > 5) RETURNS FALSE;");
        final Token[] expected = new Token[]{
                new IfToken(),
                new LeftParenToken(),
                new IdentifierToken("x"),
                new GreaterThanToken(),
                new IntToken(5),
                new RightParenToken(),
                new ReturnsToken(),
                new FalseToken(),
                new SemicolonToken()
        };
        assertArrayEquals(expected,tokens);
    }

}

