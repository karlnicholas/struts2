package struts2.actions;

import java.math.BigDecimal;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

import struts2.service.SalesService;

@Action(value="customerDelete", results={@Result(name = ActionSupport.SUCCESS, location = "customers", type = "redirectAction")})
public class CustomerDeleteAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
    private String empNo;
 
	public String getEmpNo() {
		return empNo;
	}
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

    public String execute() throws Exception {
    	SalesService hrService = new SalesService();
    	hrService.deleteCustomer(new BigDecimal(empNo));
    	hrService.closeConn();
        return SUCCESS;
    }

}
