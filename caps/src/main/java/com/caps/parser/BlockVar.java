package com.caps.parser;

import java.util.List;

public class BlockVar implements Variable{
    public final List<Variable> vars;

    public BlockVar(final List<Variable> vars){
        this.vars = vars;
    }

    @Override
    public boolean equals(final Object other) {
        return (other instanceof BlockVar &&
                vars.equals(((BlockVar)other).vars));
    }

    @Override
    public int hashCode() {
        return vars.hashCode();
    }

    @Override
    public String toString() {
        return "BlockVar(" + vars.toString() + ")";
    }
}
