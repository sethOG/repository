package taskapp.model;

import java.io.*;
import java.util.*;

public class TaskManager implements java.io.Serializable{
	
	private List<Task> tasks = new ArrayList<Task>();
	private File file = new File("src/main/java/taskapp/files/storedTasks.txt");
	
	public List<Task> getAllTasks(){
		return tasks;
	}
	
	public void addTask(Task t) {
		tasks.add(t);
	}
	public int getNumberOfTasks() {
		return tasks.size();
	}
	
	public void saveTask() {
		try {
			FileOutputStream fileOutput = new FileOutputStream(file);
			ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
			objectOutput.writeObject(tasks);
			objectOutput.close();
		} catch(Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
	}
	
	public void clear() {
		tasks = new ArrayList<Task>();
	}
	
	public void loadTasks() {
		try {
			clear();
			FileInputStream fileInput = new FileInputStream(file);
			ObjectInputStream objectInput = new ObjectInputStream(fileInput);
			List<Task> tasksFromFile = (List<Task>)objectInput.readObject();
			tasks = tasksFromFile;
			
			objectInput.close();
		} catch(Exception e) {
			e.getMessage();
		}
		
	}
	public void deleteTask(Task task) {
		loadTasks();
		Iterator<Task> it = tasks.iterator();
		while (it.hasNext()) {
		  Task task1 = it.next();
		  if (task1.getId() == task.getId()) {
		    it.remove();
		  }
		}
		saveTask();
	}
	public boolean isImportant(Task task) {
		return task.getImportance();
	}
}