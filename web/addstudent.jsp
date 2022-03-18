<%-- 
    Document   : addstudent
    Created on : 01 19, 22, 9:18:29 PM
    Author     : Pierre Vincent C. Hernandez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Student</title>
    </head>
    <body>
        <h1>Add Student</h1>
        <form name="addstudent" action="addstudent_save.jsp" method="POST">
            Enter student ID: <input type="number" name="studentID" id="studentID" required><br>
            Enter complete name: <input type="text" name="fullName" id="fullName"><br>
            Enter degree ID: <input type="text" name="degreeID" id="degreeID"><br>
            <input type="submit" value="Add Student" name="addstudent" />
        </form>
        
        <br>
        <ul>
            <li><a href="studentmaintenance.jsp">Back to Student Maintenance</a></li>
        </ul>
    </body>
</html>
