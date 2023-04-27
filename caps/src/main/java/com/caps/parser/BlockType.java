package com.caps.parser;

import java.util.List;

public class BlockType implements Type {
    public final List<Type> types;

    public BlockType(final List<Type> types){
        this.types = types;
    }

    @Override
    public boolean equals(final Object other) {
        return (other instanceof BlockType &&
                types.equals(((BlockType)other).types));
    }

    @Override
    public int hashCode() {
        return types.hashCode();
    }

    @Override
    public String toString() {
        return "BlockType(" + types.toString() + ")";
    }
}
