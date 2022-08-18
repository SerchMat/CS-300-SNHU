
/*
 * Name: Sergio Mateos
 * Class: CS-320 Software Test Automation& QA
 * Institution: Souther New Hampshire University
 * 
 */


package appoinment;

import java.util.HashMap;
import java.util.Date;

public class AppointmentService {
	
	// HashTable to allocated the appointments
	private HashMap<String, Appointment> appointments;

	public AppointmentService() {
		appointments = new HashMap<>();
	}
	
	//	Add Appointments
	public void addAppointment (Appointment appointment) {
		appointments.put(appointment.getAppointmentId(), appointment);
	}
	
	//	Delete Appointments 
	public void deleteAppointment (String appointmentId) {
		appointments.remove(appointmentId);
	}
	
	//	Update Appointments
	public void updateAppointment (String appointmentId, Date newApptDate, String newDescription) {
		appointments.get(appointmentId).setAppointmentDate(newApptDate);
		appointments.get(appointmentId).setDescription(newDescription);
	}
	
	public HashMap<String, Appointment> getAppointments () {
		return appointments;
	}
}

