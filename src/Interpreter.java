import Controller.Controller;
import Model.PrgState.PrgState;
import Model.Statement.IStmt;
import Model.Utils.Collections.MyDictionary;
import Model.Utils.Collections.MyHeap;
import Model.Utils.Collections.MyList;
import Model.Utils.Collections.MyStack;
import Repository.*;
import View.Commands.ExitCommand;
import View.Commands.RunExample;
import View.Commands.TextMenu;
import View.Examples;

public class Interpreter {
    public static void main(String[] args)
    {
        IStmt ex1 = Examples.example1();
        IStmt ex2 = Examples.example2();
        IStmt ex3 = Examples.example3();
        IStmt ex4 = Examples.example4();
        IStmt ex5 = Examples.example5();
        IStmt ex6 = Examples.example6();
        IStmt ex7 = Examples.example7();
        IStmt ex8 = Examples.example8();
        IStmt ex9 = Examples.example9();
        IStmt ex10 = Examples.example10();
        IStmt ex11 = Examples.example11();

        PrgState state1 = new PrgState(new MyStack<>(), new MyDictionary<>(), new MyList<>(), new MyDictionary<>(),
                new MyHeap<>(), ex1);
        IRepository repo1 = new Repository(state1,"ex1.txt");
        Controller ctrl1 = new Controller(repo1);

        PrgState state2 = new PrgState(new MyStack<>(), new MyDictionary<>(), new MyList<>(), new MyDictionary<>(),
                new MyHeap<>(), ex2);
        IRepository repo2 = new Repository(state2,"ex2.txt");
        Controller ctrl2 = new Controller(repo2);

        PrgState state3 = new PrgState(new MyStack<>(), new MyDictionary<>(), new MyList<>(), new MyDictionary<>(),
                new MyHeap<>() ,ex3);
        IRepository repo3 = new Repository(state3,"ex3.txt");
        Controller ctrl3 = new Controller(repo3);

        PrgState state4=new PrgState(new MyStack<>(), new MyDictionary<>(), new MyList<>(), new MyDictionary<>(),
                new MyHeap<>() ,ex4);
        IRepository repo4 = new Repository(state4,"ex4.txt");
        Controller ctrl4 = new Controller(repo4);

        PrgState state5=new PrgState(new MyStack<>(), new MyDictionary<>(), new MyList<>(), new MyDictionary<>(),
                new MyHeap<>() ,ex5);
        IRepository repo5 = new Repository(state5,"ex5.txt");
        Controller ctrl5 = new Controller(repo5);

        PrgState state6=new PrgState(new MyStack<>(), new MyDictionary<>(), new MyList<>(), new MyDictionary<>(),
                new MyHeap<>() ,ex6);
        IRepository repo6 = new Repository(state6, "ex6.txt");
        Controller ctrl6 = new Controller(repo6);

        PrgState state7=new PrgState(new MyStack<>(), new MyDictionary<>(), new MyList<>(), new MyDictionary<>(),
                new MyHeap<>() ,ex7);
        IRepository repo7 = new Repository(state7, "ex7.txt");
        Controller ctrl7 = new Controller(repo7);


        PrgState state8=new PrgState(new MyStack<>(), new MyDictionary<>(), new MyList<>(), new MyDictionary<>(),
                new MyHeap<>() ,ex8);
        IRepository repo8 = new Repository(state8, "ex8.txt");
        Controller ctrl8 = new Controller(repo8);

        PrgState state9=new PrgState(new MyStack<>(), new MyDictionary<>(), new MyList<>(), new MyDictionary<>(),
                new MyHeap<>() ,ex9);
        IRepository repo9 = new Repository(state9, "ex9.txt");
        Controller ctrl9 = new Controller(repo9);

        PrgState state10=new PrgState(new MyStack<>(), new MyDictionary<>(), new MyList<>(), new MyDictionary<>(),
                new MyHeap<>() ,ex10);
        IRepository repo10 = new Repository(state10, "ex10.txt");
        Controller ctrl10 = new Controller(repo10);

        PrgState state11=new PrgState(new MyStack<>(), new MyDictionary<>(), new MyList<>(), new MyDictionary<>(),
                new MyHeap<>() ,ex11);
        IRepository repo11 = new Repository(state11, "ex11.txt");
        Controller ctrl11 = new Controller(repo11);

        TextMenu menu=new TextMenu();
        menu.addCommand(new ExitCommand("0","exit"));
        menu.addCommand(new RunExample("1",ex1.toString(),ctrl1));
        menu.addCommand(new RunExample("2",ex2.toString(),ctrl2));
        menu.addCommand(new RunExample("3",ex3.toString(),ctrl3));
        menu.addCommand(new RunExample("4",ex4.toString(),ctrl4));
        menu.addCommand(new RunExample("5",ex5.toString(),ctrl5));
        menu.addCommand(new RunExample("6",ex6.toString(),ctrl6));
        menu.addCommand(new RunExample("7",ex7.toString(),ctrl7));
        menu.addCommand(new RunExample("8",ex8.toString(),ctrl8));
        menu.addCommand(new RunExample("9",ex9.toString(),ctrl9));
        menu.addCommand(new RunExample("10",ex10.toString(),ctrl10));
        menu.addCommand(new RunExample("11",ex11.toString(),ctrl11));
        menu.show();
    }
}