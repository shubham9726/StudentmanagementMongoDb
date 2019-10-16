<%--
  Created by IntelliJ IDEA.
  User: dz-gg-02
  Date: 27/5/19
  Time: 1:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>CRUD OPERATION- Display </title>
</head>
<body>
<c:if test="${ erorr == 1}">

</c:if>
<center>
    <center><h1>Student Management System</h1></center>
    <table border=1>         
        <thead>             
        <tr>                 
            <th>Student Name</th>
            <th>Student Roll Number</th>
            <th>Student Address</th>
            <th>Student Mobile No.</th>
            <th colspan=2>Action</th>
        </tr>
        </thead>
        <tbody>
        <form>
                        <c:forEach items="${requestScope.student12}" var="student">
                            <tr>
                                <td><c:out value="${student.name}"/></td>
            <td><c:out value="${student.rollNo}"/></td>
                                <td><c:out value="${student.address}"/></td>
            <td><c:out value="${student.mobile}"/></td>
            <td><a href="UserController?action=edit&rollNo=<c:out value="${student.rollNo}"/>">Update</a></td>
                                <td><a href="UserController?action=delete&rollNo=<c:out value="${student.rollNo}"/>">Delete</a></td>
                            </tr>
                        </c:forEach>
        </form>
        </tbody>

</center>
</table>
    <p><a href="UserController?action=Insert">Add Student </a></p>
</body>
</html>
