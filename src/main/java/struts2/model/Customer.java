package struts2.model;

import struts2.dao.DemoCustomersDao;

/**
 * filename: Customer.java
 *
 * This demonstrates how to derive a user-defined type
 * based on ORAData and ORADataFactory.
 * This class is used by ORADataExample.java
 *
 * Please use jdk1.2 or later version, classes12.zip
 **/

public class Customer extends DemoCustomersDao<Customer> {

	@Override
	public Customer makeNewT() {
		return new Customer();
	}

}
