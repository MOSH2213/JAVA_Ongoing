package p_03;

public class Customer {
	private String email;
	private String password;
	private String user;
	private int phone;
	private int address;
	private String image;
	
	public Customer(String email, String password, String user, int phone, int address, String image) {
	
		this.email = email;
		this.password = password;
		this.user = user;
		this.phone = phone;
		this.address = address;
		this.image = image;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public String getUser() {
		return user;
	}
	public int getPhone() {
		return phone;
	}
	public int getAddress() {
		return address;
	}
	public String getImage() {
		return image;
	}

}
