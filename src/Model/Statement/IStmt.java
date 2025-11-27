package Model.Statement;

import Model.PrgState.PrgState;
import Model.Utils.Exceptions.MyException;

public interface IStmt {
    PrgState execute(PrgState state)throws MyException;
    IStmt deepCopy();
}