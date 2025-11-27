package Model.Expression;

import Model.Utils.Collections.MyIDictionary;
import Model.Utils.Collections.MyIHeap;
import Model.Utils.Exceptions.MyException;
import Model.Value.Value;

public class ValueExp implements Exp {
    Value e;

    public ValueExp(Value e) {this.e = e;}

    public Value eval(MyIDictionary<String, Value> tbl, MyIHeap<Value> heapTbl) throws MyException
    {
        return e;
    }


    @Override
    public Exp deepCopy() {
        return new ValueExp(e.deepCopy());
    }

    @Override
    public String toString() {return e.toString();}
}
