package struts2.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ServiceBase {
	protected Connection conn = null;
	public ServiceBase() throws NamingException, SQLException {
		conn = null;
    	Context initContext = new InitialContext();
    	Context envContext  = (Context)initContext.lookup("java:/comp/env");
    	DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
    	conn =  ds.getConnection(); 
		 
//    	DatabaseMetaData meta = conn.getMetaData(); // gets driver info:
//    	result = "JDBC driver version is " + meta.getDriverVersion();
		
	}
	public void closeConn() throws SQLException {
		if (conn != null) {
			conn.close();
		}
	}
}
