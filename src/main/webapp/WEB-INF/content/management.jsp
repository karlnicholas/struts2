<!DOCTYPE html>
<%@taglib prefix="s" uri="/struts-tags"%>
<html lang="en">
<head>
<title>Management</title>
<s:head />
</head>
<body>
  <br />
  <br />
  <table>
    <thead>
      <tr>
        <th>User</th>
        <th>Created</th>
        <th>Quota</th>
        <th>Products</th>
        <th>Expires</th>
        <th>Admin</th>
        <th>&nbsp;</th>
      </tr>
    </thead>
    <tbody>
      <s:iterator value="users">
        <tr>
          <s:div>
            <td><s:property value="USER_NAME" /></td>
            <td><s:property value="CREATED_ON" /></td>
            <td><s:property value="QUOTA" /></td>
            <td><s:property value="PRODUCTS" /></td>
            <td><s:property value="EXPIRES_ON" /></td>
            <td><s:property value="ADMIN_USER" /></td>
            <td>
              <form action="userOrders">
                <input type="hidden" name="userId" value="<s:property value='USER_ID'/>" /><input type="submit" value="Orders" />
              </form>
            </td>
          </s:div>
        </tr>
      </s:iterator>
    </tbody>
  </table>
  <br />
  <s:if test="userOrders != null"> 
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
        <s:iterator value="userOrders.orders">
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
