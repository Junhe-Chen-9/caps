package com.caps.parser;

public class IsStmt implements Stmt{
    public final Type type;
    public final Variable variable;
    public final Exp exp;

    public IsStmt(Type type, Variable variable, Exp exp) {
        this.type = type;
        this.variable = variable;
        this.exp = exp;
    }

    @Override
    public boolean equals(final Object other){
        if(other instanceof IsStmt){
            final IsStmt otherIs = (IsStmt) other;
            return (type.equals(otherIs.type) &&
                    variable.equals(otherIs.variable) &&
                    exp.equals(otherIs.exp));
        }
        return false;
    }

    @Override
    public int hashCode(){
        return type.hashCode() + variable.hashCode() + exp.hashCode();
    }

    @Override
    public String toString() {
        return "IsStmt{" +
                "type=" + type +
                ", variable=" + variable +
                ", exp=" + exp +
                '}';
    }
}
