package com.caps.parser;

import java.util.ArrayList;
import java.util.List;

public class BlockParam implements Parameter {
    public final List<Parameter> params;

    public BlockParam(final List<Param> types){
        //this.params = params;
        params = new ArrayList<>();
    }



    @Override
    public boolean equals(final Object other) {
        return (other instanceof BlockParam &&
                params.equals(((BlockParam)other).params));
    }

    @Override
    public int hashCode() {
        return params.hashCode();
    }

    @Override
    public String toString() {
        return "BlockParam(" + params.toString() + ")";
    }

}
