package com.caps.parser;

public class Param implements Parameter{
    public final Type type;
    public final Variable var;

    public Param(final Type type, Variable var){
        this.type = type;
        this.var = var;
    }

    @Override
    public boolean equals(final Object other){
        if(other instanceof Param){
            final Param otherParam = (Param) other;
            return otherParam.type == type && otherParam.var == var;
        }else{
            return false;
        }
    }
    @Override
    public int hashCode(){
        return type.hashCode() + var.hashCode();
    }

    @Override
    public String toString() {
        return "Param{" +
                type.toString() + ", " +
                var.toString() + ")";
    }

}
