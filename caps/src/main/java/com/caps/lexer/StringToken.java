package com.caps.lexer;

public class StringToken implements Token{
    public final String value;

    public StringToken(String s){
        value = s;
    }
    @Override
    public boolean equals(final Object other){
        return (other instanceof StringToken && value.equals(((StringToken) other).value));
    }

    @Override
    public int hashCode(){
        return value.hashCode();
    }

    @Override
    public String toString() {
        return "StringToken{" +
                "value='" + value + '\'' +
                '}';
    }
}
