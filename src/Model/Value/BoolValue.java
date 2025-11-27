package Model.Value;

import Model.Type.BoolType;
import Model.Type.Type;

public class BoolValue implements Value {
    private boolean val;
    public BoolValue(boolean val) {this.val = val;}
    public boolean getValue() {return val;}

    @Override
    public String toString() {return Boolean.toString(val);}

    @Override
    public Type getType() {
        return new BoolType();
    }

    @Override
    public Value deepCopy(){return new BoolValue(val);}

    @Override
    public boolean equals(Object other) {
        if(other instanceof BoolValue otherBoolValue)
            return this.val == otherBoolValue.val;
        else return false;
    }
}
