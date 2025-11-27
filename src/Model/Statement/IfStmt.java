package Model.Statement;

import Model.Expression.Exp;
import Model.PrgState.PrgState;
import Model.Type.BoolType;
import Model.Utils.Collections.MyIDictionary;
import Model.Utils.Collections.MyIHeap;
import Model.Utils.Collections.MyIStack;
import Model.Utils.Exceptions.MyException;
import Model.Value.BoolValue;
import Model.Value.Value;

public class IfStmt implements IStmt {

    Exp exp;
    IStmt thenS;
    IStmt elseS;

    public IfStmt(Exp exp, IStmt thenS, IStmt elseS) {
        this.exp = exp;
        this.thenS = thenS;
        this.elseS = elseS;
    }

    @Override
    public IStmt deepCopy()
    {
        return new IfStmt(exp.deepCopy(), thenS.deepCopy(), elseS.deepCopy());
    }


    @Override
    public PrgState execute(PrgState state) throws MyException
    {
        MyIStack<IStmt> stk=state.getStk();
        MyIDictionary<String, Value> symTable=state.getSymTable();
        MyIHeap<Value> heapTable=state.getHeapTable();

        Value condition=exp.eval(symTable,heapTable);
        if(!condition.getType().equals(new BoolType())) {
            throw new MyException("Condition is not boolean");
        }

        BoolValue boolCond=(BoolValue)condition;
        if(boolCond.getValue())
            stk.push(thenS);
        else stk.push(elseS);
        return state;
    }

    @Override
    public String toString()
    {
        return "(IF(" + exp.toString() + ")THEN("+thenS.toString()
                +")ELSE("+ elseS.toString()+"))";
    }

}
