package Model.Value;

import Model.Type.IntType;
import Model.Type.Type;

public class IntValue implements Value {
    int val;
    public IntValue(int v){ val=v;}

    public int getVal(){return val;}

    @Override
    public String toString() {return Integer.toString(val);}

    @Override
    public Type getType() {
        return new IntType();
    }
    @Override
    public Value deepCopy() {return new IntValue(val);}

    @Override
    public boolean equals(Object other) {
        if(other instanceof IntValue intV) {
            return this.val == intV.val;
        }
        return false;
    }
}
