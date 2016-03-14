<!DOCTYPE html>
<%@taglib prefix="s" uri="/struts-tags"%>
<html lang="en">
<head>
<title>Customer</title>
<s:head />
</head>
<body>
  <br />
  <table>
    <thead>
      <tr>
        <th>CUSTOMER</th>
        <th>ORDER_TOTAL</th>
        <th>ORDER_TIMESTAMP</th>
        <th>USER_ID</th>
        <th>&nbsp;</th>
      </tr>
    </thead>
    <tbody>
      <s:iterator value="orders">
        <tr>
          <s:div>
            <td><s:property value="customer.CUST_FIRST_NAME" /> <s:property value="customer.CUST_LAST_NAME" /></td>
            <td><s:property value="ORDER_TOTAL" /></td>
            <td><s:property value="ORDER_TIMESTAMP" /></td>
            <td><s:property value="user.USER_NAME" /></td>
            <td>
              <form action="customerDelete">
                <input type="hidden" name="ORDER_ID" value="<s:property value='ORDER_IDNAME'/>" /><input type="submit" value="Delete" />
              </form>
            </td>
          </s:div>
        </tr>
      </s:iterator>
    </tbody>
  </table>
</body>
</html>
