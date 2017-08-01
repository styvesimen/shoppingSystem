package perso.simen.servlet;

import java.io.IOException;
import java.io.PrintWriter;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSession;

import perso.simen.dao.CustomerDao;
import perso.simen.dao.impl.CustomerImpl;
import perso.simen.entity.Customer;




@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out = null;
		
		try{
			
			HttpSession session = request.getSession();
			Customer customer = (Customer) session.getAttribute("customer");
			
			out = response.getWriter();
			CustomerDao customerDao = new CustomerImpl();
			String action = request.getParameter("action");
			
			Customer c = new Customer();
			c.setCustomer_id(Integer.parseInt(request.getParameter("customer_id")));
			c.setFirstName(request.getParameter("firstname"));
			c.setName(request.getParameter("name"));
			c.setDob(request.getParameter("dob"));
			c.setEmail(request.getParameter("email"));
			
			
			if(action.equalsIgnoreCase("create")){
				customerDao.createCustomer(customer);
			}
			else if(action.equalsIgnoreCase("read")){
				customerDao.readCustomer(customer.getCustomer_id());
			}
			else if(action.equalsIgnoreCase("update")){
				customerDao.updateCustomer(customer);
			}
			else if(action.equalsIgnoreCase("delete")){
				customerDao.deleteCustomer(customer.getCustomer_id());
			}
			else if(action.equalsIgnoreCase("getAll")){
				customerDao.listAllCustomer();
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		} finally {
			out.close();
		}
		
	}

}
