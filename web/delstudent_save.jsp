<%-- 
    Document   : delstudent_save
    Created on : 01 19, 22, 10:55:02 PM
    Author     : Pierre Vincent C. Hernandez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*, mod4enrollment.*" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Student Process</title>
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
        <h1>Delete Student Process</h1>
        <jsp:useBean id="studentsBean" class="mod4enrollment.students" scope="session" />
        <% studentsBean.studentID = Long.parseLong(request.getParameter("studentID")); %>
        Student Record To Be Deleted:<br>
        Student ID : <%=studentsBean.studentID%><br>
        <br>
        <h5>Delete course processing...</h5>
        
        <!-- Check if deleting of record is a success -->
        <% if(studentsBean.delRecord() == 1) { %>
                <h4>[SUCCESS]</h4>
        <% } else {                            %>
                <h4>[FAILED]</h4>
                <p class='err-text'>An error occurred</p>
        <% }                                   %>
        
        <br>
        <ul>
            <li class='li-nav'>
                <a href="delstudent_select.jsp">Select Another Student to Delete</a>
            </li>
            <li class='li-nav'>
                <a href="studentmaintenance.jsp">Back to Student Maintenance</a>
            </li>
            <li class='li-nav'>
                <a href="index.jsp">Back to Main Menu</a>
            </li>
        </ul>
    </body>
</html>
