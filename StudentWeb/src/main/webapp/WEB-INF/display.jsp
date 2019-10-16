<%@ page language="java" contentType="text/html; charset=US-ASCII"
         pageEncoding="US-ASCII" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dz-gg-02
  Date: 31/10/18
  Time: 4:40 PM
  To change this template use File | Settings | File Templates.
--%>

<html>
<head>
    <title>Display Student details</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<center><b><u><h3>Student details</h3></u></b>
    <c:if test="${quantity == 1}">

        <div class="container">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>Student ID</th>
                    <th>Student Name</th>
                    <th>Student Age</th>
                </tr>
                </thead>
                <tbody>
                <form>
                    <c:forEach items="${requestScope.arraylist}" var="student">
                        <tr>
                            <td contenteditable="true" id="id"><c:out value="${student.id}"/></td>
                            <td contenteditable="true" id="name"><c:out value="${student.name}"/></td>
                            <td contenteditable="true" id="age"><c:out value="${student.age}"/></td>
                            <td>
                                <a href="<c:url value="RemoveStudentServlet?studentid="/><c:out value="${student.id}"/> ">Delete</a>
                            </td>
                     <td>
                                <form method="get" action="<c:url value="/MenuServlet"/>">
                                    <a href="<c:url value="/UpdatetStudentServlet?studentid="/><c:out value="${student.id}"/> ">Update</a>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>

                </form>
                </tbody>
            </table>
        </div>
        <c:if test="${check == true}">
            <h2><b><c:out value="${errormsg}"/></b></h2>
        </c:if>

        <c:if test="${check == false}">
            <h2><b><c:out value="${errormsg}"/></b></h2>
        </c:if>
    </c:if>

    <c:if test="${quantity == 0}">
        <center><h3><b><u><c:out value="${errormsg}"/></u></b></h3>
            <form method="get" action="<c:url value="/MenuServlet"/>">
                <table>
                    <tr>
                        <td><input type="submit" value="Add Student" name="add_student"
                                   style="height:35px; width:250px"></td>
                    </tr>
                </table>
            </form>
        </center>
    </c:if>

    <br><br>

    <form method="get" action="<c:url value="/MenuServlet"/>">
        <table>
            <tr>
                <td><input type="submit" value="Add Student" name="add_student"
                           style="height:35px; width:250px"></td>
            </tr>
        </table>
    </form>
</center>
</body>
</html>
