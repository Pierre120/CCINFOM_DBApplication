<%-- 
    Document   : addcourse_save
    Created on : 01 9, 22, 6:14:28 PM
    Author     : Pierre Vincent C. Hernandez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*, mod4enrollment.*" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Course Process</title>
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
        <h1>Add Course Process</h1>
        <jsp:useBean id="coursesBean" class="mod4enrollment.courses" scope="session" />
        <%
            coursesBean.courseID = request.getParameter("courseID");
            coursesBean.courseName = request.getParameter("courseName");
            coursesBean.department = request.getParameter("dept");
        %>
        Course Record to be Added:<br>
        Course ID   : <%=coursesBean.courseID%><br>
        Course Name : <%=coursesBean.courseName%><br>
        Department  : <%=coursesBean.department%><br>
        <br>
        <h5>Add course processing...</h5>
        
        <!-- Check if adding of record is a success -->
        <% if(coursesBean.addRecord() == 1) { %>
                <h4>[SUCCESS]</h4>
        <% } else {                           %>
                <h4>[FAILED]</h4>
                <p class='err-text'>Possible causes:
                <ul class='err-text'>
                    <li>A record with the same course ID already exists.</li>
                    <li>Some of the inputted values exceeded their maximum length.</li>
                </ul>
                </p>
        <% }                                  %>
            
        <br>
        <ul>
            <li class='li-nav'>
                <a href="addcourse.jsp">Add Another Course</a>
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
