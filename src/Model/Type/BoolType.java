package Model.Type;

import Model.Value.BoolValue;
import Model.Value.Value;

public class BoolType implements Type {
    @Override
    public boolean equals(Object another){
        if(another instanceof IntType)
            return true;
        else
            return false;
    }
    @Override
    public String toString(){return "bool";}

    @Override
    public Value defaultValue() {return new BoolValue(false);}

    @Override
    public Type deepCopy() {return new BoolType();}

}