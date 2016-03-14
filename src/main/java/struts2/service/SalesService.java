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

import struts2.dao.ListForType;
import struts2.model.Customer;
import struts2.model.Order;

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

	public Customer listOrdersForCustomer(final Long customerId) throws InstantiationException, IllegalAccessException, SQLException {
		ListForType<Customer, Order> listForType = new ListForType<Customer, Order>() {
			@Override
			public Long getParentId() {
				return customerId;
			}

			@Override
			public String getJoinColumn() {
				return Order.CUSTOMER_ID_COLUMN;
			}

			@Override
			public List<Order> getCollection(Customer parent) {
				if ( parent.getOrders() == null ) parent.setOrders(new ArrayList<Order>());
				return parent.getOrders();
			}
		};
		return listForType.listForDaoType(conn, Customer.class, Order.class);
	}
	
}
