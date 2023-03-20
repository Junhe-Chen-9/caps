package com.caps.lexer;

// this is our token interface
public interface Token {
    // public int myMethod(boolean b);

    // all three defined on Object
    // all objects must inherit from Object

    // compare against another object
    // Needed to see if expected tokens match actual
    public boolean equals(Object other);

    // seen hash tables before? - hit yes
    // used in hash tables / HashMap
    //
    // returns an integer representing this object
    // obj1.equals(obj2) ==> obj1.hashCode() == obj2.hashCode()
    //
    public int hashCode();

    // expected: IdentifierToken("foo")
    // received: IdentifierToken("bar")
    //
    // expected: IdentifierToken@F27639
    // received: IdentifierToken@AB387C
    //
    // Gets a string representation of an object
    public String toString();
}