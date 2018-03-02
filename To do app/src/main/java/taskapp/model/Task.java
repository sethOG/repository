package taskapp.model;

import java.util.Date;

public class Task implements java.io.Serializable{
	
	private String title;
	private String description;
	private Date dueDate;
	private int id;
	private boolean important;
	
	public Task(String name) {
		title = name;
		description = "";
	}
	
	public String getName() {
		return title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String desc) {
		description = desc;
	}
	public void setDueDate(Date due) {
		dueDate = due;
	}
	public Date getDueDate() {
		return dueDate;
	}
	
	public String toString() {
		return ("name: " + this.getName() + " description " + this.getDescription() + " due date: " + this.getDueDate());
	}
	public void setId(int num) {
		id = num;
	}
	public int getId() {
		return id;
	}
	public void setImportance(boolean imp) {
		important = imp;
	}
	public boolean getImportance() {
		return important;
	}
}