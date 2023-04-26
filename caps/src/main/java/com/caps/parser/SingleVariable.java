package com.caps.parser;

public class SingleVariable implements Variable{
    public final String name;
    public SingleVariable(final String name){
        this.name = name;
    }

    @Override
    public boolean equals(final Object other){
        return (other instanceof SingleVariable && name.equals(( (SingleVariable) other).name));
    }
    @Override
    public int hashCode(){
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "SingleVariable{" +
                "name='" + name + '\'' +
                '}';
    }

}
