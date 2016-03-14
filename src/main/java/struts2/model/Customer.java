package struts2.model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import struts2.dao.DemoCustomersDao;

public class Customer extends DemoCustomersDao<Customer> {
	// OneToMany(mappedBy="customer", fetch=FetchType.LAZY)
	List<Order> orders;

	@Override
	public Customer makeNewT() {
		return new Customer();
	}

	@Override
	public void fetchEagerDependencies(Connection conn) throws SQLException {
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

}
