package com.caps.lexer;

public class ForwardSlashToken implements Token{
    @Override
    public boolean equals(final Object other){
        return other instanceof ForwardSlashToken;
    }
    @Override
    public int hashCode(){
        return 12;
    }

    @Override
    public String toString() {
        return "ForwardSlashToken{}";
    }
}
