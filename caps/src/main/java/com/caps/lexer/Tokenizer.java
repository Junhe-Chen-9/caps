package com.caps.lexer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Tokenizer {
    private final String input;
    private int p; // posistion where we are at right now
    private final HashMap<String,Token> SYMBOLS = new HashMap<>();
    private final HashMap<String,Token> KEYWORDS = new HashMap<>();
    private boolean isFlag;
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
            return new FowardSlashToken();
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
        isFlag = false;
        // add SYMBOLS
        SYMBOLS.put("(",new LeftParenToken());
        SYMBOLS.put(")",new RightParenToken());
        SYMBOLS.put("{",new LeftBracketToken());
        SYMBOLS.put("}",new RightBracketToken());
        SYMBOLS.put("+", new PlusToken());
        SYMBOLS.put("-",new MinusToken());
        SYMBOLS.put("/", new FowardSlashToken());
        SYMBOLS.put("||",new LogicalOrToken());
        SYMBOLS.put("&&", new LogicalAndToken());
        SYMBOLS.put("<",new LogicalAndToken());
        SYMBOLS.put(",",new CommaToken());

        // add KEYWORDS
        // we can do same thing for the key words that way it is eaiser to add and remove key words

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
            if(name.equals("NUMBER")){
                return new NumberToken();
            }else if(name.equals("BOOLEAN")){
                return new BooleanToken();
            }else if(name.equals("IS")){
                // this is a tricky situation
                // make sure we are tokening next token as string or as value
                isFlag = true;
                return new IsToken();
            } else if(name.equals("IF")){
                return new IfToken();
            }else if (name.equals("RETURNS")){
                return new ReturnsToken();
            }else if (name.equals("ELSE")){
                return new ElseToken();
            }else if(name.equals("DEFINE")){
                return new DefineToken();
            }else if(name.equals("STRING")){
                return new StrToken();
            }else if(name.equals("WHILE")){
                return new WhileToken();
            }else if(name.equals("EXECUTES")){
                return new ExecutesToken();
            }else if(name.equals("PRINT")){
                return new PrintToken();
            }

            else{
                return isFlag ? new StringToken(name) : new IdentifierToken(name);
            }

            //TODO add more else if to cover all tokens
        }else{
            return null;// not identifier or reserved World
        }



    }
    public Token tokenizeNumber(){
        int temp = p;
        String s = "";
        boolean flag = false;
        while(p < input.length() && Character.isDigit(input.charAt(p)) || input.charAt(p) == '.'){
            if(flag) {
                p = temp; // set back the pointer
                return null; // this is a string
                }
            if(input.charAt(p) == '.') flag = true;
            s += input.charAt(p);
            p ++;
        }
        p = temp; // set back the pointer and tokenize accordingly
        return flag ? tokenizeDouble() : tokenizeInt();
    }
    public DoubleToken tokenizeDouble(){
        String s = "";
        while(Character.isDigit(input.charAt(p)) || input.charAt(p) == '.'){
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
