<%-- 
    Document   : modstudent_save
    Created on : 01 19, 22, 10:23:14 PM
    Author     : Pierre Vincent C. Hernandez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*, mod4enrollment.*" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modify Student Process</title>
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
        <h1>Modify Student Process</h1>
        <jsp:useBean id="studentsBean" class="mod4enrollment.students" scope="session" />
        <%
            studentsBean.fullName = request.getParameter("fullName");
            studentsBean.degreeID = request.getParameter("degreeID");
        %>
        Modified Student Record Details:<br>
        Student ID    : <%=studentsBean.studentID%><br>
        Complete Name : <%=studentsBean.fullName%><br>
        Degree ID     : <%=studentsBean.degreeID%><br>
        <br>
        <h5>Modify course processing...</h5>
        <!-- 
            TODO: Call modRecord() method.
                  Determine whether modifying of record
                  succeeded or failed, then display the result.
        -->
        <!-- Check if modifying/updating of record is a success -->
        <% if(studentsBean.modRecord() == 1) { %>
                <h4>[SUCCESS]</h4>
        <% } else {                            %>
                <h4>[FAILED]</h4>
                <p class='err-text'>Possible causes:
                <ul class='err-text'>
                    <li>Some of the inputted values exceeded their maximum length.</li>
                </ul>
                </p>
        <% }                                   %>
        
        <br>
        <ul>
            <li class='li-nav'>
                <a href="modstudent_select.jsp">Select Another Student to Modify</a>
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
