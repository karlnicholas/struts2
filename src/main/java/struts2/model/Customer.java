package struts2.model;

import java.sql.Connection;
import java.sql.SQLException;

import struts2.dao.DemoCustomersDao;

public class Customer extends DemoCustomersDao<Customer> {

	@Override
	public Customer makeNewT() {
		return new Customer();
	}

	@Override
	public void fetchEagerDependencies(Connection conn) throws SQLException {
	}

}
