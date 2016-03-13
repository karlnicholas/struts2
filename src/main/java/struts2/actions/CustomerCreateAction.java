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

import struts2.model.Customer;
import struts2.service.HRService;

@Action(value="customerCreate", results={@Result(name = ActionSupport.SUCCESS, location = "customers", type = "redirectAction")})
public class CustomerCreateAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
    private Customer customer;
    
    public String execute() throws Exception {
    	if ( customer == null ) return SUCCESS;

    	HRService hrService = new HRService();
    	hrService.createCustomer(customer);
    	hrService.closeConn();
        return SUCCESS;
    }
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
