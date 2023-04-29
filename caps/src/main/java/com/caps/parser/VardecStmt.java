package com.caps.parser;

public class VardecStmt implements Stmt{
    public final Variable variable;
    public final Exp exp;

    public VardecStmt(final Variable variable, final Exp exp){
        this.variable = variable;
        this.exp = exp;
    }

    @Override
    public boolean equals(final Object other){
        if(other instanceof VardecStmt){
            final VardecStmt otherVardecStmt = (VardecStmt) other;
            return otherVardecStmt.variable.equals(variable) && otherVardecStmt.exp.equals(exp);
        }else{
            return false;
        }
    }

    @Override
    public int hashCode(){
        return (variable.hashCode() + exp.hashCode());
    }
    
    @Override
    public String toString() {
        return ("VardecStmt(" +
                variable.toString() + ", " +
                exp.toString() + ")");
    }
}
