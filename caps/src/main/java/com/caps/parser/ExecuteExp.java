package com.caps.parser;


public class ExecuteExp implements Exp {
    public final Variable var;
    public final Exp exp;

    public ExecuteExp(final Variable var, final Exp exp) {
        this.var = var;
        this.exp = exp;
    }

    @Override
    public boolean equals(final Object other){
        if(other instanceof ExecuteExp){
            final ExecuteExp otherExecuteExp = (ExecuteExp) other;
            return otherExecuteExp.var == var && otherExecuteExp.exp == exp;
        }else{
            return false;
        }
    }

    @Override
    public int hashCode(){
        return (var.hashCode() + exp.hashCode());
    }

    @Override
    public String toString() {
        return "ExecuteExp{" +
                "var=" + var +
                "exp=" + exp +
                '}';
    }
}

