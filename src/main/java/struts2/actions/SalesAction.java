package struts2.actions;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;

import com.opensymphony.xwork2.ActionSupport;

import struts2.model.Customer;
import struts2.service.SalesService;

@Actions({
	@Action("sales") 
})
public class SalesAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private List<Customer> customers;
    
    public void setCustomers(List<Customer> customers) { this.customers = customers; }
    public List<Customer> getCustomers() { return customers; }
    
    public String execute() throws Exception {
    	SalesService hrService = new SalesService();
    	customers = hrService.listCustomers();
    	hrService.closeConn();
        return SUCCESS;
    }
}
