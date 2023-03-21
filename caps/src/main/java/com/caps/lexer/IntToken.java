package com.caps.lexer;

public class IntToken implements Token{
    public final int value;
    // constructor
    public IntToken(int v){
        value = v;
    }
    @Override
    public boolean equals(final Object other){
        return (other instanceof StringToken && value == (((IntToken) other).value));
    }

    @Override
    public int hashCode(){
        return value;
    }

    @Override
    public String toString() {
        return "IntToken{" +
                "value=" + value +
                '}';
    }
}
