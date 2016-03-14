package struts2.model;

import java.sql.Connection;
import java.sql.SQLException;

import struts2.dao.DemoUsersDao;

public class User extends DemoUsersDao<User> {

	@Override
	public void fetchEagerDependencies(Connection conn) throws SQLException {
	}

	@Override
	public User makeNewT() {
		return new User();
	}

}
