package com.caps.lexer;

public class DoubleToken implements Token{
    public final double value;
    public DoubleToken(double v){
        value = v;
    }
    @Override
    public boolean equals(final Object other){
        return (other instanceof DoubleToken && value == (((DoubleToken) other).value));
    }

    @Override
    public int hashCode(){
        return Double.hashCode(value);
    }

    @Override
    public String toString() {
        return "DoubleToken{" +
                "value=" + value +
                '}';
    }
}
