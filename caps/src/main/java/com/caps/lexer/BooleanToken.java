package com.caps.lexer;

public class BooleanToken implements Token{
    // defualt constructor
    @Override
    public boolean equals(final Object other){
        return other instanceof BooleanToken;
    }
    @Override
    public int hashCode(){
        return 21;
    }

    @Override
    public String toString() {
        return "BooleanToken{}";
    }
}
