<%--
  Created by IntelliJ IDEA.
  User: dz-gg-02
  Date: 23/5/19
  Time: 12:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Show All Users</title>
</head>
<body>
    <c:if test="${ erorr == 1}">
    <h2><b>sdkhfdsfjkd</b></h2>
</c:if>
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
                    <c:forEach items="${requestScope.student}" var="user">
                        <%--<c:forEach items="${student}" var="user">--%>
                        <tr>
                            <td><c:out value="${user.name}"/></td>
                            <td><c:out value="${user.rollNo}"/></td>
                            <td><c:out value="${user.address}"/></td>
                            <td><c:out value="${user.mobile}"/></td>
                            
                            <td><a href="UserController?action=edit&rollNo=<c:out value="${user.rollNo}"/>">Update</a></td>
                            <td><a href="UserController?action=delete&rollNo=<c:out value="${user.rollNo}"/>">Delete</a></td>
                        </tr>
                    </c:forEach>
    </form>
            
    </tbody>

        
</table>
    <p><a href="/InsertServlet?action=insert">Add Student </a></p>
<%--<a href="/UserController?action=insert">Add Student </a>--%>
</body>
</html>