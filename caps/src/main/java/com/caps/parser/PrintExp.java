package com.caps.parser;


public class PrintExp implements Exp {
    public final Exp exp;

    public PrintExp(final Exp exp) {
        this.exp = exp;
    }

    @Override
    public boolean equals(final Object other) {
        return (other instanceof PrintExp &&
                exp.equals(((PrintExp)other).exp));
    }

    @Override
    public int hashCode() {
        return exp.hashCode();
    }

    @Override
    public String toString() {
        return "PrintExp(" + exp.toString() + ")";
    }
}

