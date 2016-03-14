package struts2.model;

import struts2.dao.DemoOrdersDao;

import java.sql.Connection;
import java.sql.SQLException;

public class Order extends DemoOrdersDao<Order>  {
	// ManyToOne(fetch=FetchType.EAGER)
	private Customer customer;
	// ManyToOne(fetch=FetchType.EAGER)
	private User user;

	public void fetchEagerDependencies(Connection conn) throws SQLException {
		customer = new Customer().findById(conn, getCUSTOMER_ID());
		user = new User().findById(conn, getUSER_ID());
	}

	public Order makeNewT() {
		return new Order();
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
