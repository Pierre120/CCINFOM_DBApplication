<%-- 
    Document   : studentmaintenance
    Created on : 01 8, 22, 1:02:49 PM
    Author     : Pierre Vincent C. Hernandez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Maintenance</title>
        <style>
            .li-nav {
                display: block;
                padding: 10px 0px;
            }
        </style>
    </head>
    <body>
        <h1>Student Maintenance</h1>
        <ul>
            <li class='li-nav'>
                <a href="addstudent.jsp">Add a Student</a>
            </li>
            <li class='li-nav'>
                <a href="modstudent_select.jsp">Modify a Student</a>
            </li>
            <li class='li-nav'>
                <a href="delstudent_select.jsp">Delete a Student</a>
            </li>
            <li class='li-nav'>
                <a href="record_management.jsp">Back to Record Management</a>
            </li>
        </ul>
    </body>
</html>
