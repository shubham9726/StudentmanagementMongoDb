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
<%--<c:if test="${ erorr == 1}">

</c:if>--%>
<center>
    <center><h1>Student Management System</h1></center>
    <table border=1>         
        <thead>             
        <tr>                 
            <th>Student ID</th>
            <th>Student Name</th>
            <th>Student Address</th>
            <th>Student Mobile No.</th>
            <th colspan=2>Action</th>
        </tr>
        </thead>
        <tbody>
        <form>
            <tr>

                <c:forEach items="${sessionScope.student}" var="student">
                <td><c:out value="${student.id}"/></td>
                <td><c:out value="${student.name}"/></td>
                <td><c:out value="${student.address}"/></td>
                <td><c:out value="${student.mobile}"/></td>
                <td><a href="<c:url value="/updatestudent/${student.id}"/>" role="button"></a></td>
                <td><a href="<c:url value="/remove{id}/${student.id}"/>" role="button"></a></td>
                    <%--<td><a href="StudentController?action=/update=<c:out value="${student.id}"/>">Update</a></td>
                    <td><a href="StudentController?action=/remove=<c:out value="${student.id}"/>">Delete</a></td>
                                    --%>
            </tr>
            </c:forEach>
        </form>

        </tbody>
    </table>
</center>
<%--    <p><a href="StudentController?action=/save">Add Student </a></p>--%>
<center><a href="<c:url value="/viewform/addstudent"/>"><input type="button" value="Add Student Details"> </a></center>
</body>
</html>