package Repository;

import Model.PrgState.PrgState;
import Model.Utils.Exceptions.MyException;

public interface IRepository {
    public PrgState getCrtPrg();
    public void add(PrgState prgState);
    void logPrgStateExec() throws MyException;;
}
