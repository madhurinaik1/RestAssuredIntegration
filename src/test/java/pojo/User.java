package pojo;

public class User {
/*	
	{
	    email:'John@gmail.com',
	    username:'johnd',
	    password:'m38rmF$',
	    name:{
	        firstname:'John',
	        lastname:'Doe'
	    },
	    address:{
	        city:'kilcoole',
	        street:'7835 new road',
	        number:3,
	        zipcode:'12926-3874',
	        geolocation:{
	            lat:'-37.3159',
	            long:'81.1496'
	        }
	    },
	    phone:'1-570-236-7033'
	}
*/
	private String email;
	private String username;
	private String password;
	private Name name;
	private Address address;
	private String phone;



    
    public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Name getName() {
		return name;
	}


	public void setName(Name name) {
		this.name = name;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


    
    
	public User(String email, String username, String password, Name name, Address address, String phone) {
		super();
		this.email = email;
		this.username = username;
		this.password = password;
		this.name = name;
		this.address = address;
		this.phone = phone;
	}

    
    
}
