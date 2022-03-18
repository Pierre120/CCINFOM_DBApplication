<%-- 
    Document   : modcourse_save
    Created on : 01 19, 22, 12:18:23 PM
    Author     : Pierre Vincent C. Hernandez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*, mod4enrollment.*" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modify Course Process</title>
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
        <h1>Modify Course Process</h1>
        <jsp:useBean id="coursesBean" class="mod4enrollment.courses" scope="session" />
        <%
            coursesBean.courseName = request.getParameter("courseName");
            coursesBean.department = request.getParameter("dept");
        %>
        Modified Course Record Details:<br>
        Course ID   : <%=coursesBean.courseID%><br>
        Course Name : <%=coursesBean.courseName%><br>
        Department  : <%=coursesBean.department%><br>
        <br>
        <h5>Modify course processing...</h5>
        
        <!-- Check if modifying/updating of record is a success -->
        <% if(coursesBean.modRecord() == 1) { %>
                <h4>[SUCCESS]</h4>
        <% } else {                           %>
                <h4>[FAILED]</h4>
                <p class='err-text'>Possible causes:
                <ul class='err-text'>
                    <li>Some of the inputted values exceeded their maximum length.</li>
                </ul>
                </p>
        <% }                                  %>
        
        <br>
        <ul>
            <li class='li-nav'>
                <a href="modcourse_select.jsp">Select Another Course to Modify</a>
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
