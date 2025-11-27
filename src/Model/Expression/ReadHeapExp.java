package Model.Expression;

import Model.Utils.Collections.MyIDictionary;
import Model.Utils.Collections.MyIHeap;
import Model.Utils.Exceptions.MyException;
import Model.Value.RefValue;
import Model.Value.Value;

public class ReadHeapExp implements Exp
{
    private Exp exp;
    public ReadHeapExp(Exp exp)
    {
        this.exp = exp;
    }

    @Override
    public Value eval(MyIDictionary<String, Value> tbl, MyIHeap<Value> heapTbl) throws MyException
    {
        Value val=exp.eval(tbl,heapTbl);
        if(val instanceof RefValue refVal)
        {
            int adr= refVal.getAddress();
            if(!heapTbl.isDefined(adr))
                throw new MyException("Invalid address accessed!");

            return heapTbl.lookUp(adr);
        }
        else throw new MyException("The expression is not a RefValue!");
    }

    @Override
    public Exp deepCopy()
    {
        return new ReadHeapExp(exp.deepCopy());
    }

    @Override
    public String toString()
    {
        return exp.toString();
    }
}
