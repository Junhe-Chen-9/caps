package com.caps.parser;

public class IfElseStmt implements Stmt{
    public final Exp exp;
    public final Stmt ifBody;
    public final Stmt elseBody;

    public IfElseStmt(Exp exp, Stmt ifBody, Stmt elseBody){
        this.exp = exp;
        this.ifBody = ifBody;
        this.elseBody = elseBody;
    }

    @Override
    public boolean equals(final Object other){
        if(other instanceof IfElseStmt){
            final IfElseStmt otherIfElseStmt = (IfElseStmt) other;
            return otherIfElseStmt.exp == exp && otherIfElseStmt.ifBody == ifBody && otherIfElseStmt.elseBody == elseBody;
        }else{
            return false;
        }
    }

    @Override
    public int hashCode(){
        return (exp.hashCode() + ifBody.hashCode() + elseBody.hashCode());
    }

    @Override
    public String toString() {
        return "IfElseStmt{" +
                "exp=" + exp +
                ", ifBody=" + ifBody +
                ", elseBody=" + elseBody +
                '}';
    }
}
