
/*
 * Name: Sergio Mateos
 * Class: CS-320 Software Test Automation& QA
 * Institution: Souther New Hampshire University
 * 
 */

package contact;

import java.util.HashMap;

public class ContactService {
	
	//	Hashmap object for the Contact Services class.
	public final HashMap<String, Contact> contactList = new HashMap<String, Contact>();
	
	//	Adds Contact to the Contact Service object
	public void addContact(String uniqueId, String firstName, String lastName, String phoneNumber, String address) {
			if (contactList.containsKey(uniqueId)) {
				throw new IllegalArgumentException("That ID already exists.");
			}
		
		Contact contactNew = new Contact (uniqueId, firstName, lastName, phoneNumber, address);
		contactList.put(uniqueId, contactNew);
	}
	
	//	Deletes a Contact from the Contact Service list by ID
	public void removeContact(String contactId) {
			if (contactList.containsKey(contactId)) {
				contactList.remove(contactId);
			}
	}
	
	//	Updated the Contatc based on the ID, First Name, Last Name, Phone Number and Address
	public void updateContact(String contactId, String firstName, String lastName, String phoneNumber, String address) {
			if (contactList.containsKey(contactId)) {
				contactList.get(contactId).setFirstName(firstName);
				contactList.get(contactId).setLastName(lastName);
				contactList.get(contactId).setPhone(phoneNumber);
				contactList.get(contactId).setAddress(address);
			}
	}
	
}