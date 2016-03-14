package struts2.actions;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

import struts2.model.User;
import struts2.service.ManagementService;

public class ManagementAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private List<User> users;
	private User userOrders;
	private Long userId = null;
	private ManagementService managementService;
    
    public void setUsers(List<User> users) { this.users = users; }
    public List<User> getUsers() { return users; }
	public Long getUserId() { return userId; }
	public void setUserId(Long userId) { this.userId = userId; }
	public User getUserOrders() { return userOrders; }
	public void setUserOrders(User userOrders) { this.userOrders = userOrders; }
    
	@Action("management")  
    public String execute() throws Exception {
    	managementService = new ManagementService();
    	if ( userId != null ) {
        	userOrders = managementService.listOrdersForUser(userId);
    	} else {
    		userOrders = null;
    	}
    	users = managementService.listUsers();
    	managementService.closeConn();
        return SUCCESS;
    }
    
	@Action(value="userOrders", results={@Result(name = ActionSupport.SUCCESS, location = "management.jsp")}) 
    public String userOrders() throws Exception {
    	managementService = new ManagementService();
    	userOrders = managementService.listOrdersForUser(userId);
    	users = managementService.listUsers();
    	managementService.closeConn();
        return SUCCESS;
    }

}
