package com.caps.parser;


public class ParenthesizedExp implements Exp {
    public final Exp exp;

    public ParenthesizedExp(final Exp exp) {
        this.exp = exp;
    }

    @Override
    public boolean equals(final Object other) {
        return (other instanceof ExecuteExp &&
                exp.equals(((ParenthesizedExp)other).exp));
    }

    @Override
    public int hashCode() {
        return exp.hashCode();
    }

    @Override
    public String toString() {
        return "ParenthesizedExp(" + exp.toString() + ")";
    }
}

