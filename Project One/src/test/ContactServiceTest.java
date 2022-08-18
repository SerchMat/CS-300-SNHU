
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

import contact.ContactService;

class ContactServiceTest {

	@Test
	//	Test to Add Contact with a unique ID
	void testContactServiceClassAddWithId() {
		ContactService service = new ContactService();
		service.addContact("1234", "Enrique", "Zarate", "9999999999", "21527 E Homstead");
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.addContact("1234", "Enrique", "Zarate", "9999999999", "21527 E Homestead");
		});
	}
	
	@Test
	//	Test to Delete Contact per ContactID
	void testContactServiceClassDeleteWithId() {
		ContactService service = new ContactService();
		service.addContact("1234", "Enrique", "Zarate", "9999999999", "21527 E Homstead");
		service.addContact("123456", "Enrique", "Zarate", "9999999999", "21527 E Homstead");
		service.removeContact("1234");
		assert(service.contactList.size() == 1);
		
	}
	
	@Test
	//	Test Able to Update field by ContactID
	void testContactServiceClassUpdateWithId() {
		ContactService service = new ContactService();
		service.addContact("1234", "Enrique", "Zarate", "9999999999", "21527 E Homstead");
		service.addContact("123456", "Enrique", "Zarate", "9999999999", "21527 E Homstead");
		service.updateContact("1234", "Tim", "Fisher", "8888888888", "2100 W Ajo");
		assertSame(service.contactList.get("1234").getFirstName(), "Tim");
		
	}

}