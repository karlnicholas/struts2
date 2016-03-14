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

import java.sql.*;
import java.util.List;

import javax.naming.NamingException;

import struts2.dao.ListForType;
import struts2.model.Order;
import struts2.model.User;

public class ManagementService extends ServiceBase {

	public ManagementService() throws NamingException, SQLException {
		super();
	}
	
	public List<User> listUsers() throws SQLException {
		return new User().list(conn);
	}
	
	public List<Order> listOrdersForUser(final Long userId) throws SQLException {
		ListForType userType = new ListForType() {
			@Override
			public Long getWhereId() {
				return userId;
			}
			@Override
			public String getWhereColumn() {
				return Order.USER_ID_COLUMN;
			}
		};
		return new Order().listForDaoType(conn, userType);
	}
}
