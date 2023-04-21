package com.caps.parser;

public class NumberType implements Type{
    @Override
    public boolean equals(final Object other){
        return other instanceof NumberType;
    }
    @Override
    public int hashCode(){
        return 0;
    }

    @Override
    public String toString() {
        return "NumberType{}";
    }
}
