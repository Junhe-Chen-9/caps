package com.caps.parser;


public class CallExp implements Exp {
    public final Exp exp;

    public CallExp(final Exp exp) {
        this.exp = exp;
    }

    @Override
    public boolean equals(final Object other) {
        return (other instanceof CallExp &&
                exp.equals(((CallExp)other).exp));
    }

    @Override
    public int hashCode() {
        return exp.hashCode();
    }

    @Override
    public String toString() {
        return "CallExp(" + exp.toString() + ")";
    }
}

