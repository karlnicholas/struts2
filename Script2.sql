--<ScriptOptions statementTerminator=";"/>

CREATE TABLE DEMO_ORDER_ITEMS (
		ORDER_ITEM_ID NUMBER(3 , 0) NOT NULL,
		ORDER_ID NUMBER NOT NULL,
		PRODUCT_ID NUMBER NOT NULL,
		UNIT_PRICE NUMBER(8 , 2) NOT NULL,
		QUANTITY NUMBER(8 , 0) NOT NULL
	);

CREATE TABLE EMP (
		EMPNO NUMBER(4 , 0) NOT NULL,
		ENAME VARCHAR2(10),
		JOB VARCHAR2(9),
		MGR NUMBER(4 , 0),
		HIREDATE DATE,
		SAL NUMBER(7 , 2),
		COMM NUMBER(7 , 2),
		DEPTNO NUMBER(2 , 0)
	);

CREATE TABLE DEPT (
		DEPTNO NUMBER(2 , 0) NOT NULL,
		DNAME VARCHAR2(14),
		LOC VARCHAR2(13)
	);

CREATE TABLE DEMO_CUSTOMERS (
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

CREATE TABLE DEMO_ORDERS (
		ORDER_ID NUMBER NOT NULL,
		CUSTOMER_ID NUMBER NOT NULL,
		ORDER_TOTAL NUMBER(8 , 2),
		ORDER_TIMESTAMP DATE,
		USER_ID NUMBER
	);

CREATE TABLE DEMO_STATES (
		ST VARCHAR2(30),
		STATE_NAME VARCHAR2(30)
	);

CREATE TABLE DEMO_PRODUCT_INFO (
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

CREATE TABLE DEMO_USERS (
		USER_ID NUMBER NOT NULL,
		USER_NAME VARCHAR2(100),
		PASSWORD VARCHAR2(4000),
		CREATED_ON DATE,
		QUOTA NUMBER,
		PRODUCTS CHAR(1),
		EXPIRES_ON DATE,
		ADMIN_USER CHAR(1)
	);

CREATE UNIQUE INDEX DEMO_ORDER_ITEMS_PK ON DEMO_ORDER_ITEMS (ORDER_ITEM_ID ASC);

CREATE INDEX DEMO_ORD_CUSTOMER_IX ON DEMO_ORDERS (CUSTOMER_ID ASC);

CREATE UNIQUE INDEX SYS_C007091 ON DEPT (DEPTNO ASC);

CREATE UNIQUE INDEX DEMO_ORDER_PK ON DEMO_ORDERS (ORDER_ID ASC);

CREATE UNIQUE INDEX DEMO_USERS_PK ON DEMO_USERS (USER_ID ASC);

CREATE UNIQUE INDEX SYS_C007093 ON EMP (EMPNO ASC);

CREATE UNIQUE INDEX DEMO_PRODUCT_INFO_PK ON DEMO_PRODUCT_INFO (PRODUCT_ID ASC);

CREATE INDEX DEMO_CUST_NAME_IX ON DEMO_CUSTOMERS (CUST_LAST_NAME ASC, CUST_FIRST_NAME ASC);

CREATE UNIQUE INDEX DEMO_CUSTOMERS_PK ON DEMO_CUSTOMERS (CUSTOMER_ID ASC);

ALTER TABLE EMP ADD CONSTRAINT SYS_C007093 PRIMARY KEY (EMPNO);

ALTER TABLE DEMO_ORDER_ITEMS ADD CONSTRAINT DEMO_ORDER_ITEMS_PK PRIMARY KEY (ORDER_ITEM_ID);

ALTER TABLE DEPT ADD CONSTRAINT SYS_C007091 PRIMARY KEY (DEPTNO);

ALTER TABLE DEMO_CUSTOMERS ADD CONSTRAINT DEMO_CUSTOMERS_PK PRIMARY KEY (CUSTOMER_ID);

ALTER TABLE DEMO_ORDERS ADD CONSTRAINT DEMO_ORDER_PK PRIMARY KEY (ORDER_ID);

ALTER TABLE DEMO_USERS ADD CONSTRAINT DEMO_USERS_PK PRIMARY KEY (USER_ID);

ALTER TABLE DEMO_PRODUCT_INFO ADD CONSTRAINT DEMO_PRODUCT_INFO_PK PRIMARY KEY (PRODUCT_ID);

ALTER TABLE DEMO_ORDER_ITEMS ADD CONSTRAINT DEMO_ORDER_ITEMS_PRODUCT_ID_FK FOREIGN KEY (PRODUCT_ID)
	REFERENCES DEMO_PRODUCT_INFO (PRODUCT_ID)
	ON DELETE CASCADE
	ON UPDATE CASCADE;

ALTER TABLE DEMO_ORDER_ITEMS ADD CONSTRAINT DEMO_ORDER_ITEMS_FK FOREIGN KEY (ORDER_ID)
	REFERENCES DEMO_ORDERS (ORDER_ID)
	ON DELETE CASCADE
	ON UPDATE CASCADE;

ALTER TABLE DEMO_ORDERS ADD CONSTRAINT DEMO_ORDERS_USER_ID_FK FOREIGN KEY (USER_ID)
	REFERENCES DEMO_USERS (USER_ID)
	ON DELETE RESTRICT
	ON UPDATE CASCADE;

ALTER TABLE EMP ADD CONSTRAINT SYS_C007095 FOREIGN KEY (DEPTNO)
	REFERENCES DEPT (DEPTNO)
	ON DELETE RESTRICT
	ON UPDATE CASCADE;

ALTER TABLE EMP ADD CONSTRAINT SYS_C007094 FOREIGN KEY (MGR)
	REFERENCES EMP (EMPNO)
	ON DELETE RESTRICT
	ON UPDATE CASCADE;

ALTER TABLE DEMO_ORDERS ADD CONSTRAINT DEMO_ORDERS_CUSTOMER_ID_FK FOREIGN KEY (CUSTOMER_ID)
	REFERENCES DEMO_CUSTOMERS (CUSTOMER_ID)
	ON DELETE RESTRICT
	ON UPDATE CASCADE;

