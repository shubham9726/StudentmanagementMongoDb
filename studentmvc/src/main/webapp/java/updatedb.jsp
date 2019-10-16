<%--
  Created by IntelliJ IDEA.
  User: dz-gg-02
  Date: 24/5/19
  Time: 12:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--<%@ page import="java.io.*,java.util.*,java.sql.*"%>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html>
    <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>JSP Page</title>
        </head>
    <body>
        <sql:setDataSource var="dbsource" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost/studentjdbc" user="root" password="root"/>
        <sql:update dataSource="${dbsource}" var="count">
                UPDATE student2 SET name = ?, rollNo=?, address=?, mobile=?
                WHERE id='${param.id}'
                <sql:param value="${param.name}" />
                <sql:param value="${param.rollNo}" />
                <sql:param value="${param.address}" />
                <sql:param value="${param.mobile}" />
            </sql:update>
        <c:if test="${count>=1}">
                <font size="5" color='green'> Congratulations ! Data updated
                successfully.</font>
                  <a href="index.jsp">Go Home</a>         
            </c:if>
    </body>
</html>
