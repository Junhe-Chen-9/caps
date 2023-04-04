package com.caps.parser;

public class ParseResult <A>{
    public final A result;
    public final int nextP;

    public ParseResult(final A result, final int nextP) {
        this.result = result;
        this.nextP = nextP;
    }

    @Override
    public boolean equals(final Object other){
        if (other instanceof ParseResult){
            final ParseResult<A> otherResult = (ParseResult<A>)other;
            return (result.equals(otherResult.result) && nextP == otherResult.nextP);
        }
        else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return result.hashCode() + nextP;
    }

    @Override
    public String toString() {
        return("ParseResult: " + result.toString() + "\nNext Position: " + nextP);
    }
}
