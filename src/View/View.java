/*
package View;

import Controller.Controller;
import Model.PrgState.PrgState;
import Repository.IRepository;
import Repository.Repository;
import Model.Statement.IStmt;
import Model.Utils.Collections.MyDictionary;
import Model.Utils.Collections.MyList;
import Model.Utils.Collections.MyStack;

import java.util.List;
import java.util.Scanner;

public class View {
    private final List<IStmt> examples;
    private final Scanner scanner = new Scanner(System.in);

    public View(List<IStmt> examples) {
        this.examples = examples;
    }

    public void start() {
        while (true) {
            printMenu();
            System.out.print("Choose: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.\n");
                continue;
            }

            if (choice == 0) break;

            if (choice < 0 || choice > examples.size()) {
                System.out.println("Invalid choice!\n");
                continue;
            }

            IStmt selected = examples.get(choice - 1);

            // Build a fresh program each time, no map of controllers needed
            PrgState state = new PrgState(
                    new MyStack<>(),
                    new MyDictionary<>(),
                    new MyList<>(),
                    selected
            );
            IRepository repo = new Repository(state);
            Controller ctrl = new Controller(repo);

            try {
                ctrl.allStep();
            } catch (Exception ex) {
                System.out.println("Runtime error: " + ex.getMessage());
            }

            System.out.println();
        }
    }

    private void printMenu() {
        System.out.println("=== Menu ===");
        System.out.println("1. int v; v=2; Print(v)");
        System.out.println("2. int a; int b; a=2+3*5; b=a+1; Print(b)");
        System.out.println("3. bool a; int v; a=true; If a Then v=2 Else v=3; Print(v)");
        System.out.println("4. int a; a = 10 / 0; Print(a)  // division by zero");
        System.out.println("5. Print(b)  // undefined variable");
        System.out.println("0. Exit");
    }
}
*/