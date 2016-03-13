<!DOCTYPE html>
<%@taglib prefix="s" uri="/struts-tags"%>
<html lang="en">
<head>
<title>Employee</title>
<s:head />
</head>
<body>
  <s:div>Employee Form</s:div>
  <s:text name="employees.createForm" />
  <s:form action="employeeCreate">
    <s:textfield key="employees.empName" name="employee.empName" />
    <s:textfield key="employees.empNo" name="employee.empNo" />
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
      <s:iterator value="employees">
        <tr>
          <s:div>
            <td><s:property value="empName" /></td>
            <td><s:property value="empNo" /></td>
            <td>
              <form action="employeeDelete">
                <input type="hidden" name="empNo" value="<s:property value='empNo'/>" /><input type="submit" value="Delete" />
              </form>
            </td>
          </s:div>
        </tr>
      </s:iterator>
    </tbody>
  </table>
</body>
</html>
