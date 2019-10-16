<%--
  Cr1eated by IntelliJ IDEA.
  User: dz-gg-02
  Date: 23/5/19
  Time: 10:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>     
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Add new user</title>  
</head>
<body> 
<form method="POST" action='UserController' name="frmAddUser">
                <% String action = request.getParameter("action");
    System.out.println(action);%>
    <center><h1><<<<---- Student Details ---->>>></h1></center>
    <center>
        <table border="1">
            <tr>
                <td><label>Student Name :-</label></td>
                <td><input type="text" name="name" value="<c:out value="${user.name}" />"/><br></td>
            </tr>
            <tr>
                <td><label>Student Roll Number :-</label></td>
                <td><input type="text" name="rollNo" value="<c:out value="${user.rollNo}" />"/><br></td>
            </tr>
            <tr>
                <td><label>Student Address :-</label></td>
                <td><input type="text" name="address" value="<c:out value="${user.address}" />"/><br></td>
            </tr>
            <tr>
                <td><label>Student Mobile number :-</label></td>
                <td><input type="text" name="mobile" value="<c:out value="${user.mobile}" />"/><br></td>
            </tr>
        </table>
        <td>  <input type="submit" value="Submit"/></td>
        <td>  <input type="reset" value="Reset"/></td>
               
    </center>
     
</form>
</body>
</html>