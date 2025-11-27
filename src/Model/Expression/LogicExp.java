package Model.Expression;

import Model.Type.BoolType;
import Model.Utils.Collections.MyIDictionary;
import Model.Utils.Collections.MyIHeap;
import Model.Utils.Exceptions.MyException;
import Model.Value.BoolValue;
import Model.Value.Value;

public class LogicExp implements Exp{
    Exp e1;
    Exp e2;
    int op;

    public LogicExp(String operator,Exp e1, Exp e2) {
        this.e1 = e1;
        this.e2 = e2;
        if(operator.equals("&&"))
            this.op=1;
        else if(operator.equals("||"))
            this.op=2;
    }

    private String getStringOperator(int op)
    {
        if(op==1)
            return "&&";
        if(op==2)
            return "||";
        return "";
    }


    @Override
    public Value eval(MyIDictionary<String,Value> tbl, MyIHeap<Value> heapTbl) throws MyException
    {
        Value v1,v2;
        v1=e1.eval(tbl,heapTbl);
        if(v1.getType().equals(new BoolType()))
        {
            v2=e2.eval(tbl,heapTbl);
            if(v2.getType().equals(new BoolType()))
            {
                BoolValue b1=(BoolValue)v1;
                BoolValue b2=(BoolValue)v2;
                boolean n1,n2;
                n1=b1.getValue();
                n2=b2.getValue();
                if(op==1) return new BoolValue(n1 && n2);
                if(op==2) return new BoolValue(n1 || n2);

                throw new MyException("Invalid operand");

            }
            else throw new MyException("Second operand is not a bool!");
        }
        else throw new MyException("First operand is not bool!");
    }
    @Override
    public Exp deepCopy() {
        return new LogicExp(getStringOperator(op), e1.deepCopy(), e2.deepCopy());
    }

    @Override
    public String toString() {return e1.toString()+" "+getStringOperator(op)+" "+e2.toString();}
}
