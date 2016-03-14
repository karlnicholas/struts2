package struts2.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/*
 * CREATE TABLE DEMO_USERS (
		USER_ID NUMBER NOT NULL,
		USER_NAME VARCHAR2(100),
		PASSWORD VARCHAR2(4000),
		CREATED_ON DATE,
		QUOTA NUMBER,
		PRODUCTS CHAR(1),
		EXPIRES_ON DATE,
		ADMIN_USER CHAR(1)
	);

 */
public abstract class DemoUsersDao<T extends DaoBase<T>> extends DaoBase<T> {
	private Long USER_ID;			// NUMBER NOT NULL,
	private String USER_NAME;		// VARCHAR2(100),
	private String PASSWORD;		// VARCHAR2(4000),
	private Date CREATED_ON;		// DATE,
	private BigDecimal QUOTA;				// NUMBER,
	private Character PRODUCTS;		// CHAR(1),
	private Date EXPIRES_ON;		// DATE,
	private Character ADMIN_USER;	// CHAR(1)
	
	@Override
	public void decodeResultSet(ResultSet rset) throws SQLException {
		USER_ID = rset.getLong(1);			// NUMBER NOT NULL,
		USER_NAME = rset.getString(2);		// VARCHAR2(100),
		PASSWORD = rset.getString(3);		// VARCHAR2(4000),
		CREATED_ON = rset.getDate(4);		// DATE,
		QUOTA = rset.getBigDecimal(5);				// NUMBER,
		PRODUCTS = rset.getString(6).charAt(0);		// CHAR(1),
		EXPIRES_ON = rset.getDate(7);		// DATE,
		ADMIN_USER = rset.getString(8).charAt(0);	// CHAR(1)
	}
	@Override
	public String getTable() {
		return "DEMO_USERS";
	}
	@Override
	public String getPrimaryKey() {
		return "USER_ID";
	}
	public Long getUSER_ID() {
		return USER_ID;
	}
	public void setUSER_ID(Long uSER_ID) {
		USER_ID = uSER_ID;
	}
	public String getUSER_NAME() {
		return USER_NAME;
	}
	public void setUSER_NAME(String uSER_NAME) {
		USER_NAME = uSER_NAME;
	}
	public String getPASSWORD() {
		return PASSWORD;
	}
	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}
	public Date getCREATED_ON() {
		return CREATED_ON;
	}
	public void setCREATED_ON(Date cREATED_ON) {
		CREATED_ON = cREATED_ON;
	}
	public BigDecimal getQUOTA() {
		return QUOTA;
	}
	public void setQUOTA(BigDecimal qUOTA) {
		QUOTA = qUOTA;
	}
	public Character getPRODUCTS() {
		return PRODUCTS;
	}
	public void setPRODUCTS(Character pRODUCTS) {
		PRODUCTS = pRODUCTS;
	}
	public Date getEXPIRES_ON() {
		return EXPIRES_ON;
	}
	public void setEXPIRES_ON(Date eXPIRES_ON) {
		EXPIRES_ON = eXPIRES_ON;
	}
	public Character getADMIN_USER() {
		return ADMIN_USER;
	}
	public void setADMIN_USER(Character aDMIN_USER) {
		ADMIN_USER = aDMIN_USER;
	}

}
