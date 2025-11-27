package Model.Statement;

import Model.PrgState.PrgState;
import Model.Statement.IStmt;
import Model.Utils.Collections.MyIStack;
import Model.Utils.Exceptions.MyException;

public class CompStmt implements IStmt {
    IStmt first;
    IStmt snd;

    public CompStmt(IStmt first, IStmt snd) {
        this.first = first;
        this.snd = snd;
    }

    public IStmt getFirst() {
        return this.first;
    }

    public IStmt getSnd() {
        return this.snd;
    }

    @Override
    public PrgState execute(PrgState state) throws MyException {
        MyIStack<IStmt> stk = state.getStk();
        stk.push(snd);
        stk.push(first);
        return state;
    }

    @Override
    public IStmt deepCopy() {
        return new CompStmt(this.first.deepCopy(), this.snd.deepCopy());
    }

    @Override
    public String toString(){return "("+first.toString()+","+snd.toString()+")";}
}
