package com.caps.lexer;

public class DefineToken implements Token{
    @Override
    public boolean equals(final Object other){
        return other instanceof DefineToken;
    }
    @Override
    public int hashCode(){
        return 1;
    }

    @Override
    public String toString() {
        return "DefineToken{}";
    }
}
