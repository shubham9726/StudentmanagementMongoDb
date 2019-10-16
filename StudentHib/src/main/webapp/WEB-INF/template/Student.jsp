<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>--%>
<html>
<head>     
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Add new user</title>  
</head>
<body> 
<form method="POST" action='/save'>
               
    <center><h1><<<<---- Student Details ---->>>></h1></center>
    <center>
        <table border="1">

            <tr>
                <td><label>Student Name :</label></td>
                <td><input type="text" name="name"/></td>
            </tr>
            <tr>
                <td><label>Student Address :</label></td>
                <td><input type="text" name="address"/></td>
            </tr>
            <tr>
                <td><label>Student Mobile :</label></td>
                <td><input type="text" name="mobile"/></td>
            </tr>

        </table>
        <td>  <input type="submit" value="Submit"/></td>
        <td>  <input type="reset" value="Reset"/></td>
               
    </center>
     
</form>
</body>
</html>