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
  <table>
    <thead>
      <tr>
        <th>Name</th>
        <th>Emp. No.</th>
        <th>&nbsp;</th>
      </tr>
    </thead>
    <tbody>
      <s:iterator value="customers">
        <tr>
          <s:div>
            <td><s:property value="CUST_FIRST_NAME" /></td>
            <td><s:property value="CUSTOMER_ID" /></td>
            <td>
              <form action="customerDelete">
                <input type="hidden" name="CUST_FIRST_NAME" value="<s:property value='CUST_FIRST_NAME'/>" /><input type="submit" value="Delete" />
              </form>
            </td>
          </s:div>
        </tr>
      </s:iterator>
    </tbody>
  </table>
</body>
</html>
