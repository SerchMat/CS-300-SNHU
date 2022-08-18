
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
import contact.Contact;

public class ContactTest {
	
    @Test 
    //Test Contact Object to verify if is working.
    public void testContactClass(){
        Contact Toni = new Contact("0", "Miguel", "Mendoza", "5165578252", "219 Gertrude");
        assertTrue(Toni.getFirstName().equals("Miguel"));
        assertTrue(Toni.getID().equals("0")&& Toni.getID() != null);
        assertTrue(Toni.getFirstName().length() < 10 && Toni.getFirstName() != null);
        assertTrue(Toni.getLastName().length() < 10 && Toni.getLastName() != null);
        assertTrue(Toni.getPhone().length() == 10 && Toni.getPhone() != null);
        assertTrue(Toni.getAddress().length() < 30 && Toni.getAddress() != null);
       
    }
    //The test will throw exception if the requirement are not met
    @Test
    //Test to verify the ID is not null or has too many chars
    public void testIllegalArgumentsForContactClass(){        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "Miguel", "Mendoza", "5165578252", "219 Gertrude");
            new Contact("1234566757891", "MIguel", "Mendoza", "5125578252", "219 Gertrude");
        });
        
        //Test to verify if first name or last name is null or has too many chars 
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("0", "Miguelewtb", "Mendoza", "5165278252", "219 Gertrude");
            new Contact("0", "Miguel", "Menfewbws", "5165578222", "219 Gertrude");
            new Contact("0", null, "Mendoza", "5165578252", "219 Gertrude");
            new Contact("0", "Miguel", null, "5165578252", "219 Gertrude");
        });
        
        //Test to verify if the phone number is null or has too many chars
         Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("0", "Miguel", "Mendoza", "5165578252", "219 Gertrude");
            new Contact("0", "Miguel", "Mendoza", null, "219 Gertrude");
        });       
         
        //Test to verify that the address is not null or too long 
         Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("0", "Miguel", "Mendoza", "5165578252", "219 grqewqgrGertqwgrwegrweggrqgfrdaqwrfvqawvcqwavrude");
            new Contact("0", "Miguel", "Mendoza", "5165578252", null);
        });                          
    }
}

