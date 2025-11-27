package Repository;

import Model.PrgState.PrgState;
import Model.Utils.Exceptions.MyException;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Repository implements IRepository {
    private List<PrgState> programs;
    private String file;

    public Repository(PrgState prgState,String file) {
        this.file=file=file;
        this.programs = new ArrayList<>();
        this.programs.add(prgState);
    }
    @Override
    public PrgState getCrtPrg() {
        return this.programs.getFirst();
    }

    @Override
    public void add(PrgState prgState) {
        this.programs.add(prgState);
    }

    @Override
    public void logPrgStateExec() throws MyException
    {
        try{
            PrintWriter logfile=new
                    PrintWriter(new BufferedWriter(new FileWriter(file,true)));
            logfile.println(getCrtPrg().toString());
            logfile.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }


    }
}
