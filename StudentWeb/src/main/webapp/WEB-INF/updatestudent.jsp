<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dz-gg-02
  Date: 31/10/18
  Time: 4:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Student Details</title>
</head>
<body>
<center>
    <h2><u><b>Update Student Details</b></u></h2>
    <br>
    <form method="get" action="<c:url value="/UpdatetStudentServlet"/>">
        <table>
            <tr>
                <td>Enter Student id</td>
                <td><input type="text" placeholder="Student ID" name="studentid" pattern="[0-9]+"></td>
        </table>
        <br><br>
        <center></tr><input type="submit" value="Search Student" name="updatestudent" style="height:35px; width:250px">
        </center>

    </form>


    <c:if test="${check==true}">
        <h3><b><u><c:out value="${msg}"/></u></b></h3>
        <h3><b>Updated Student Name : <c:out value="${updatedstudentname}"/></b></h3>
        <h3><b>Updated Student Age : <c:out value="${updatedstudentage}"/></b></h3>

    </c:if>


    <br><br>
    <a href="../index.jsp"><input type="submit" value="Home" name="submit" style="height:35px; width:250px"></a>
</center>
</body>
</html>
