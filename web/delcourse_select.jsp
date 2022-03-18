<%-- 
    Document   : delcourse_select
    Created on : 01 19, 22, 6:44:43 PM
    Author     : Pierre Vincent C. Hernandez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Course</title>
    </head>
    <body>
        <h1>Delete Course</h1>
        <form name="delcourse_select" action="delcourse_save.jsp" method="POST">
            Enter course ID: <input type="text" name="courseID" id="courseID" required><br>
            <input type="submit" value="Delete Course" name="delcourse_select" />
        </form>
        
        <br>
        <ul>
            <li><a href="coursemaintenance.jsp">Back to Course Maintenance</a></li>
        </ul>
    </body>
</html>
