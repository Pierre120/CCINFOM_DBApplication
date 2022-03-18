<%-- 
    Document   : modstudent_select
    Created on : 01 19, 22, 10:22:07 PM
    Author     : Pierre Vincent C. Hernandez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modify Student</title>
    </head>
    <body>
        <h1>Modify Student</h1>
        <form name="modstudent_select" action="modstudent_load.jsp" method="POST">
            Enter student ID: <input type="number" name="studentID" id="studentID" required><br>
            <input type="submit" value="Load Student" name="modstudent_select" />
        </form>
        
        <br>
        <ul>
            <li><a href="studentmaintenance.jsp">Back to Student Maintenance</a></li>
        </ul>
    </body>
</html>
