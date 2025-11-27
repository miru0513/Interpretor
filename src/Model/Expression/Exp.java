package Model.Expression;

import Model.Utils.Collections.MyIDictionary;
import Model.Utils.Collections.MyIHeap;
import Model.Utils.Exceptions.MyException;
import Model.Value.Value;

public interface Exp {
    Value eval(MyIDictionary<String, Value> tbl, MyIHeap<Value> heapTbl) throws MyException;
    Exp deepCopy();
}
