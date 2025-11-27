package Model.Expression;

import Model.Type.IntType;
import Model.Utils.Collections.MyIDictionary;
import Model.Utils.Collections.MyIHeap;
import Model.Utils.Exceptions.MyException;
import Model.Value.BoolValue;
import Model.Value.IntValue;
import Model.Value.Value;

public class RelationalExp implements Exp{
    private Exp first;
    private Exp second;
    private int operator; // 1-<, 2-<=, 3- ==, 4- !=, 5- >, 6- >=

    public RelationalExp(Exp first, Exp second, String operator) {
        this.first = first;
        this.second=second;
        if(operator.equals("<"))
            this.operator=1;
        else if(operator.equals("<="))
            this.operator=2;
        else if (operator.equals("=="))
            this.operator=3;
        else if(operator.equals("!="))
            this.operator=4;
        else if(operator.equals(">"))
            this.operator=5;
        else if(operator.equals(">="))
            this.operator=6;
    }

    private String getOperatorString(int op)
    {
        if(op==1)
            return "<";
        else if(op==2)
            return "<=";
        else if(op==3)
            return "==";
        else if(op==4)
            return "!=";
        else if (op==5)
            return ">";
        else if(op==6)
            return ">=";
        return "";
    }

    @Override
    public Value eval(MyIDictionary<String, Value> tbl, MyIHeap<Value> heapTbl) throws MyException
    {
        Value v1 = first.eval(tbl,heapTbl);
        if(v1.getType().equals(new IntType()))
        {
            Value v2=second.eval(tbl,heapTbl);
            if(v2.getType().equals(new IntType()))
            {
                IntValue val1=(IntValue)v1;
                IntValue val2=(IntValue)v2;
                int n1=val1.getVal();
                int n2=val2.getVal();

                if(operator==1) {
                    return new BoolValue(n1<n2);
                }
                else if(operator==2) {
                    return new BoolValue(n1<=n2);
                }
                else if(operator==3) {
                    return new BoolValue(n1==n2);
                }
                else if(operator==4){
                    return new BoolValue(n1!=n2);
                }
                else if(operator==5){
                    return new BoolValue(n1>n2);
                }
                else if(operator==6) {
                    return new BoolValue(n1>=n2);
                }
                else throw new MyException("Invalid operator!");
            }
            else throw new MyException("second expression is invalid!");
        }
        else throw new MyException("first expression is invalid!");
    }

    @Override
    public Exp deepCopy()
    {
        return new RelationalExp(first.deepCopy(), second.deepCopy(), getOperatorString(operator));
    }

    @Override
    public String toString()
    {
        return first.toString() + " " + getOperatorString(operator)  + " " + second.toString();
    }

}
