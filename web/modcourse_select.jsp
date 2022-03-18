<%-- 
    Document   : modcourse_select
    Created on : 01 19, 22, 12:17:44 PM
    Author     : Pierre Vincent C. Hernandez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modify Course</title>
    </head>
    <body>
        <h1>Modify Course</h1>
        <form name="modcourse_select" action="modcourse_load.jsp" method="POST">
            Enter course ID: <input type="text" name="courseID" id="courseID" required><br>
            <input type="submit" value="Load Course" name="modcourse_select" />
        </form>
        
        <br>
        <ul>
            <li><a href="coursemaintenance.jsp">Back to Course Maintenance</a></li>
        </ul>
    </body>
</html>
