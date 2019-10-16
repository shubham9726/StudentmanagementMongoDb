<%--
  Created by IntelliJ IDEA.
  User: dz-gg-02
  Date: 28/5/19
  Time: 2:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Form- Student Managemant System</title>
</head>
<body>
<% String action = request.getParameter("action");
    System.out.println(action);
%>
<center>Student Details Update</center>
<center>
    <table border=1>
        <tr>
            <td><label>Student ID :</label></td>
            <td><input type="text" name="id" value="${student.id}"/></td>
        </tr>
        <tr>
            <td><label>Student Name :</label></td>
            <td><input type="text" name="name" value="${student.name}"/></td>
        </tr>
        <tr>
            <td><label>Student Address :</label></td>
            <td><input type="text" name="address" value="${student.address}"/></td>
        </tr>
        <tr>
            <td><label>Student Mobile :</label></td>
            <td><input type="text" name="mobile" value="${student.mobile}"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Update"/></td>
            <td><input type="reset" value="Reset"/></td>
        </tr>
    </table>
</center>
</body>
</html>