package com.caps.parser;

public class ReturnsStmt implements Stmt{
    public final Exp exp;
    public ReturnsStmt(Exp exp){
        this.exp = exp;
    }

    @Override
    public boolean equals(final Object other){
        if(other instanceof ReturnsStmt){
            final ReturnsStmt otherReturnsStmt = (ReturnsStmt) other;
            return otherReturnsStmt.exp == exp;
        }else{
            return false;
        }
    }

    @Override
    public int hashCode(){
        return (exp.hashCode());
    }
    
    @Override
    public String toString() {
        return ("VardecStmt(" +
                exp.toString() + ")");
    }



}
