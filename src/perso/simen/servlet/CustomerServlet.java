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
//			Customer customer = (Customer) session.getAttribute("customer");
			
			
			out = response.getWriter();
			CustomerDao customerDao = new CustomerImpl();
			String action = request.getParameter("action");
			
			System.out.println("Action: "+action);
			
			if(action.equalsIgnoreCase("create")){
				Customer customer = new Customer();
				//customer.setCustomer_id(Integer.parseInt(request.getParameter("customer_id")));
				customer.setFirstName(request.getParameter("firstname"));
				customer.setName(request.getParameter("name"));
				customer.setDob(request.getParameter("dob"));
				customer.setEmail(request.getParameter("email"));
				customerDao.createCustomer(customer);
			}
			else if(action.equalsIgnoreCase("read")){
				// TO FIX
				///customerDao.readCustomer(customer.getCustomer_id());
			}
			else if(action.equalsIgnoreCase("update")){
				// TO FIX
				//customerDao.updateCustomer(customer);
			}
			else if(action.equalsIgnoreCase("delete")){
				// TO FIX
				// improve index.jsp to attach customer id on 'Delete' click
//				int customerId = Integer.parseInt(request.getParameter("customer_id"));
				int customerId = 8;
				customerDao.deleteCustomer(customerId);
				System.out.println("Customer with id "+customerId+" deleted");
			}
//			else if(action.equalsIgnoreCase("getAll")){
//				customerDao.listAllCustomer();
//			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		} finally {
			out.close();
		}
		
	}

}
