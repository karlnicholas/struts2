package struts2.dao;

import java.math.BigDecimal;
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
public class DemoOrdersDao {
	private Long ORDER_ID;		// NUMBER NOT NULL,
	private Long CUSTOMER_ID;		// NUMBER NOT NULL,
	private BigDecimal ORDER_TOTAL;		// NUMBER(8 , 2),
	private Date ORDER_TIMESTAMP;		// DATE,
	private Long USER_ID;			// NUMBER

}
