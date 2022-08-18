/*
 * Name: Sergio Mateos
 * Class: CS-320 Software Test Automation& QA
 * Institution: Souther New Hampshire University
 * 
 */

package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import task.TaskService;

//Test to verify TaskService
class TaskServiceTest {

	TaskService taskService = new TaskService();
	
	//Verify adding test
	@Test
	void testAddTask() {
		//Verify that two task are been correctly added
		taskService.addTask("1", "First Task", "First task to be tested");
		taskService.addTask("2", "Second Task", "Second task to be tested");
		assertTrue(taskService.getTasks().get("1").getId().equals("1"));
		assertTrue(taskService.getTasks().get("1").getName().equals("First Task"));
		assertTrue(taskService.getTasks().get("1").getDescription().equals("First task to be tested"));
		assertTrue(taskService.getTasks().get("2").getId().equals("2"));
		assertTrue(taskService.getTasks().get("2").getName().equals("Second Task"));
		assertTrue(taskService.getTasks().get("2").getDescription().equals("Second task to be tested"));
	}
	
	//Verify existing test
	@Test
	void testAddTaskExistingId() {
		//Verify that there are no more than one existing ID	
		taskService.addTask("1", "First Task", "First task to be tested");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			taskService.addTask("1", "Another Task", "Another task to be tested");
		});
	}
	
	//Verify deleting test
	@Test
	void testDeleteTask() {
		//Verify that can remove, add and empty the list
		taskService.addTask("1", "First Task", "First task to be tested");
		taskService.deleteTask("1");
		assertTrue(taskService.getTasks().isEmpty());
	}
	
	//Verify that not existing ID can be delete
	@Test
	void testDeleteTaskIdDoesNotExist() {
		//Verify that is used an ID that not exist
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			taskService.deleteTask("1");
		});
	}
	
	//Verify that can update if the task does not exist
	@Test
	void testUpdateTaskDoesNotExist() {
		taskService.addTask("1", "First Task", "First task to be tested");
		// Verify that the ID do not exist
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			taskService.updateTask("2", "First Task Update", "Update the first task to be tested");
		});
	}
	
	//Verify update task
	@Test
	void testUpdateTask() {
		taskService.addTask("1", "First Task", "First task to be tested");
		taskService.updateTask("1", "First Task Update", "Update the first task to be tested");
		//Verify that is been updated
		assertTrue(taskService.getTasks().get("1").getName().equals("First Task Update"));
		assertTrue(taskService.getTasks().get("1").getDescription().equals("Update the first task to be tested"));
	}

}