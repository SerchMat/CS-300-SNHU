/*
 * Name: Sergio Mateos
 * Class: CS-320 Software Test Automation& QA
 * Institution: Souther New Hampshire University
 * 
 */

package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import appoinment.AppointmentService;
import appoinment.Appointment;

import java.util.Date;

class AppointmentServiceTest {

	@Test
	//Test to verify Service Class 
	void testAppointmentServiceClass() {
		AppointmentService appointmentService = new AppointmentService();
		Appointment appointment = new Appointment("09871", new Date(), "Null Description");
		assertFalse(appointmentService == null);
		assertFalse(appointment == null);
	}
	
	@Test
	//Test to verify Add Appointment
	void testAppointmentServiceClassAddAppointment() {
		AppointmentService appointmentService = new AppointmentService();
		Appointment appointment = new Appointment("23456", new Date(), "Null Description");
		appointmentService.addAppointment(appointment);
		assertTrue(appointmentService.getAppointments().containsValue(appointment));
	}
	
	@Test
	//Test to verify Deleted Appointment
	void testAppointmentServiceClassDeleteAppointment() {
		AppointmentService appointmentService = new AppointmentService();
		Appointment temp = new Appointment("23456", new Date(), "Null Description");
		appointmentService.addAppointment(temp);
		appointmentService.deleteAppointment("23456");
		assertFalse(appointmentService.getAppointments().containsValue(temp));
	}
	
	
	@Test
	//Test to verify Updated Appointment 
	void testAppointmentServiceClassUpdateAppointment() {
		AppointmentService appointmentService = new AppointmentService();
		Appointment temp = new Appointment("09871", new Date(), "Null Description");		
		appointmentService.addAppointment(temp);
		assertTrue(appointmentService.getAppointments().containsValue(temp));
		assertTrue(temp.getDescription().equals("Null Description"));
		appointmentService.updateAppointment("09871", new Date(), "This is a NEW description");
		assertTrue(appointmentService.getAppointments().containsValue(temp));
		assertFalse(temp.getDescription().equals("Null Description"));
	}
}
