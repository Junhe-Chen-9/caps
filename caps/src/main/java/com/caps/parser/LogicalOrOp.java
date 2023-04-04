package com.caps.parser;

public class LogicalOrOp implements Op{
    @Override
    public boolean equals(final Object other){
        return other instanceof LogicalOrOp;
    }
    @Override
    public int hashCode() { return 6; }

    @Override
    public String toString() { return "LogicalOrOp{}"; }
}
