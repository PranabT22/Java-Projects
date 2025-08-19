import java.util.ArrayList;
import java.util.Scanner;

class Todo {
    String task;
    int status; // if 1: Not started, elif 2: Ongoing, elif 3: Completed

    Todo(String task) {
        this.task = task;
        this.status = 1;
    }

    @Override
    public String toString() {
        String statusStr = "";
        switch (status) {
            case 1: statusStr = "Not started"; break;
            case 2: statusStr = "Ongoing"; break;
            case 3: statusStr = "Completed"; break;
        }
        return task + " [" + statusStr + "]";
    }
}

public class TodoListApp {
    public static void main(String[] args) {
        ArrayList<Todo> todoList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nTODO LIST APPLICATION");
            System.out.println("1. Add To-do");
            System.out.println("2. Display To-do List");
            System.out.println("3. Update Task Status");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");
            int option = sc.nextInt();
            sc.nextLine(); // Clear newline

            switch (option) {
                case 1:
                    System.out.print("Enter your to-do: ");
                    String task = sc.nextLine();
                    todoList.add(new Todo(task));
                    System.out.println("Task added.");
                    break;
                case 2:
                    if (todoList.isEmpty()) {
                        System.out.println("No tasks in the list!");
                    } else {
                        System.out.println("Your To-do List:");
                        for (int i = 0; i < todoList.size(); i++) {
                            System.out.println((i + 1) + ". " + todoList.get(i));
                        }
                    }
                    break;
                case 3:
                    if (todoList.isEmpty()) {
                        System.out.println("No tasks to update!");
                    } else {
                        System.out.println("Select a task to update status:");
                        for (int i = 0; i < todoList.size(); i++) {
                            System.out.println((i + 1) + ". " + todoList.get(i));
                        }
                        System.out.print("Enter task number: ");
                        int idx = sc.nextInt() - 1;
                        if (idx < 0 || idx >= todoList.size()) {
                            System.out.println("Invalid task number.");
                            break;
                        }
                        System.out.println("Select status for the task:");
                        System.out.println("1. Not started");
                        System.out.println("2. Ongoing");
                        System.out.println("3. Completed");
                        System.out.print("Enter status number: ");
                        int status = sc.nextInt();
                        if (status < 1 || status > 3) {
                            System.out.println("Invalid status.");
                            break;
                        }
                        if (status == 3) {
                            todoList.remove(idx);
                            System.out.println("Task marked as completed and removed from list.");
                        } else {
                            todoList.get(idx).status = status;
                            System.out.println("Task status updated.");
                        }
                    }
                    break;
                case 4:
                    System.out.println("Exit");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
