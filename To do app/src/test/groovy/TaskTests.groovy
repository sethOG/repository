import spock.lang.Specification
import taskapp.application.*
import java.util.*;
import taskapp.model.*

// Need to import any other classes we want to test...

class TaskTests extends Specification {

  def "New task manager displays no tasks"() {

    given:
    TaskManager t = new TaskManager()
    when:
    List<Task> tasks = new ArrayList<Task>()
    tasks = t.getAllTasks()
    then:
    tasks.size() == 0
  }
  
  def "Task manager with one task displays one task"() {
  	
  	given:
  	TaskManager t = new TaskManager()
  	t.addTask(new Task("Walk the dog"))
  	when:
  	List<Task> tasks = new ArrayList<Task>()
    tasks = t.getAllTasks()
  	then:
  	tasks.size() == 1
  }
  
  def "create task with no description"(){
	  given:
	  Task task = new Task("Wash the dog");
	  when:
	  String description = task.getDescription();
	  then:
	  description == "";
  }
  def "create task with a description"(){
	  given:
	  Task task = new Task("Feed the dog");
	  task.setDescription("give him half a can");
	  when:
	  String description = task.getDescription();
	  then:
	  description == "give him half a can";
  }
  def "display number of tasks when there are zero"(){
	  given:
	  TaskManager taskManager = new TaskManager();
	  when:
	  int number = taskManager.getNumberOfTasks();
	  then:
	  number == 0;
  }
  def "display number of taks when there is one"(){
	  given:
	  TaskManager taskManager = new TaskManager();
	  taskManager.addTask(new Task("go to sleep"));
	  when:
	  int number = taskManager.getNumberOfTasks();
	  then:
	  number == 1;
  }
  def "create task with no due date"(){
	  given:
	  Task task = new Task("go home");
	  when:
	  Date date = task.getDueDate();
	  then:
	  date == null;
  }
  def "create task with a due date"(){
	  given:
	  Task task = new Task("go home");
	  Date date = new Date(2017,10,11);
	  task.setDueDate(date);
	  when:
	  Date newDate = task.getDueDate();
	  then:
	  newDate == date;
  }
  def "task has been saved so loading all saved tasks will increase task list by one"(){
	  given: "created a new task titled 'Walk the dog'"
	  TaskManager taskManager = new TaskManager();
	  Task task = new Task("Walk the dog");
	  int preSize = taskManager.getAllTasks().size();
	  when: "the task is added to the task manager and saved to file"
	  taskManager.addTask(task);
	  taskManager.saveTask();
	  taskManager.loadTasks();
	  int postSize = taskManager.getAllTasks().size();
	  then: "the newly saved task should appear in the list of lasts loaded from the file"
	  postSize == preSize + 1;
  }
  def "deleting a task will remove that task from the tasks list"(){
	  given:
	  TaskManager taskManager = new TaskManager();
	  Task task = new Task("dance");
	  when:
	  taskManager.addTask(task);
	  taskManager.saveTask();
	  taskManager.loadTasks();
	  then:
	  taskManager.getAllTasks().contains(task) == false;
  }
  def "a user can make a task that is important"(){
	  given:
	  TaskManager taskManager = new TaskManager();
	  Task task = new Task("")
	  when:
	  task.setImportance(true);
	  then:
	  taskManager.isImportant(task) == true;
  }
  def "a task can be not important"(){
	  given:
	  TaskManager taskManager = new TaskManager();
	  Task task = new Task("");
	  when:
	  task.setImportance(false);
	  then:
	  taskManager.isImportant(task) == false;
  }
}