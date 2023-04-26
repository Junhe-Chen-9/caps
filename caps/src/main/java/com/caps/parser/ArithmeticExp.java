package com.caps.parser;

public class ArithmeticExp implements Exp {
    public final Exp left;
    public final Op op;
    public final Exp right;

    public ArithmeticExp(final Exp exp1, final Op op2, final Exp exp2) {
        this.left = exp1;
        this.op = op2;
        this.right = exp2;
    }

    @Override
    public boolean equals(final Object other) {
        if (other instanceof ArithmeticExp) {
            final ArithmeticExp term = (ArithmeticExp)other;
            return ( left.equals(term.left) &&
                    op.equals(term.op) &&
                    right.equals(term.right));
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return ( left.hashCode() +
                op.hashCode() +
                right.hashCode());
    }

    @Override
    public String toString() {
        return ("ArithmeticExp(" +
                left.toString() + ", " +
                op.toString() + ", " +
                right.toString() + ")");
    }
}