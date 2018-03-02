package taskapp.application;

import java.text.SimpleDateFormat;
import java.util.*;
import org.beryx.textio.*;

import taskapp.model.Task;
import taskapp.model.TaskManager;

public class Main {
  public static void main(String[] args) {
    
    TextIO textIO = TextIoFactory.getTextIO();
    TextTerminal terminal = textIO.getTextTerminal();
    
    TaskManager taskManager = new TaskManager();
    
    boolean quit = false;

    while (!quit) {

      terminal.println(); // blank line for better formatting

      TodoCommand command = textIO.newEnumInputReader(TodoCommand.class)
              .withAllValuesInline()
              .read("Choose Command?");

      switch (command) {
        case EXIT:
            terminal.println("Bye!");
            quit = true;
            break;
        case DISPLAY_ALL:
        	taskManager.loadTasks();
        	for (taskapp.model.Task task: taskManager.getAllTasks()) {
        		terminal.println(task.getName());
        		terminal.println(task.getDescription());
        		terminal.println(task.getDueDate().toString());
        		terminal.println();
        	}
        	
        	break;
        case ADD_TASK:
        	terminal.println("Enter task name: ");
        	String title = terminal.read(false);
        	terminal.println("Enter description: ");
        	String description = terminal.read(false);
        	boolean correct = false;
        	Date current = new Date();
        	Date dueDate = new Date();
        	while (correct == false) {
        		terminal.println("Enter due date in the form dd/MM/yyyy: ");
        		String due = terminal.read(false);
        		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        		Date dueDate2 = null;
        		try {
        			dueDate2 = dateFormat.parse(due);
        		} catch (java.text.ParseException e) {
        			terminal.println("Date is not of the correct format");
        			break;
        		}
        		if (dueDate2.before(current)) {
        			terminal.println("Due date cannot be before the current date");
        		}
        		else {
        			dueDate = dueDate2;
        			correct = true;
        		}
        	}
        	taskapp.model.Task task = new taskapp.model.Task(title);
        	task.setDescription(description);
        	task.setDueDate(dueDate);
        	int temp = 0;
        	List<Integer> ids = new ArrayList<Integer>();
        	for(Task t : taskManager.getAllTasks()) {
        		ids.add(t.getId());
        	}
        	boolean found = false;
        	while (found == false) {
        		if (ids.contains(temp)) {
        			temp += 1;
        		}
        		else {
        			found = true;
        		}
        	}
        	task.setId(temp);
        	taskManager.addTask(task);
        	taskManager.saveTask();
        	break;
        case NUMBER_OF_TASKS:
        	taskManager.loadTasks();
        	int numberOfTasks = taskManager.getNumberOfTasks();
        	terminal.println("Tasks: " + numberOfTasks);
        	break;
        case DELETE_TASK:
        	taskManager.loadTasks();
        	for (Task t : taskManager.getAllTasks()) {
        		terminal.println(t.getId() + "   " + t.getName());
        		terminal.println("Delete task? y/n: ");
        		String answer = terminal.read(false);
        		if ((answer.equals("y")) || (answer.equals("Y"))) {
        			taskManager.deleteTask(t);
        			terminal.println("Deleted.");
        		}
        	}
      }
    }
  }

  public enum TodoCommand {
    EXIT, DISPLAY_ALL, ADD_TASK, NUMBER_OF_TASKS, DELETE_TASK
  }
}