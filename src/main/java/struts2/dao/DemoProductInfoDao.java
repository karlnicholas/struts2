package struts2.dao;

import java.math.BigDecimal;
import java.util.Date;

/*
 * CREATE TABLE DEMO_PRODUCT_INFO (
		PRODUCT_ID NUMBER NOT NULL,
		PRODUCT_NAME VARCHAR2(50),
		PRODUCT_DESCRIPTION VARCHAR2(2000),
		CATEGORY VARCHAR2(30),
		PRODUCT_AVAIL VARCHAR2(1),
		LIST_PRICE NUMBER(8 , 2),
		PRODUCT_IMAGE BLOB,
		MIMETYPE VARCHAR2(255),
		FILENAME VARCHAR2(400),
		IMAGE_LAST_UPDATE DATE
	);

 */
public class DemoProductInfoDao {
	private Long PRODUCT_ID;		// NUMBER NOT NULL,
	private String PRODUCT_NAME;	// VARCHAR2(50),
	private String PRODUCT_DESCRIPTION;	// VARCHAR2(2000),
	private String CATEGORY;		// VARCHAR2(30),
	private String PRODUCT_AVAIL;		// VARCHAR2(1),
	private BigDecimal LIST_PRICE;		// NUMBER(8 , 2),
	private String PRODUCT_IMAGE;		// BLOB,
	private String MIMETYPE;		// VARCHAR2(255),
	private String FILENAME;		// VARCHAR2(400),
	private Date IMAGE_LAST_UPDATE;		// DATE
}
