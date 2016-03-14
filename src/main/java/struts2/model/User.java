package struts2.model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import struts2.dao.DemoUsersDao;

public class User extends DemoUsersDao<User> {
	// OneToMany(mappedBy="customer", fetch=FetchType.LAZY)
	List<Order> orders;

	@Override
	public void fetchEagerDependencies(Connection conn) throws SQLException {
	}

	@Override
	public User makeNewT() {
		return new User();
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

}
