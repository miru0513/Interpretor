package Model.Statement;

import Model.Expression.Exp;
import Model.PrgState.PrgState;
import Model.Type.Type;
import Model.Utils.Collections.MyIDictionary;
import Model.Utils.Collections.MyIHeap;
import Model.Utils.Collections.MyIStack;
import Model.Utils.Exceptions.MyException;
import Model.Value.Value;

public class AssignStmt implements IStmt{
    String id;
    Exp exp;
    public AssignStmt(String id, Exp exp) {
        this.id = id;
        this.exp = exp;
    }

    @Override
    public IStmt deepCopy()
    {
        return new AssignStmt(this.id, this.exp.deepCopy());
    }

    @Override
    public PrgState execute(PrgState state) throws MyException
    {
        MyIStack<IStmt> stk=state.getStk();
        MyIDictionary<String, Value> symTbl=state.getSymTable();
        MyIHeap<Value> heapTable=state.getHeapTable();

        if(symTbl.isDefined(id))
        {
            Value val=exp.eval(symTbl,heapTable);
            Type typId=(symTbl.lookUp(id)).getType();
            if(val.getType().equals(typId))
            {
                symTbl.put(id,val);
            }
            else throw new MyException("declared type of variable: "+ id +
                    " and type of the assigned do not match!");
        }
        else throw new MyException("the used variable: " + id + " was never declared before!");

        return state;
    }


    @Override
    public String toString() {
        return id+ " = " + exp.toString();
    }
}

