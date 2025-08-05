package pojo;

public class Name {
	String firstname;
	String lastname;
	
	
	// Constructor
    public Name(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

	
	
	public String getFirst_name() {
		return firstname;
	}
	public void setFirst_name(String firstname) {
		this.firstname = firstname;
	}
	public String getLast_name() {
		return lastname;
	}
	public void setLast_name(String lastname) {
		this.lastname = lastname;
	}
	
	

}
