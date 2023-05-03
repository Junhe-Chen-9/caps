package com.caps.parser;

public class MethodDefStmt implements Stmt{
    public final Type type;
    public final Variable variable;
    public final Parameter parameter;
    public final Stmt stmt;

    public MethodDefStmt(final Type type, final Variable variable, final Parameter parameter, final Stmt stmt) {
        this.type = type;
        this.variable = variable;
        this.parameter = parameter;
        this.stmt = stmt;
    }

    public boolean equals(final Object other){
        if(other instanceof MethodDefStmt){
            final MethodDefStmt otherMethodDefStmt = (MethodDefStmt) other;
            return otherMethodDefStmt.type.equals(type) &&
                    otherMethodDefStmt.variable.equals(variable) &&
                    otherMethodDefStmt.parameter.equals(parameter) &&
                    otherMethodDefStmt.stmt.equals(stmt);
        }else{
            return false;
        }
    }

    @Override
    public int hashCode(){
        return (type.hashCode() + variable.hashCode() + parameter.hashCode() + stmt.hashCode());
    }

    @Override
    public String toString() {
        return ("MethodDefStmt(" +
                type.toString() + ", " +
                variable.toString() + ", " +
                parameter.toString() + ", " +
                stmt.toString() + ")");
    }
}
