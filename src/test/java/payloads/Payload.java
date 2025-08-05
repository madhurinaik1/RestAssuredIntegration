package payloads;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import com.github.javafaker.Faker;
import com.github.javafaker.PhoneNumber;

import pojo.Address;
import pojo.Cart;
import pojo.CartProduct;
import pojo.Geolocation;
import pojo.Login;
import pojo.Name;
import pojo.Product;
import pojo.User;

public class Payload {

	public static final Faker faker=new Faker();
	
	private static final String categories[]= {"electronics", "furniture", "clothing", "books", "beauty"};

	private static final Random random=new Random();
	
	
	public static Product payloadProduct() {
		String name=faker.commerce().productName();
		double price=Double.parseDouble(faker.commerce().price());
		String description=faker.lorem().sentence();
		String imageUrl="https://i.pravatar.cc/100";
		String category=categories[random.nextInt(5)];
		
//		new Product(name, price, description, imageUrl, category);
		return new Product(name, price, description, imageUrl, category);

		
	}
	
	
	/*User
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
	            long:'81.1496'a
	        }
	    },
	    phone:'1-570-236-7033'
	}
	*/
	
	public static User userPayload()
	{
		//name
		String firstName=faker.name().firstName();
		String lastName=faker.name().lastName();
		
		Name name=new Name(firstName,lastName);
		
		
		
	   //geolocation
		
		//location
			String lat=faker.address().latitude();
			String lng=faker.address().longitude();
			
			Geolocation location=new Geolocation(lat,lng);
		
		
		
		//address
		
		String city =faker.address().city();
		String street=faker.address().streetName();
		int number=random.nextInt(100);
		String zipcode=faker.address().zipCode();
		Address address=new Address(city,street,number,zipcode,location);

		
		//User
		
		String email=faker.internet().emailAddress();
		String username=faker.name().username();
		String password=faker.internet().password();
		String phoneNumber=faker.phoneNumber().cellPhone();
		
		
		User user=new User(email,username,password,name,address,phoneNumber);
		
		return user;

	}
		//cart
		
		public static Cart cartPayload(int userId) {
	        List<CartProduct> products = new ArrayList<>();

	     // Adding one random product to the cart
	        int productId = random.nextInt(100);
	        int quantity = random.nextInt(10) + 1;
	       	        
	        CartProduct product=new CartProduct(productId,quantity);
	        products.add(product);
	        
	        //new Date()  ----> Returns date like  Wed Feb 19 13:17:45 IST 202
	        // We need to convert this to "yyyy-MM-dd" format in String 
	        
	        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);// Define output date format
	        String date =outputFormat.format(new Date());
	        
	        return new Cart(userId, date, products);

	}
		
		public static Login loginPayload()
		{
			String username=faker.name().username();
			String password=faker.internet().password();
			
			Login login=new Login(username,password);
			return login;
			
		}

	

}
