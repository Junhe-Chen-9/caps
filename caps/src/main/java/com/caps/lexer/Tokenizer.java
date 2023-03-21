package com.caps.lexer;

public class Tokenizer {
    private final String input;
    private int p; // posistion where we are at right now
    public Tokenizer(final String s){
        this.input = s;
        p = 0;
    }
    public Token tokenizeIdentifierOrReservedWord(){
        String name = "";
        if (Character.isLetter(input.charAt(p))){
            name +=input.charAt(p);
            p ++;
            while(Character.isLetterOrDigit(input.charAt(p))){
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
            }else{
                return new IdentifierToken(name);
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
        while(Character.isDigit(input.charAt(p)) || input.charAt(p) == '.'){
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
    public static Token[] tokenize(final String input){
        return null;
    }
}
