package perso.simen.entity;

public class Customer {
	private int customer_id;
	private String firstName;
	private String name;
	private String dob;
	private String email;
	
	
	public Customer(){}
	
	public Customer(int customerId, String firstN, String nameC, String dobC, String emailC){
		this.customer_id= customerId;
		this.firstName= firstN;
		this.name=nameC;
		this.dob=dobC;
		this.email=emailC;
	}
	


	
	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", firstName=" + firstName + ", name=" + name + ", dob=" + dob
				+ ", email=" + email + "]";
	}
	
	
	
}
