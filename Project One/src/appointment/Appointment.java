

/*
 * Name: Sergio Mateos
 * Class: CS-320 Software Test Automation& QA
 * Institution: Souther New Hampshire University
 * 
 */

package appoinment;

import java.util.Date;

public class Appointment {
	
	//Variables
	private final String appointmentId;
	private Date appointmentDate;
	private String description;
	
	//Requirements for Appointment ID, Appointment Date and Appointment Description
	public Appointment (String appointmentId, Date appointmentDate, String description) {
		
		// Requirement for Appointment ID
		if (appointmentId == null || appointmentId.length() > 10) {
			throw new IllegalArgumentException("Invalid appointmentId");
		}
		
		// Requirement for Appointment Date
		if (appointmentDate == null || appointmentDate.before(new Date())) {
			throw new IllegalArgumentException("Invalid appointmentDate");
		}
		
		// Requirement for Appointment Description 
		if (description == null || description.length() > 50) {
			throw new IllegalArgumentException("Invalid description");
		}
			
		this.appointmentId = appointmentId;
		this.appointmentDate = appointmentDate;
		this.description = description;
	}
	
	// Get	
	public String getAppointmentId () {
		return appointmentId;
	}
	public Date getAppointmentDate () {
		return appointmentDate;
	}
	public String getDescription () {
		return description;
	}
	
	// Set
	public void setAppointmentDate(Date newAppointmentDate) {
		appointmentDate = newAppointmentDate;
	}
	public void setDescription(String newDescription) {
		description = newDescription;
	}
}