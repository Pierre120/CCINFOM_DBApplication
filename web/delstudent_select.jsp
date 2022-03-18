<%-- 
    Document   : delstudent_select
    Created on : 01 19, 22, 10:54:32 PM
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
        <form name="delstudent_select" action="delstudent_save.jsp" method="POST">
            Enter student ID: <input type="number" name="studentID" id="studentID" required><br>
            <input type="submit" value="Delete Student" name="delstudent_select" />
        </form>
        
        <br>
        <ul>
            <li><a href="studentmaintenance.jsp">Back to Student Maintenance</a></li>
        </ul>
    </body>
</html>
