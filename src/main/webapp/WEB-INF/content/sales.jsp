<!DOCTYPE html>
<%@taglib prefix="s" uri="/struts-tags"%>
<html lang="en">
<head>
<title>Customer</title>
<s:head />
</head>
<body>
  <s:div>Customer Form</s:div>
  <s:text name="customers.createForm" />
  <s:form action="customerCreate">
    <s:textfield key="customers.empName" name="customer.CUST_FIRST_NAME" />
    <s:textfield key="customers.empNo" name="customer.CUSTOMER_ID" />
    <s:submit value="Create" />
  </s:form>
  <br />
  <div>Customer List</div>
  <table>
    <thead>
      <tr>
        <th>Name</th>
        <th>Phone.</th>
        <th>&nbsp;</th>
        <th>&nbsp;</th>
      </tr>
    </thead>
    <tbody>
      <s:iterator value="customers">
        <tr>
          <s:div>
            <td><s:property value="CUST_FIRST_NAME" /> <s:property value="CUST_LAST_NAME" /></td>
            <td><s:property value="PHONE_NUMBER1" /></td>
            <td>
              <form action="customerOrders">
                <input type="hidden" name="customerId" value="<s:property value='CUSTOMER_ID'/>" /><input type="submit" value="Orders" />
              </form>
            </td>
            <td>
              <form action="customerDelete">
                <input type="hidden" name="customerId" value="<s:property value='CUSTOMER_ID'/>" /><input type="submit" value="Delete" />
              </form>
            </td>
          </s:div>
        </tr>
      </s:iterator>
    </tbody>
  </table>
  <br />
  <s:if test="customerOrders != null"> 
  <div>Orders for Customer</div>
    <table>
      <thead>
        <tr>
          <th>Customer</th>
          <th>Total</th>
          <th>Date</th>
          <th>User</th>
        </tr>
      </thead>
      <tbody>
        <s:iterator value="customerOrders.orders">
          <tr>
            <s:div>
              <td><s:property value="customer.CUST_FIRST_NAME" /> <s:property value="customer.CUST_LAST_NAME" /></td>
              <td><s:property value="ORDER_TOTAL" /></td>
              <td><s:property value="ORDER_TIMESTAMP" /></td>
              <td><s:property value="user.USER_NAME" /></td>
            </s:div>
          </tr>
        </s:iterator>
      </tbody>
    </table>
  </s:if>
</body>
</html>
