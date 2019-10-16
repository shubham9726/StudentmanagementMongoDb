<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dz-gg-02
  Date: 31/10/18
  Time: 4:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Remove Student Details</title>
</head>
<body>
<center>
    <h2><u><b>Remove Student Details</b></u></h2>
    <br>
    <form method="get" action="<c:url value="/RemoveStudentServlet"/>">
        <table>
            <tr>
                <td>Enter Student id</td>
                <td><input type="text" placeholder="Student ID" name="studentid" pattern="[0-9]+"></td>
        </table>
        <br><br>
        <center></tr><input type="submit" value="Remove Student" name="removestudent" style="height:35px; width:250px">
        </center>
    </form>
    <br>
    <c:if test="${check == true}">
        <h4><b><c:out value="${errormsg}"/></b></h4>
    </c:if>

    <c:if test="${check == false}">
        <h4><b><c:out value="${errormsg}"/></b></h4>
    </c:if>
    <h4></h4>
    <br><br>
    <a href="../index.jsp"><input type="submit" value="Home" name="submit" style="height:35px; width:250px"></a>
</center>
</body>
</html>
