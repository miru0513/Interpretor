package Model.Statement;

import Model.PrgState.PrgState;
import Model.Utils.Exceptions.MyException;

public class NopStmt implements IStmt{
    public NopStmt()
    {

    }

    @Override
    public IStmt deepCopy()
    {
        return new NopStmt();
    }

    @Override
    public PrgState execute(PrgState prgState)
    {
        return prgState;
    }


    @Override
    public String toString() {
        return "nop";
    }
}
