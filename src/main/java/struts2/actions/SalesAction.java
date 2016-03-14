package struts2.actions;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

import struts2.model.Customer;
import struts2.service.SalesService;

public class SalesAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private List<Customer> customers;
	private Customer customerOrders;
	private Long customerId;
	private SalesService salesService;
    
    public void setCustomers(List<Customer> customers) { this.customers = customers; }
    public List<Customer> getCustomers() { return customers; }
	public Customer getCustomerOrders() { return customerOrders; }
	public void setCustomerOrders(Customer customerOrders) { this.customerOrders = customerOrders; }
	public Long getCustomerId() { return customerId; }
	public void setCustomerId(Long customerId) { this.customerId = customerId; }
    
	@Action("sales")  
    public String execute() throws Exception {
    	salesService = new SalesService();
    	if ( customerId != null ) {
        	customerOrders = salesService.listOrdersForCustomer(customerId);
    	} else {
        	customerOrders = null;
    	}
    	customers = salesService.listCustomers();
    	salesService.closeConn();
        return SUCCESS;
    }
    
	@Action(value="customerOrders", results={@Result(name = ActionSupport.SUCCESS, location = "sales.jsp")}) 
    public String customerOrders() throws Exception {
    	salesService = new SalesService();
    	customerOrders = salesService.listOrdersForCustomer(customerId);
    	customers = salesService.listCustomers();
    	salesService.closeConn();
        return SUCCESS;    	
    }
}
