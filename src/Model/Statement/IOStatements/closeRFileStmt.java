package Model.Statement.IOStatements;

import Model.Expression.Exp;
import Model.PrgState.PrgState;
import Model.Statement.IStmt;
import Model.Type.StringType;
import Model.Utils.Exceptions.MyException;
import Model.Value.StringValue;
import Model.Value.Value;

import java.io.BufferedReader;

public class closeRFileStmt implements IStmt {
    Exp exp;

    public closeRFileStmt(Exp exp)
    {
        this.exp=exp;
    }

    @Override
    public PrgState execute(PrgState prgState) throws MyException
    {
        Value val=exp.eval(prgState.getSymTable(),prgState.getHeapTable());
        if(!val.getType().equals(new StringType()))
            throw new MyException("Wrong type of expression");

        StringValue s=((StringValue)val);
        BufferedReader br=prgState.getFileTable().lookUp(s);
        if(br==null)
            throw new MyException("File not found");

        try{
            br.close();
            prgState.getFileTable().remove(s);
        }
        catch(Exception e){
            throw new MyException("Error closing the file");
        }

        return prgState;
    }

    @Override
    public IStmt deepCopy()
    {
        return new closeRFileStmt(exp.deepCopy());
    }

    @Override
    public String toString() {
        return "closeRFile(" + exp.toString() + ")";
    }
}
