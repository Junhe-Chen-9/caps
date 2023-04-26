package com.caps.parser;


public class ExecuteExp implements Exp {
    public final Exp exp;

    public ExecuteExp(final Exp exp) {
        this.exp = exp;
    }

    @Override
    public boolean equals(final Object other) {
        return (other instanceof ExecuteExp &&
                exp.equals(((ExecuteExp)other).exp));
    }

    @Override
    public int hashCode() {
        return exp.hashCode();
    }

    @Override
    public String toString() {
        return "ExecuteExp(" + exp.toString() + ")";
    }
}

