package struts2.actions;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;

import com.opensymphony.xwork2.ActionSupport;

import struts2.model.Order;
import struts2.service.ShippingService;

@Actions({
	@Action("shipping") 
})
public class ShippingAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private List<Order> orders;
    
    public void setOrders(List<Order> orders) { this.orders = orders; }
    public List<Order> getOrders() { return orders; }
    
    public String execute() throws Exception {
    	ShippingService shService = new ShippingService();
    	orders = shService.listOrders();
    	shService.closeConn();
        return SUCCESS;
    }
}
