package Model.Statement;


import Model.Expression.Exp;
import Model.PrgState.PrgState;
import Model.Type.BoolType;
import Model.Utils.Exceptions.MyException;
import Model.Value.BoolValue;
import Model.Value.Value;

public class WhileStmt implements IStmt{
    private Exp condition;
    IStmt stmt;

    public WhileStmt(Exp condition, IStmt stmt){
        this.stmt=stmt;
        this.condition=condition;
    }

    @Override
    public PrgState execute(PrgState prgState) throws MyException {
        Value val=condition.eval(prgState.getSymTable(),prgState.getHeapTable());
        if(val.getType().equals(new BoolType())){
            BoolValue bValue=(BoolValue)val;
            if(bValue.getValue())
            {
                prgState.getStk().push(this);
                prgState.getStk().push(stmt);
            }
        }
        else throw new MyException("Invalid condition!");
        return prgState;
    }

    @Override
    public IStmt deepCopy()
    {
        return new WhileStmt(condition.deepCopy(), stmt.deepCopy());
    }

    @Override
    public String toString() {
        return "While(" + condition.toString() + "){" + stmt.toString() + "}";
    }
}
