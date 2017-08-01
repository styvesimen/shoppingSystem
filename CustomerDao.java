package perso.simen.dao;

import java.util.List;


import perso.simen.entity.Customer;

public interface CustomerDao {
	public int  createCustomer(Customer customer);
	public Customer readCustomer(int customer_id);
	public int  updateCustomer(Customer customer);
	public int deleteCustomer(int customer_id);
	public List<Customer> listAllCustomer();
}
