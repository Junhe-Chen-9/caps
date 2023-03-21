package com.caps.lexer;

public class IsToken {
    @Override
    public boolean equals(final Object other){
        return other instanceof IsToken;
    }
    @Override
    public int hashCode(){
        return 16;
    }

    @Override
    public String toString() {
        return "IsToken{}";
    }
}
