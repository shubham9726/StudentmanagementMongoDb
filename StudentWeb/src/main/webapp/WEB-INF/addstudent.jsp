<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dz-gg-02
  Date: 31/10/18
  Time: 2:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ADD Student</title>
</head>
<body>
<center>
    <h2><u><b>Add Student</b></u></h2>
    <br>
    <form method="get" action="<c:url value="AddStudentServlet"/>">
        <table>
            <tr>
                <td>Enter Student Name</td>
                <td><input type="text" name="studentname" placeholder="Student Name" pattern="[a-zA-z\s]+" required
                           autofocus></td>
            </tr>
            <tr>
                <td>Enter Student Age</td>
                <td><input type="text" name="studentage" maxlength="3" placeholder="Student Age" pattern="[0-9]+"
                           required></td>
            </tr>
        </table>
        <br>
        <center><input type="submit" value="Submit" name="submit" style="height:35px; width:250px"></center>
    </form>
    <br><br>
    <a href="../index.jsp"><input type="submit" value="Home" name="submit" style="height:35px; width:250px"></a>
</center>
</body>
</html>