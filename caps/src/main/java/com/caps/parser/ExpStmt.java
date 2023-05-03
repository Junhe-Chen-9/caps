package com.caps.parser;

public class ExpStmt implements Stmt {
    public final Exp exp;
    
    
    public ExpStmt(Exp exp){
        this.exp = exp;
    }

    @Override
    public boolean equals(final Object other){
        if(other instanceof ExpStmt){
            final ExpStmt otherExpStmt = (ExpStmt) other;
            return otherExpStmt.exp.equals(exp);
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
        return "expression statement{" +
                "exp=" + exp +
                '}';
    }

}
