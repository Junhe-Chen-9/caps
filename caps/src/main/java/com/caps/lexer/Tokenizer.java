package com.caps.lexer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Tokenizer {
    private final String input;
    private int p; // position where we are at right now
    private final HashMap<String,Token> SYMBOLS = new HashMap<>();
    private final HashMap<String,Token> KEYWORDS = new HashMap<>();
    boolean isString = false;
    private Token tokenizeString(){

        if(input.substring(p).startsWith("\"")){
            if(isString){
                isString = false;
                p ++;
                return new StringEndToken();
            }
            isString = true;
            p ++;
            return new StringStartToken();
        }else{
            if(isString){
                int end = p;
                while(end < input.length() && input.charAt(end) != '\"') end ++;
                int start = p;
                p = end;
                return new StringToken(input.substring(start,end));
            }
        }
        return null;
    }
    public Token tokenizeSymbol(){
        /* to get add more symbol easier in the future we can use hash map
        if(input.startsWith("(")){
            p ++;
            return new LeftParenToken();
        }else if(input.startsWith(")")){
            p ++;
            return new RightParenToken();
        }else if(input.startsWith("{")){
            p ++;
            return new LeftBracketToken();

        }else if(input.startsWith("}")){
            p ++;
            return new RightBracketToken();
        }else if(input.startsWith("+")){
            p ++;
            return new PlusToken();
        }else if(input.startsWith("-")){
            p ++;
            return new MinusToken();
        }else if(input.startsWith("<")){
            p ++;
            return new LessThanToken();
        }else if(input.startsWith("/")){
            p ++;
            return new ForwardSlashToken();
        }else if(input.startsWith("&&")){
            p +=2;
            return new LogicalAndToken();
        }else if(input.startsWith("||")){
            p +=2;
            return new LogicalOrToken();
        }

         */
        for(final String symbol : SYMBOLS.keySet()){
            if(input.substring(p).startsWith(symbol)){
                p += symbol.length();
                return SYMBOLS.get(symbol);
            }
        }
        return null; // not symbol
    }
    public Tokenizer(final String s){
        this.input = s;
        p = 0;
        // add SYMBOLS
        SYMBOLS.put("(",new LeftParenToken());
        SYMBOLS.put(")",new RightParenToken());
        SYMBOLS.put("{",new LeftBracketToken());
        SYMBOLS.put("}",new RightBracketToken());
        SYMBOLS.put("+", new PlusToken());
        SYMBOLS.put("-",new MinusToken());
        SYMBOLS.put("/", new ForwardSlashToken());
        SYMBOLS.put("*",new AsteriskToken());
        SYMBOLS.put("||",new LogicalOrToken());
        SYMBOLS.put("&&", new LogicalAndToken());
        SYMBOLS.put("<",new LessThanToken());
        SYMBOLS.put(",",new CommaToken());
        SYMBOLS.put(";",new SemicolonToken());
        SYMBOLS.put(">",new GreaterThanToken());
        SYMBOLS.put("*",new AsteriskToken());
        // add KEYWORDS
        KEYWORDS.put("NUMBER",new NumberToken());
        KEYWORDS.put("BOOLEAN",new BooleanToken());
        KEYWORDS.put("IS",new IsToken());
        KEYWORDS.put("IF",new IfToken());
        KEYWORDS.put("RETURNS",new ReturnsToken());
        KEYWORDS.put("ELSE",new ElseToken());
        KEYWORDS.put("DEFINE",new DefineToken());
        KEYWORDS.put("STRING",new StrToken());
        KEYWORDS.put("WHILE",new WhileToken());
        KEYWORDS.put("EXECUTES",new ExecutesToken());
        KEYWORDS.put("PRINT",new PrintToken());
        KEYWORDS.put("EQUALS",new EqualsToken());
        KEYWORDS.put("TRUE",new TrueToken());
        KEYWORDS.put("FALSE",new FalseToken());
        KEYWORDS.put("CALL",new CallToken());
        KEYWORDS.put("PROGON", new PrognToken());
        // we can do same thing for the key words that way it is easier to add and remove key words

    }
    public Token tokenizeIdentifierOrReservedWord(){
        String name = "";
        if (Character.isLetter(input.charAt(p))){
            name +=input.charAt(p);
            p ++;
            while(p < input.length() && Character.isLetterOrDigit(input.charAt(p))){
                // keep scanning
                name += input.charAt(p);
                p ++;
            }

            // now you read the identifier or reserved word
            // check against all our tokens possibility
            for(String w : KEYWORDS.keySet()){
                if(name.equals(w)){
                    return KEYWORDS.get(name);
                }
            }

            return new IdentifierToken(name);


            //TODO add more else if to cover all tokens
        }else{
            return null;// not identifier or reserved word
        }



    }
    public Token tokenizeNumber() throws TokenizerException {
        int temp = p;
        String s = "";
        boolean flag = false;
        while(temp < input.length() && (Character.isDigit(input.charAt(temp)) || input.charAt(temp) == '.')){
            if(input.charAt(temp) == '.' && flag) {
                throw new TokenizerException("not valid number");
            }
            if(input.charAt(temp) == '.') flag = true;
            s += input.charAt(temp);
            temp ++;
        }

        return flag ? tokenizeDouble() : tokenizeInt();
    }
    public DoubleToken tokenizeDouble(){
        String s = "";
        while(p < input.length() && (Character.isDigit(input.charAt(p)) || input.charAt(p) == '.')){
            s += input.charAt(p);
            p ++;
        }
        if(s.length() > 0){

            return new DoubleToken(Double.parseDouble(s));
        }
        return null; // empty double
    }

    // returns null if not a int
    public IntToken tokenizeInt(){
        String digits = "";
        while(Character.isDigit(input.charAt(p))){
            digits += input.charAt(p);
            p ++;
        }
        if(digits.length() > 0){

            return new IntToken(Integer.parseInt(digits));
        }
        return null; // empty digits
    }
    public void skipWhitespace(){
        while(p <input.length() && Character.isWhitespace(input.charAt(p))) p ++;
    }
    public Token readToken() throws TokenizerException{
        Token res = null;

        res = tokenizeString();
        if(res != null){
            return res;
        }
        res = tokenizeNumber();
        if(res != null){
            return res;
        }
        res = tokenizeSymbol();
        if(res != null){
            return res;
        }
        res = tokenizeIdentifierOrReservedWord();
        if(res != null){
            return res;
        }
        throw new TokenizerException("Failed to tokenize: " + input.charAt(p));
    }
    public Token[] tokenize() throws TokenizerException{
        final List<Token> retval = new ArrayList<Token>();
        skipWhitespace();
        while(p < input.length()){
            retval.add(readToken());
            skipWhitespace();
        }
        return retval.toArray(new Token[retval.size()]);
    }
    public static Token[] tokenize(final String input) throws TokenizerException{
        return new Tokenizer(input).tokenize();
    }
}
