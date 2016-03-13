/*
 * Copyright 2006 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package struts2.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

import struts2.model.Employee;
import struts2.service.HRService;

@Action(value="employeeCreate", results={@Result(name = ActionSupport.SUCCESS, location = "employees", type = "redirectAction")})
public class EmployeeCreateAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
    private Employee employee;
    
    public String execute() throws Exception {
    	if ( employee == null ) return SUCCESS;
    	if ( employee != null ) {
    		if ( employee.empName == null || employee.empName.trim().isEmpty() ) return SUCCESS;
    		if ( employee.empNo == null ) return SUCCESS;
    	}

    	HRService hrService = new HRService();
    	hrService.createEmployee(employee);
    	hrService.closeConn();
        return SUCCESS;
    }
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
