
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

import appoinment.Appointment;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

class AppointmentTest {

	@Test
	//Test to verify Appointment Class
	void testAppointmentClass() {
		Date now = new Date();
		Appointment appointment = new Appointment("09876", now, "Null Description");
		assertTrue(appointment.getAppointmentId().equals("09876"));
		assertTrue(appointment.getAppointmentDate().equals(now));
		assertTrue(appointment.getDescription().equals("Null Description"));
	}
	
	@Test
	//Test to verify that the Appointment Id met requirement length
	void testAppointmentClassAppointmentIdTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("098766789123", new Date(), "Dull Description");
		});
	}
	
	@Test
	//Test to verify that the Appointment Id is not NULL
	void testAppointmentClassAppointmentIdNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(null, new Date(), "Dull Description");
		});
	}
	
	//Test Requirement 2: Appointment Date
	@Test
	//Test to verify that Appointment Date met requirements
	void testAppointmentClassAppointmentDayInPast() throws ParseException {
		Date pastDate = new SimpleDateFormat("MMMM d, yyyy").parse("July 28, 2022");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("09876", pastDate, "Null Description");
		});
	}
	
	@Test
	void testAppointmentClassAppointmentDayNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("09876", null, "Null Description");
		});
	}
	
	@Test
	//Test to verify that the Appointment Description met requirement length
	void testAppointmentClassDescriptionTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("09876", new Date(), "This description is too long and should throw an exception");
		});
	}
	
	@Test
	//Test to verify that the Appointment Description is not NULL
	void testAppointmentClassDescriptionNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("09876", new Date(), null);
		});
	}
}
