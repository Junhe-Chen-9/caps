package com.caps.lexer;

public class FowardSlashToken implements Token{
    @Override
    public boolean equals(final Object other){
        return other instanceof FowardSlashToken;
    }
    @Override
    public int hashCode(){
        return 12;
    }

    @Override
    public String toString() {
        return "FowardSlashToken{}";
    }
}
