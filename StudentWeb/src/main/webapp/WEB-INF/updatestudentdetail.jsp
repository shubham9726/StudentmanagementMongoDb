<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dz-gg-02
  Date: 2/11/18
  Time: 4:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Student Details</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<center>
    <h2><u><b>Update Student Details</b></u></h2>
    <br>
    <div class="container">
        <table class="table table-hover">
        <tbody>
        <tr>
            <td>Previous Student Id</td>
            <td><b><c:out value="${studentid}"/></b></td>
        </tr>

        <tr>
            <td>Previous Student Name</td>
            <td><b><c:out value="${studentname}"/></b></td>
        </tr>

        <tr>
            <td>Enter Student age</td>
            <td><b><c:out value="${studentage}"/></b></td>
        </tr>
        </tbody>
    </table>
    </div>
    <br>
    <div class="container">

    <form method="get" action="<c:url value="/UpdateStudentDetailServlet"/>">
        <table class="table table-hover">
            <tbody>
            <tr>
                <td>Enter Student Name To Update</td>
                <td><input type="text" name="studentname" placeholder="updated student name" pattern="[a-zA-z\s]+"
                           required autofocus></td>
            </tr>

            <tr>
                <td>Enter Student age To Update</td>
                <td><input type="text" name="studentage" placeholder="updated student age" MAXLENGTH="3"
                           pattern="[0-9]+" required></td>
            </tr>
            </tbody>
        </table>
        <input type="hidden" name="studentid" value="<c:out value="${studentid}" />">
        <br><br>
        <center></tr><input type="submit" value="Update Student" name="updatestudent" style="height:35px; width:250px">
        </center>
    </form>
    </div>
    <br><br>
    <a href="../index.jsp"><input type="submit" value="Home" name="submit" style="height:35px; width:250px"></a>
</center>
</body>
</html>
