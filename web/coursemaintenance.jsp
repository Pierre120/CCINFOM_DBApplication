<%-- 
    Document   : coursemaintenance
    Created on : 01 8, 22, 1:04:27 PM
    Author     : Pierre Vincent C. Hernandez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Course Maintenance</title>
        <style>
            .li-nav {
                display: block;
                padding: 10px 0px;
            }
        </style>
    </head>
    <body>
        <h1>Course Maintenance</h1>
        <ul>
            <li class='li-nav'>
                <a href="addcourse.jsp">Add a Course</a>
            </li>
            <li class='li-nav'>
                <a href="modcourse_select.jsp">Modify a Course</a>
            </li>
            <li class='li-nav'>
                <a href="delcourse_select.jsp">Delete a Course</a>
            </li>
            <li class='li-nav'>
                <a href="record_management.jsp">Back to Record Management</a>
            </li>
        </ul>
    </body>
</html>
