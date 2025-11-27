package View.Commands;

import Controller.Controller;
import Model.Utils.Exceptions.MyException;

public class RunExample extends Command {
    private Controller ctr;
    public RunExample(String key, String description, Controller ctr) {
        super(key, description);
        this.ctr = ctr;
    }

    @Override
    public void execute() {
        try{
            ctr.allStep();
            System.out.println("All steps have been executed!");
        }
        catch(MyException e){
            System.out.println(e.getMessage());
        }
    }
}