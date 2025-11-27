package Model.Statement;

import Model.Expression.Exp;
import Model.PrgState.PrgState;
import Model.Utils.Exceptions.MyException;
import Model.Value.Value;

public class PrintStmt implements IStmt {
    Exp exp;
    public PrintStmt(Exp exp) {
        this.exp = exp;
    }

    @Override
    public IStmt deepCopy()
    {
        return new PrintStmt(exp.deepCopy());
    }

    @Override
    public PrgState execute(PrgState prgState) throws MyException {
        Value val=exp.eval(prgState.getSymTable(),prgState.getHeapTable());
        prgState.getOut().add(val);
        return prgState;
    }

    @Override
    public String toString() {
        return "print(" + exp + ")";
    }
}
