<%-- 
    Document   : delcourse_save
    Created on : 01 19, 22, 6:45:07 PM
    Author     : Pierre Vincent C. Hernandez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*, mod4enrollment.*" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Course Process</title>
        <style>
            .err-text {
                font-size: 10pt;
            }
            
            .li-nav {
                display: block;
                padding: 10px 0px;
            }
        </style>
    </head>
    <body>
        <h1>Delete Course Process</h1>
        <jsp:useBean id="coursesBean" class="mod4enrollment.courses" scope="session" />
        <% coursesBean.courseID = request.getParameter("courseID"); %>
        Course Record To Be Deleted:<br>
        Course ID : <%=coursesBean.courseID%><br>
        <br>
        <h5>Delete course processing...</h5>
        
        <!-- Check if deleting of record is a success -->
        <% if(coursesBean.delRecord() == 1) { %>
                <h4>[SUCCESS]</h4>
        <% } else {                           %>
                <h4>[FAILED]</h4>
                <p class='err-text'>An error occurred</p>
        <% }                                  %>
        
        <br>
        <ul>
            <li class='li-nav'>
                <a href="delcourse_select.jsp">Select Another Course to Delete</a>
            </li>
            <li class='li-nav'>
                <a href="coursemaintenance.jsp">Back to Course Maintenance</a>
            </li>
            <li class='li-nav'>
                <a href="index.jsp">Back to Main Menu</a>
            </li>
        </ul>
    </body>
</html>
