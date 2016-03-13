package struts2.dao;

import java.math.BigDecimal;

/*
 * CREATE TABLE DEMO_ORDER_ITEMS (
		ORDER_ITEM_ID NUMBER(3 , 0) NOT NULL,
		ORDER_ID NUMBER NOT NULL,
		PRODUCT_ID NUMBER NOT NULL,
		UNIT_PRICE NUMBER(8 , 2) NOT NULL,
		QUANTITY NUMBER(8 , 0) NOT NULL
	);

 */
public class DemoOrderItemsDao {
	private Long ORDER_ITEM_ID;	// NUMBER(3 , 0) NOT NULL,
	private Long ORDER_ID;		// NUMBER NOT NULL,
	private Long PRODUCT_ID;		// NUMBER NOT NULL,
	private BigDecimal UNIT_PRICE;		// NUMBER(8 , 2) NOT NULL,
	private BigDecimal QUANTITY;		// NUMBER(8 , 0) NOT NULL

}
