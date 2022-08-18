
/*
 * Name: Sergio Mateos
 * Class: CS-320 Software Test Automation& QA
 * Institution: Souther New Hampshire University
 * 
 */

package contact;

public class Contact {
	
    //Variables
    private String ID; 
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
    
    
   //Verify requirements for the ID, First Name, Last Name, Phone Number and Address 
    public Contact(String id, String firstName, String lastName, String phoneNumber, String address){
        
        if(id == null || id.length() > 10){
            throw new IllegalArgumentException("Invalid ID");
        }
        
        if(firstName == null || firstName.length() > 10){
            throw new IllegalArgumentException("Invalid first name");
        }
        
        if(lastName == null || lastName.length() > 10){
            throw new IllegalArgumentException("Invalid last name");
        }
        
        if(phoneNumber == null || phoneNumber.length() != 10){
            throw new IllegalArgumentException("Invalid phone number");
        }
        
        if(address == null || address.length() > 30){
            throw new IllegalArgumentException("Invalid address");
        }
        //Setting ID, First Name, Last Name, Phone Number and Address to set them.
        this.ID = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phoneNumber;
        this.address = address;
    }
    
    
    //Get and Set methods for the Contact object variables
    public String getFirstName(){
        return this.firstName;
    }
    
    public String getLastName(){
        return this.lastName;
    }
    
    public String getID(){
        return this.ID;
    }
    
    public String getAddress(){
        return this.address;
    }

    public String getPhone(){
        return this.phone;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    
    public void setAddress(String address){
        this.address = address;
    }

    public void setPhone(String phoneNumber){
        this.phone = phoneNumber;
    }    
}
