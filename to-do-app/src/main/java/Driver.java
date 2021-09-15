import models.ToDoItem;
import utils.PrintView;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {

        // View command line arguments passed to app
        for(int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }

        //Scanner object bound to System.in, the console input
        Scanner sc = new Scanner(System.in);

        /*List of ToDoItem objects
        Here we create a number of static todoitems and store them into our list. Later we will re-design
        this to be more dynamic and persistent.
         */
        List<ToDoItem> toDoList = new LinkedList<>();
        ToDoItem newItem1 = new ToDoItem("Build a to do list");
        toDoList.add(newItem1);
        ToDoItem newItem2 = new ToDoItem("Debug the new to do list");
        toDoList.add(newItem2);
        ToDoItem newItem3 = new ToDoItem("enjoy your new to do list!");
        toDoList.add(newItem3);




        //Main app loop
        boolean running = true;
        while(running) {
            System.out.println("===MAIN MENU===\nEnter selection:\n\n1) View ToDo Items.\n2) Mark item complete.\nQ) Quit");
            String input = sc.nextLine();

            switch(input) {
                case "1":
                    System.out.println("========== To Do List: ==========");
                    for(int i = 0; i < toDoList.size(); i++) {
                        PrintView.printMyView(i, toDoList.get(i));
                    }
                    System.out.println("=================================");
                    break;
                case "2":
                    //mark item complete method
                    System.out.println("========== To Do List: ==========");
                    for(int i = 0; i < toDoList.size(); i++) {
                        PrintView.printMyView(i, toDoList.get(i));
                    }
                    System.out.print("\nEnter item number to mark complete: ");
                    String choice = sc.nextLine(); //Or we could do sc.nextInt();
                    toDoList.get(Integer.parseInt(choice)).setComplete(true);

                    System.out.println("\n Item #" + choice + " is complete!");

                    break;
                case "Q":
                case "q":
                    running = false;
                    break;
            }
        }


    }
}
