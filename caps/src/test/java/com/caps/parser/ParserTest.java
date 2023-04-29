package com.caps.parser;

import com.caps.lexer.*;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

public class ParserTest {
    // NUMBER
    @Test
    public void testParseNumberType() throws ParseException {
        final Token[] input = new Token[] {
            new NumberToken()
        };
        final Parser parser = new Parser(input);
        assertEquals(new ParseResult<Type>(new NumberType(), 1),
                     parser.parseType(0));
    }

    // x 
    @Test 
    public void testSingleVariable() throws ParseException{
        final Token[] input = new Token[] {
            new IdentifierToken("x")
        };
        final Parser parser = new Parser(input);
        assertEquals(new ParseResult<>(new SingleVariable("x"), 1),parser.parseVariable(0));
    }

    // 7
    @Test 
    public void testNumberLiteralExp() throws ParseException{
        final Token[] input = new Token[] {
            new IntToken(7)
        };
        final Parser parser = new Parser(input);
        assertEquals(new ParseResult<>(new NumberLiteralExp(7), 1),parser.parseExp(0));
    }

   
    
    // x IS 7
    @Test
    public void testVardec() throws ParseException, TokenizerException {
        final Token[] input = Tokenizer.tokenize("x IS 7;");
        final Parser parser = new Parser(input);
        assertEquals(new ParseResult<Stmt>(new VardecStmt(new SingleVariable("x"),
                                                          new NumberLiteralExp(7)),
                                                          4),
                                          parser.parseVardec(0));
    }

    //parseReturns
    @Test
    public void testParseReturns() throws ParseException, TokenizerException {
        final Token[] input = Tokenizer.tokenize("RETURNS 1;");
        final Parser parser = new Parser(input);
        assertEquals(new ParseResult<Stmt>(new ReturnsStmt(new NumberLiteralExp(1)),
                                                          3),
                                          parser.parseReturns(0));

    }

    @Test 
    public void testSingleExpVar() throws ParseException{
        final Token[] input = new Token[] {
            new IdentifierToken("x")
        };
        final Parser parser = new Parser(input);
        assertEquals(new ParseResult<>(new VariableExp(new SingleVariable("x")), 1),parser.parseExpVar(0));
    }
    @Test
    public void TestparseArithmeticExpressions() throws ParseException, TokenizerException {
        final Token[] input = Tokenizer.tokenize("(x + 1)");
        final Parser parser = new Parser(input);
        assertEquals(new ParseResult<Exp>(new ArithmeticExp(new VariableExp(new SingleVariable("x")), new PlusOp(), new NumberLiteralExp(1)),5),
                                          parser.parseArithmeticExpressions(0));
    }

    

    

}




