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
    public void testParseOp() throws ParseException, TokenizerException {
        final Token[] input = Tokenizer.tokenize("+");
        final Parser parser = new Parser(input);
        assertEquals(new ParseResult<Op>(new PlusOp(),1),
                                          parser.parseOp(0));
    }
    @Test
    public void testparseArithmeticExpressions() throws ParseException, TokenizerException {
        final Token[] input = Tokenizer.tokenize("(x + 1)");
        final Parser parser = new Parser(input);
        assertEquals(new ParseResult<Exp>(new ArithmeticExp(new VariableExp(new SingleVariable("x")), new PlusOp(), new NumberLiteralExp(1)),5),
                                          parser.parseArithmeticExpressions(0));
    }
    
    // loop ::= `WHILE` `(` exp `)` stmt  loop statements
    @Test 
    public void testparseloop() throws ParseException, TokenizerException{
        final Token[] input = Tokenizer.tokenize("WHILE ((x > 1)) RETURNS 1;");
        final Parser parser = new Parser(input);
        assertEquals(new ParseResult<Stmt>(new WhileStmt(
            new ArithmeticExp(new VariableExp(new SingleVariable("x")), new GreaterThanOp(), new NumberLiteralExp(1)),
            new ReturnsStmt(new NumberLiteralExp(1)))
            ,11),
                                          parser.parseLoop(0));
    }

    //`IF` `(` exp `)` stmt `ELSE` `stmt` | if-else statements
    @Test
    public void testParseIf() throws ParseException, TokenizerException{
        final Token[] input = Tokenizer.tokenize("IF ((x < 2)) RETURNS 2; ELSE RETURNS 5;");
        final Parser parser = new Parser(input);
        assertEquals(new ParseResult<Stmt>(
            new IfElseStmt(new ArithmeticExp(new VariableExp(new SingleVariable("x")), new LessThanOp(), new NumberLiteralExp(2)),
             new ReturnsStmt(new NumberLiteralExp(2)), 
             new ReturnsStmt(new NumberLiteralExp(5)))
            ,15),
                                          parser.parseIf(0));
    }

    @Test
    public void testParseStmts() throws ParseException, TokenizerException{
        final Token[] input = Tokenizer.tokenize("{ x IS 5; y IS 2;}");
        final Parser parser = new Parser(input);
        List<Stmt> list = new ArrayList<>();
        list.add(new VardecStmt(new SingleVariable("x"), new NumberLiteralExp(5)));
        list.add(new VardecStmt(new SingleVariable("y"), new NumberLiteralExp(2)));
        assertEquals(new ParseResult<Stmt>(
            new BlockStmt(list)
            ,10),
                                          parser.parseStmts(0));
    }

    @Test 
    public void testParseSingleStmt() throws ParseException, TokenizerException{
        final Token[] input = Tokenizer.tokenize("5;");
        final Parser parser = new Parser(input);
        assertEquals(new ParseResult<Stmt>(
            new ExpStmt(new NumberLiteralExp(5))
            ,2),
            parser.parseStmt(0));
    }
    
    @Test 
    public void testParseStmt() throws ParseException, TokenizerException{
        final Token[] input = Tokenizer.tokenize("WHILE ((x > 1)) RETURNS (x + 1);");
        final Parser parser = new Parser(input);
        assertEquals(new ParseResult<Stmt>(new WhileStmt(
            new ArithmeticExp(new VariableExp(new SingleVariable("x")), new GreaterThanOp(), new NumberLiteralExp(1)),
            new ReturnsStmt(new ArithmeticExp(new VariableExp(new SingleVariable("x")), new PlusOp(), new NumberLiteralExp(1))))
            ,15),parser.parseStmt(0));
    }

}




