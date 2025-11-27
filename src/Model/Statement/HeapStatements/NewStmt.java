package Model.Statement.HeapStatements;

import Model.Expression.Exp;
import Model.PrgState.PrgState;
import Model.Statement.IStmt;
import Model.Utils.Exceptions.MyException;
import Model.Value.RefValue;
import Model.Value.Value;

public class NewStmt implements IStmt{
    String name;
    Exp exp;

    public NewStmt(String name,Exp exp){
        this.name=name;
        this.exp=exp;
    }

    @Override
    public PrgState execute(PrgState prgState) throws MyException {
        Value v=prgState.getSymTable().lookUp(name);
        if(v==null) {
            throw new MyException("Symbol "+name+" not found");
        }

        if(v instanceof RefValue refValue){
            Value val=exp.eval(prgState.getSymTable(),prgState.getHeapTable());
            if(val.getType().equals(refValue.getLocationType())){
                int address=prgState.getHeapTable().put(val);
                prgState.getSymTable().put(name,new RefValue(address,val.getType()));
            }
            else throw new MyException("Inner type does not match");
        }
        else throw new MyException("Variable "+name+" is not of refType");
        return prgState;
    }

    @Override
    public IStmt deepCopy() {
        return new NewStmt(name,exp.deepCopy());
    }

    @Override
    public String toString()
    {
        return "new(" + name + ", " + exp + ")";
    }
}
