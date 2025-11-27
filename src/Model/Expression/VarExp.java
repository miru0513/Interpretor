package Model.Expression;


import Model.Utils.Collections.MyIDictionary;
import Model.Utils.Collections.MyIHeap;
import Model.Utils.Exceptions.MyException;
import Model.Value.Value;

public class VarExp implements Exp {
    private String id;

    public VarExp(String id)
    {
        this.id = id;
    }

    @Override
    public Value eval(MyIDictionary<String,Value> tbl, MyIHeap<Value> heapTbl) throws MyException
    {
        if(!tbl.isDefined(id))
            throw new MyException("Variable "+id+" is not defined");
        return tbl.lookUp(id);
    }

    @Override
    public Exp deepCopy() {
        return new VarExp(id);
    }

    @Override
    public String toString(){return id;}
}
