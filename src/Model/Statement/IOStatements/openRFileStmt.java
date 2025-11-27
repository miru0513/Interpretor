package Model.Statement.IOStatements;

import Model.Expression.Exp;
import Model.PrgState.PrgState;
import Model.Statement.IStmt;
import Model.Type.StringType;
import Model.Utils.Collections.MyIStack;
import Model.Utils.Exceptions.MyException;
import Model.Value.StringValue;
import Model.Value.Value;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class openRFileStmt implements IStmt {
    private Exp exp;

    public openRFileStmt(Exp exp) {
        this.exp = exp;
    }

    @Override
    public PrgState execute(PrgState prgState) throws MyException {
        MyIStack<IStmt> stk=prgState.getStk();
        Value val=exp.eval(prgState.getSymTable(),prgState.getHeapTable());
        if(val.getType().equals(new StringType()))
        {
            StringValue s=(StringValue)val;
            if(prgState.getFileTable().isDefined(s))
                throw new MyException("file already opened!");
            try
            {
                String path=s.getValue();
                BufferedReader reader=new BufferedReader(new FileReader(path));
                prgState.getFileTable().put(s,reader);
            }
            catch (IOException e){
                throw new MyException("file open failed!");
            }
        }
        else throw new MyException("Expression not of string type");

        return prgState;
    }

    @Override
    public IStmt deepCopy() {
        return new openRFileStmt(exp.deepCopy());
    }

    @Override
    public String toString() {
        return "openRFile(" +  exp.toString() + ')';
    }
}
