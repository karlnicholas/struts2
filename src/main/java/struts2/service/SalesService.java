package struts2.service;
/**
 * This demonstrates how to use interface ORAData and 
 * ORADataFactory for customized types.
 * 
 * 1. It shows how to create, store, retrieve objects of
 *    user-defined types.
 * 2. It needs jdk1.2 or later version and classes12.zip
 * 3. It drops, creates, and populates table CUSTOMER_TABLE
 *    of user defined data type -- CUSTOMER
 **/

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import oracle.jdbc.*;
import struts2.model.Customer;

public class SalesService extends ServiceBase {

	public SalesService() throws NamingException, SQLException {
		super();
	}

	public void deleteCustomer(BigDecimal empNo) throws SQLException {
	}

	public Customer createCustomer(Customer e) throws SQLException {
		return e;
	}
	
	public List<Customer> listCustomers() throws SQLException, NamingException {
		return new Customer().list(conn);
	}
	
}
