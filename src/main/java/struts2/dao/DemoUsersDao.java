package struts2.dao;

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
public class DemoUsersDao {
	private Long USER_ID;			// NUMBER NOT NULL,
	private String USER_NAME;		// VARCHAR2(100),
	private String PASSWORD;		// VARCHAR2(4000),
	private Date CREATED_ON;		// DATE,
	private Long QUOTA;				// NUMBER,
	private Character PRODUCTS;		// CHAR(1),
	private Date EXPIRES_ON;		// DATE,
	private Character ADMIN_USER;	// CHAR(1)


}
