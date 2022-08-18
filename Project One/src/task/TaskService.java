/*
 * Name: Sergio Mateos
 * Class: CS-320 Software Test Automation& QA
 * Institution: Souther New Hampshire University
 * 
 */

package task;

import java.util.Hashtable;

public class TaskService {
	
	// HashTable to allocated the 
	Hashtable<String, Task> tasks = new Hashtable<String, Task>();
	
	//Add task to unique ID, Name and Description
	public void addTask(String id, String name, String description) {
		if (tasks.get(id) != null) {
			throw new IllegalArgumentException("This task ID already exists");
		}
		Task task = new Task(id, name, description);
		tasks.put(id, task);
	}
	
	//Delete task to unique ID, Name and Description
	public void deleteTask(String id) {
		if (tasks.get(id) == null) {
			throw new IllegalArgumentException("Task ID does not exist");
		}			
		tasks.remove(id);
	}
	
	//Update task to unique ID, Name and Description
	public void updateTask(String id, String name, String description) {
		if (tasks.get(id) == null) {
			throw new IllegalArgumentException("Task ID does not exist");
		}
		tasks.get(id).updateName(name);
		tasks.get(id).updateDescription(description);
	}
	
	public Hashtable<String, Task> getTasks() {
		return tasks;
	}
}
