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

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;

import com.opensymphony.xwork2.ActionSupport;

import struts2.model.Customer;
import struts2.service.HRService;

@Actions({
	@Action("customers") 
})
public class CustomersAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private List<Customer> customers;
    
    public void setCustomers(List<Customer> customers) { this.customers = customers; }
    public List<Customer> getCustomers() { return customers; }
    
    public String execute() throws Exception {
    	HRService hrService = new HRService();
    	customers = hrService.listCustomers();
    	hrService.closeConn();
        return SUCCESS;
    }
}
