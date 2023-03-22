package com.caps.lexer;

public class ExecutesToken implements Token{
    @Override
    public boolean equals(final Object other){
        return other instanceof ExecutesToken;
    }
    @Override
    public int hashCode(){
        return 24;
    }

    @Override
    public String toString() {
        return "ExecutesToken{}";
    }
}
