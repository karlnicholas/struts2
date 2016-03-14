package struts2.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/*
 * CREATE TABLE DEMO_ORDERS (
		ORDER_ID NUMBER NOT NULL,
		CUSTOMER_ID NUMBER NOT NULL,
		ORDER_TOTAL NUMBER(8 , 2),
		ORDER_TIMESTAMP DATE,
		USER_ID NUMBER
	);

 */
public abstract class DemoOrdersDao<T extends DaoBase<T>> extends DaoBase<T> {
	public static final String CUSTOMER_ID_COLUMN = "CUSTOMER_ID";
	public static final String USER_ID_COLUMN = "USER_ID";
	private Long ORDER_ID;			// NUMBER NOT NULL,
	private Long CUSTOMER_ID;		// NUMBER NOT NULL,
	private BigDecimal ORDER_TOTAL;	// NUMBER(8 , 2),
	private Date ORDER_TIMESTAMP;	// DATE,
	private Long USER_ID;			// NUMBER

	@Override
	public void decodeResultSet(ResultSet rset) throws SQLException {
		ORDER_ID = rset.getLong(1);				// NUMBER NOT NULL,
		CUSTOMER_ID = rset.getLong(2);			// NUMBER NOT NULL,
		ORDER_TOTAL = rset.getBigDecimal(3);	// NUMBER(8 , 2),
		ORDER_TIMESTAMP = rset.getDate(4);		// DATE,
		USER_ID = rset.getLong(5);				// NUMBER
	}

	@Override
	public String getTable() {
		return "DEMO_ORDERS";
	}
	@Override
	public String getPrimaryKey() {
		return "ORDER_ID";
	}

	public Long getORDER_ID() {
		return ORDER_ID;
	}
	public void setORDER_ID(Long oRDER_ID) {
		ORDER_ID = oRDER_ID;
	}
	public Long getCUSTOMER_ID() {
		return CUSTOMER_ID;
	}
	public void setCUSTOMER_ID(Long cUSTOMER_ID) {
		CUSTOMER_ID = cUSTOMER_ID;
	}
	public BigDecimal getORDER_TOTAL() {
		return ORDER_TOTAL;
	}
	public void setORDER_TOTAL(BigDecimal oRDER_TOTAL) {
		ORDER_TOTAL = oRDER_TOTAL;
	}
	public Date getORDER_TIMESTAMP() {
		return ORDER_TIMESTAMP;
	}
	public void setORDER_TIMESTAMP(Date oRDER_TIMESTAMP) {
		ORDER_TIMESTAMP = oRDER_TIMESTAMP;
	}
	public Long getUSER_ID() {
		return USER_ID;
	}
	public void setUSER_ID(Long uSER_ID) {
		USER_ID = uSER_ID;
	}
}
