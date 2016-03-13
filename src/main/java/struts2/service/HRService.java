package struts2.service;
/**
 * This demonstrates how to use interface ORAData and 
 * ORADataFactory for customized types.
 * 
 * 1. It shows how to create, store, retrieve objects of
 *    user-defined types.
 * 2. It needs jdk1.2 or later version and classes12.zip
 * 3. It drops, creates, and populates table EMPLOYEE_TABLE
 *    of user defined data type -- EMPLOYEE
 **/

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import oracle.jdbc.*;
import struts2.model.Employee;

public class HRService extends ServiceBase {

	public HRService() throws NamingException, SQLException {
		super();
	}

	/*
		// Create a Statement
		Statement stmt = conn.createStatement();
		try {
			stmt.execute("drop table EMPLOYEE_TABLE");
			stmt.execute("drop type EMPLOYEE");
		} catch (SQLException e) {
			// An error is raised if the table/type does not exist.
			// Just ignore it.
		}

		// Create and populate tables
		stmt.execute("CREATE TYPE EMPLOYEE AS " + "OBJECT(EmpName VARCHAR2(50),EmpNo INTEGER)");
		stmt.execute("CREATE TABLE EMPLOYEE_TABLE (ATTR1 EMPLOYEE)");
		stmt.execute("INSERT INTO EMPLOYEE_TABLE VALUES " + "(EMPLOYEE('Susan Smith', 123))");
		stmt.close();
		// Create a ORAData object
		Employee e = new Employee("George Jones", new BigDecimal("456"));

		// Insert the ORAData object
		PreparedStatement pstmt = conn.prepareStatement("insert into employee_table values (?)");

		pstmt.setObject(1, e, OracleTypes.STRUCT);
		pstmt.executeQuery();
		System.out.println("insert done");
		pstmt.close();
*/
	public void deleteEmployee(BigDecimal empNo) throws SQLException {
		PreparedStatement pstmt = conn.prepareStatement("delete from employee_table et where et.attr1.EmpNo = ?");

		pstmt.setObject(1, empNo);
		pstmt.executeQuery();
		pstmt.close();
	}

	public Employee createEmployee(Employee e) throws SQLException {
		// Insert the ORAData object
		PreparedStatement pstmt = conn.prepareStatement("insert into employee_table values (?)");

		pstmt.setObject(1, e, OracleTypes.STRUCT);
		pstmt.executeQuery();
//		System.out.println("insert done");
		pstmt.close();
		return e;
	}
	
	public List<Employee> listEmployees() throws SQLException {
		List<Employee> employees = new ArrayList<Employee>();
		// Select now
		Statement s = conn.createStatement();
		ResultSet rs = (ResultSet) s.executeQuery("select * from employee_table");
		OracleResultSet ors = (OracleResultSet)rs;

		while (ors.next()) {
			Employee ee = (Employee) ors.getORAData(1, Employee.getFactory());
			employees.add(ee);
		}
		ors.close();
		s.close();

		return employees;
	}
	
}
