package com.caps.lexer;

public class PrintToken implements Token{
    @Override
    public boolean equals(final Object other){
        return other instanceof PrintToken;
    }
    @Override
    public int hashCode(){
        return 25;
    }

    @Override
    public String toString() {
        return "PrintToken{}";
    }
}
