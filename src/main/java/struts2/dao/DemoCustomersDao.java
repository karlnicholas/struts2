package struts2.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * CREATE TABLE DEMO_CUSTOMERS (
		CUSTOMER_ID NUMBER NOT NULL,
		CUST_FIRST_NAME VARCHAR2(20) NOT NULL,
		CUST_LAST_NAME VARCHAR2(20) NOT NULL,
		CUST_STREET_ADDRESS1 VARCHAR2(60),
		CUST_STREET_ADDRESS2 VARCHAR2(60),
		CUST_CITY VARCHAR2(30),
		CUST_STATE VARCHAR2(2),
		CUST_POSTAL_CODE VARCHAR2(10),
		PHONE_NUMBER1 VARCHAR2(25),
		PHONE_NUMBER2 VARCHAR2(25),
		CREDIT_LIMIT NUMBER(9 , 2),
		CUST_EMAIL VARCHAR2(30)
	);

 */
public abstract class DemoCustomersDao<T extends DaoBase<T>> extends DaoBase<T> {
	private Long CUSTOMER_ID;		// NUMBER NOT NULL,
	private String CUST_FIRST_NAME;	// VARCHAR2(20) NOT NULL,
	private String CUST_LAST_NAME;		// VARCHAR2(20) NOT NULL,
	private String CUST_STREET_ADDRESS1;	// VARCHAR2(60),
	private String CUST_STREET_ADDRESS2;	// VARCHAR2(60),
	private String CUST_CITY;			// VARCHAR2(30),
	private String CUST_STATE;			// VARCHAR2(2),
	private String CUST_POSTAL_CODE;	// VARCHAR2(10),
	private String PHONE_NUMBER1;		// VARCHAR2(25),
	private String PHONE_NUMBER2;		// VARCHAR2(25),
	private BigDecimal CREDIT_LIMIT;	// NUMBER(9 , 2),
	private String CUST_EMAIL;			// VARCHAR2(30)
	
	@Override
	public void decodeResultSet(ResultSet rset) throws SQLException {
		CUSTOMER_ID = rset.getLong(1);		// NUMBER NOT NULL,
		CUST_FIRST_NAME = rset.getString(2);	// VARCHAR2(20) NOT NULL,
		CUST_LAST_NAME = rset.getString(3);		// VARCHAR2(20) NOT NULL,
		CUST_STREET_ADDRESS1 = rset.getString(4);	// VARCHAR2(60),
		CUST_STREET_ADDRESS2 = rset.getString(5);	// VARCHAR2(60),
		CUST_CITY = rset.getString(6);			// VARCHAR2(30),
		CUST_STATE = rset.getString(7);			// VARCHAR2(2),
		CUST_POSTAL_CODE = rset.getString(8);	// VARCHAR2(10),
		PHONE_NUMBER1 = rset.getString(9);		// VARCHAR2(25),
		PHONE_NUMBER2 = rset.getString(10);		// VARCHAR2(25),
		CREDIT_LIMIT = rset.getBigDecimal(11);	// NUMBER(9 , 2),
		CUST_EMAIL = rset.getString(12);			// VARCHAR2(30)
	}

	@Override
	public String getTable() {
		return "DEMO_CUSTOMERS";
	}

	@Override
	public String getPrimaryKey() {
		return "CUSTOMER_ID";
	}

	public Long getCUSTOMER_ID() {
		return CUSTOMER_ID;
	}

	public void setCUSTOMER_ID(Long cUSTOMER_ID) {
		CUSTOMER_ID = cUSTOMER_ID;
	}

	public String getCUST_FIRST_NAME() {
		return CUST_FIRST_NAME;
	}

	public void setCUST_FIRST_NAME(String cUST_FIRST_NAME) {
		CUST_FIRST_NAME = cUST_FIRST_NAME;
	}

	public String getCUST_LAST_NAME() {
		return CUST_LAST_NAME;
	}

	public void setCUST_LAST_NAME(String cUST_LAST_NAME) {
		CUST_LAST_NAME = cUST_LAST_NAME;
	}

	public String getCUST_STREET_ADDRESS1() {
		return CUST_STREET_ADDRESS1;
	}

	public void setCUST_STREET_ADDRESS1(String cUST_STREET_ADDRESS1) {
		CUST_STREET_ADDRESS1 = cUST_STREET_ADDRESS1;
	}

	public String getCUST_STREET_ADDRESS2() {
		return CUST_STREET_ADDRESS2;
	}

	public void setCUST_STREET_ADDRESS2(String cUST_STREET_ADDRESS2) {
		CUST_STREET_ADDRESS2 = cUST_STREET_ADDRESS2;
	}

	public String getCUST_CITY() {
		return CUST_CITY;
	}

	public void setCUST_CITY(String cUST_CITY) {
		CUST_CITY = cUST_CITY;
	}

	public String getCUST_STATE() {
		return CUST_STATE;
	}

	public void setCUST_STATE(String cUST_STATE) {
		CUST_STATE = cUST_STATE;
	}

	public String getCUST_POSTAL_CODE() {
		return CUST_POSTAL_CODE;
	}

	public void setCUST_POSTAL_CODE(String cUST_POSTAL_CODE) {
		CUST_POSTAL_CODE = cUST_POSTAL_CODE;
	}

	public String getPHONE_NUMBER1() {
		return PHONE_NUMBER1;
	}

	public void setPHONE_NUMBER1(String pHONE_NUMBER1) {
		PHONE_NUMBER1 = pHONE_NUMBER1;
	}

	public String getPHONE_NUMBER2() {
		return PHONE_NUMBER2;
	}

	public void setPHONE_NUMBER2(String pHONE_NUMBER2) {
		PHONE_NUMBER2 = pHONE_NUMBER2;
	}

	public BigDecimal getCREDIT_LIMIT() {
		return CREDIT_LIMIT;
	}

	public void setCREDIT_LIMIT(BigDecimal cREDIT_LIMIT) {
		CREDIT_LIMIT = cREDIT_LIMIT;
	}

	public String getCUST_EMAIL() {
		return CUST_EMAIL;
	}

	public void setCUST_EMAIL(String cUST_EMAIL) {
		CUST_EMAIL = cUST_EMAIL;
	}

}
