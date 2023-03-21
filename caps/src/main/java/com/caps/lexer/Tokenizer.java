package com.caps.lexer;

public class Tokenizer {
    private final String input;
    private int p; // posistion where we are at right now
    public Tokenizer(final String s){
        this.input = s;
        p = 0;
    }
    public Token tokenizeIdentifierOrReservedWord(){
        return null;
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
