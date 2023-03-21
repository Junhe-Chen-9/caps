package com.caps.lexer;

public class StrToken {
    // this is reserved word STRING
    @Override
    public boolean equals(final Object other){
        return other instanceof StrToken;
    }
    @Override
    public int hashCode(){
        return 22;
    }

    @Override
    public String toString() {
        return "StrToken{}";
    }
}
