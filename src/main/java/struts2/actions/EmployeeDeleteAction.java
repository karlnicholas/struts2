package struts2.actions;

import java.math.BigDecimal;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

import struts2.service.HRService;

@Action(value="employeeDelete", results={@Result(name = ActionSupport.SUCCESS, location = "employees", type = "redirectAction")})
public class EmployeeDeleteAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
    private String empNo;
 
	public String getEmpNo() {
		return empNo;
	}
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

    public String execute() throws Exception {
    	HRService hrService = new HRService();
    	hrService.deleteEmployee(new BigDecimal(empNo));
    	hrService.closeConn();
        return SUCCESS;
    }

}
