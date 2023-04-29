package com.caps.parser;

import java.util.List;

public class ProgonStmt implements Stmt{
    public final List<Stmt> stmts;

    public ProgonStmt(final List<Stmt> stmts){
        this.stmts = stmts;
    }

    @Override
    public boolean equals(final Object other) {
        return (other instanceof ProgonStmt &&
                stmts.equals(((ProgonStmt)other).stmts));
    }

    @Override
    public int hashCode() {
        return stmts.hashCode();
    }

    @Override
    public String toString() {
        return "ProgonStmt(" + stmts.toString() + ")";
    }
    
}
