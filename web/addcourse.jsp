<%-- 
    Document   : addcourse
    Created on : 01 9, 22, 5:59:49 PM
    Author     : Pierre Vincent C. Hernandez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Course</title>
    </head>
    <body>
        <h1>Add Course</h1>
        <form name="addcourse" action="addcourse_save.jsp" method="POST">
            Enter course ID: <input type="text" name="courseID" id="courseID" required><br>
            Enter course name: <input type="text" name="courseName" id="courseName"><br>
            Enter course department: <input type="text" name="dept" id="dept"><br>
            <input type="submit" value="Add Course" name="addcourse" />
        </form>
        
        <br>
        <ul>
            <li><a href="coursemaintenance.jsp">Back to Course Maintenance</a></li>
        </ul>
    </body>
</html>
