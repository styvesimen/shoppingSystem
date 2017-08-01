package perso.simen.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import perso.simen.dao.CustomerDao;
import perso.simen.entity.Customer;
import perso.simen.entity.DBConnector;

public class CustomerImpl implements CustomerDao{

	@Override
	public int createCustomer(Customer customer) {
		Connection connection= null;
		try{
			PreparedStatement ps = null;
			connection = DBConnector.getInstance().getConnection();
			
			ps = connection.prepareStatement("INSERT INTO Customer(`firstname`,`name`,`dob`,`email`) VALUES(?,?,?,?)");
			ps.setString(1, customer.getFirstName());
			ps.setString(2, customer.getName());
			ps.setString(3, customer.getDob());
			ps.setString(4, customer.getEmail());
			
			int result = ps.executeUpdate();
			return result;
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				connection.close();
			}catch(Exception e){
				try{
					throw e;
				}catch(Exception e1){
					e1.printStackTrace();
				}
			}
		}
		return 0;
	}

	@Override
	public Customer readCustomer(int customer_id) {
		Connection connection=null;
		Customer customer = null;
		try{
			PreparedStatement ps= null;
			connection = DBConnector.getInstance().getConnection();
			
			ps = connection.prepareStatement("SELECT * FROM Customer WHERE `customer_id`=?");
			ps.setInt(1, customer_id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				customer = new Customer();
				customer.setCustomer_id(customer_id);
				customer.setFirstName(rs.getString("firstname"));
				customer.setName(rs.getString("name"));
				customer.setDob(rs.getString("dob"));
				customer.setEmail(rs.getString("email"));
			}
			return customer;
			
		}catch(Exception ex){
			ex.printStackTrace();
		
		} finally{
			try{
				connection.close();
			}catch(Exception e){
				e.printStackTrace();
				try{
					throw e;
				}catch(Exception e1){
					e1.printStackTrace();
				}
			}
		}
		return null;
	}

	@Override
	public int updateCustomer(Customer customer) {
		Connection connection=null;
		try{
			PreparedStatement ps=null;
			connection = DBConnector.getInstance().getConnection();		
			
			ps = connection.prepareStatement("UPDATE Customer SET `firstname`=?,`name`=?,`dob`=?, `email`=? WHERE `customer_id`=?");
			ps.setString(1, customer.getFirstName());
			ps.setString(2, customer.getName());
			ps.setString(3, customer.getDob());
			ps.setString(4, customer.getEmail());
			ps.setInt(5, customer.getCustomer_id());
			
			int result = ps.executeUpdate();
			return result;
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				connection.close();
			}catch(Exception e){
				try{
					throw e;
				}catch(Exception e1){
					e1.printStackTrace();
				}
			}
		}
		return 0;
	}

	@Override
	public int deleteCustomer(int customer_id) {
		Connection connection=null;
		
		try{
			PreparedStatement ps = null;
			connection = DBConnector.getInstance().getConnection();
			
			ps = connection.prepareStatement("DELETE FROM `Customer` WHERE `customer_id`=?");
			ps.setInt(1, customer_id);
			
			int result=ps.executeUpdate();
			
			return result;
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				connection.close();
			}catch(Exception e){
				try{
					throw e;
				}catch(Exception e1){
					e1.printStackTrace();
				}
			}
		}
		return 0;
	}

	
	@Override
	public List<Customer> listAllCustomer() {
		
		//Customer customer=null;
		List<Customer> list;
		Connection connection=null;
		try{ 
			
			PreparedStatement ps = null;
			list = new ArrayList<Customer>() ;
			connection = DBConnector.getInstance().getConnection();
			
			ps = connection.prepareStatement("SELECT * FROM Customer");
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				Customer customer = new Customer();
				customer.setCustomer_id(rs.getInt("customer_id"));
				customer.setFirstName(rs.getString("firstname"));
				customer.setName(rs.getString("name"));
				customer.setDob(rs.getString("dob"));
				customer.setEmail(rs.getString("email"));
				list.add(customer);
			}
			return list;
		}catch(Exception ex){
			ex.printStackTrace();
		} finally{
			try{
				connection.close();
			}catch(Exception e){
				try{
					throw e;
				}catch(Exception e1){
					e1.printStackTrace();
				}
			}
		}
			return null;
	}
}
