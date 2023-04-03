package com.caps.parser;

public class ParseResult <A>{
    public final A result;
    public final int nextP;

    public ParseResult(A result, int nextP) {
        this.result = result;
        this.nextP = nextP;
    }
}
