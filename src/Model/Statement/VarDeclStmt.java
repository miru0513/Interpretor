package Model.Statement;

import Model.PrgState.PrgState;
import Model.Type.Type;
import Model.Utils.Collections.MyIDictionary;
import Model.Utils.Exceptions.MyException;
import Model.Value.Value;

public class VarDeclStmt implements IStmt{
    String name;
    Type type;

    public VarDeclStmt(String name, Type type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return type.toString() + " " + name;
    }

    @Override
    public IStmt deepCopy()
    {
        return new VarDeclStmt(name, type.deepCopy());
    }

    @Override
    public PrgState execute(PrgState prgState) throws MyException
    {
        MyIDictionary<String, Value> symTable=prgState.getSymTable();
        if(symTable.isDefined(this.name))
            throw new MyException("Variable already exists!");
        symTable.put(name,type.defaultValue());
        return prgState;
    }
}
