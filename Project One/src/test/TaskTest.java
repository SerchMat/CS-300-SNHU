/*
 * Name: Sergio Mateos
 * Class: CS-320 Software Test Automation& QA
 * Institution: Souther New Hampshire University
 * 
 */

package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import task.Task;

class TaskTest {
	
	//Test to verify the TAsk pass the test
	@Test
	void testTask() {
		Task task = new Task("1", "Create Task", "Create a Task to be tested");
		assertTrue(task.getId().equals("1"));
		assertTrue(task.getName().equals("Create Task"));
		assertTrue(task.getDescription().equals("Create a Task to be tested"));
	}
	
	//Test to verify the ID pass the test
	@Test
	void testTaskIdNull() {
		// Test null Id
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task(null, "Create Task", "Create a Task to be tested");
		});
	}
	
	//Test to verify the ID pass the test
	@Test
	void testTaskIdTooLong() {
		// Test Id with more than 10 characters
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("12345678901", "Create Task", "Create a Task to be tested");
		});
	}
	
	//Test to verify the Name pass the test
	@Test
	void testTaskNameNull() {
		// Test null name
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("1", null, "Create a Task to be tested");
		});
	}
	
	//Test to verify the ID pass the test
	@Test
	void testTaskNameTooLong() {
		// Test name with more than 20 characters
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("1", "123456789012345678901", "Create a Task to be tested");
		});
	}
	
	//Test to verify the Description pass the test
	@Test
	void testTaskDescriptionNull() {
		// Test null name
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("1", "Create Task", null);
		});
	}
	
	//Test to verify the Description pass the test
	@Test
	void testTaskDescriptionTooLong() {
		// Test name with more than 50 characters
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("1", "Create Task", "123456789012345678901234567890123456789012345678901");
		});
	}
	
	// Test to verify it updates
	@Test
	void testUpdates() {
		Task task = new Task("1", "Create Task", "Create a Task to be tested");
		task.updateName("Update Task");
		assertTrue(task.getName().equals("Update Task"));
		task.updateDescription("Update Task's Description");
		assertTrue(task.getDescription().equals("Update Task's Description"));
	}

}
