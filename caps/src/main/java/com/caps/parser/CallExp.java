package com.caps.parser;

import java.util.List;

public class CallExp implements Exp {
    public final Exp exp1;
    public final List<Exp> exps;

    public CallExp(final Exp exp1, final List<Exp> exps) {
        this.exp1 = exp1;
        this.exps = exps;

    }

    @Override
    public boolean equals(Object other){
        if(other instanceof CallExp){
            final CallExp otherCallExp = (CallExp) other;
            return otherCallExp.exp1.equals(exp1) && otherCallExp.exps.equals(exps);
        }else{
            return false;
        }
    }
   

    @Override
    public int hashCode() {
        return exp1.hashCode() +exps.hashCode();
    }

    @Override
    public String toString() {
        return "CallExp(" + 
        exp1.toString() + 
        exps.toString() +
        ")";
    }
}

