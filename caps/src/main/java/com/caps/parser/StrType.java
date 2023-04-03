package com.caps.parser;

public class StrType implements Type{
    @Override
    public boolean equals(final Object other){
        return other instanceof StrType;
    }
    @Override
    public int hashCode(){
        return 2;
    }

    @Override
    public String toString() {
        return "StrType{}";
    }
}
