<%-- 
    Document   : addstudent_save
    Created on : 01 19, 22, 9:19:09 PM
    Author     : Pierre Vincent C. Hernandez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Student Process</title>
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
        <h1>Add Student Process</h1>
        <jsp:useBean id="studentsBean" class="mod4enrollment.students" scope="session" />
        <%
            studentsBean.studentID = Long.parseLong(request.getParameter("studentID"));
            studentsBean.fullName = request.getParameter("fullName");
            studentsBean.degreeID = request.getParameter("degreeID");
        %>
        
        Student Record To Be Added:<br>
        Student ID    : <%=studentsBean.studentID%><br>
        Complete Name : <%=studentsBean.fullName%><br>
        Degree ID     : <%=studentsBean.degreeID%><br>
        
        <br>
        <h5>Add student processing...</h5>
        
        <!-- Check if adding of record is a success -->
        <% if(studentsBean.addRecord() == 1) { %>
                <h4>[SUCCESS]</h4>
        <% } else {                            %>
                <h4>[FAILED]</h4>
                <p class='err-text'>Possible causes:
                <ul class='err-text'>
                    <li>A record with the same student ID already exists.</li>
                    <li>Some of the inputted values exceeded their maximum length.</li>
                </ul>
                </p>
        <% }                                   %>
        
        <br>
        <ul>
            <li class='li-nav'>
                <a href="addstudent.jsp">Add Another Student</a>
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
