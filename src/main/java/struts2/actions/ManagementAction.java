package struts2.actions;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

import struts2.model.Order;
import struts2.model.User;
import struts2.service.ManagementService;

@Actions({
	@Action("management"),  
	@Action(value="ordersByUser", results={@Result(name = ActionSupport.SUCCESS, location = "management.jsp")}) 
})
public class ManagementAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private List<User> users;
	private List<Order> orders = null;
	private Long userId = null;
    
    public void setUsers(List<User> users) { this.users = users; }
    public List<User> getUsers() { return users; }
	public Long getUserId() { return userId; }
	public void setUserId(Long userId) { this.userId = userId; }
	public List<Order> getOrders() { return orders; }
	public void setOrders(List<Order> orders) { this.orders = orders;}
    
    public String execute() throws Exception {
    	ManagementService mService = new ManagementService();
    	if ( userId != null ) {
    		orders = mService.listOrdersForUser(userId);
    	}
    	users = mService.listUsers();
    	mService.closeConn();
        return SUCCESS;
    }
}
