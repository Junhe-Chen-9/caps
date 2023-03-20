package com.caps.lexer;

public class IdentifierToken implements Token{
    public final String name;
    public IdentifierToken(String s){
        name = s;
    }
    @Override
    public boolean equals(final Object other){
        return (other instanceof IdentifierToken && name.equals(((IdentifierToken) other).name));
    }
    @Override
    public int hashCode(){
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "IdentifierToken{" +
                "name='" + name + '\'' +
                '}';
    }
}
