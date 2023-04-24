package com.caps.parser;

public class StringExp implements Exp {
    public final String value;

    public StringExp(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object other) {
        return (other instanceof StringExp && value.equals(((StringExp) other).value));
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public String toString() {
        return "StringLiteralExp{" +
                "value='" + value + '\'' +
                '}';
    }
}