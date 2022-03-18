<%-- 
    Document   : modstudent_load
    Created on : 01 19, 22, 10:22:48 PM
    Author     : Pierre Vincent C. Hernandez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*, mod4enrollment.*" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modify Student Load</title>
    </head>
    <body>
        <h1>Modify Student Load</h1>
        <jsp:useBean id="studentsBean" class="mod4enrollment.students" scope="session" />
        <%
            // Load student record to be modified
            studentsBean.studentID = Long.parseLong(request.getParameter("studentID"));
            studentsBean.getRecord();
        %>
        
        <!-- If course record doesn't exist, notify user and don't show the form -->
        <% if(studentsBean.studentID == 0) {                             %>
            <h4>[WARNING] Entered student doesn't exist in the student records.</h4>
        <% } else { // Student record exists. Ask user for modifications %>
            Student Record Being Modified:<br>
            Student ID    : <%=studentsBean.studentID%><br>
            Complete Name : <%=studentsBean.fullName%><br>
            Degree ID     : <%=studentsBean.degreeID%><br>
            <br>
            
            <h3>Modify Course Details</h3>
            <form name="modstudent" action="modstudent_save.jsp" method="POST">
                Enter new complete name: 
                    <input type="text" 
                           name="fullName" 
                           id="fullName" 
                           value="<%=studentsBean.fullName%>"><br> <!-- Default value -->
                Enter new degree ID: 
                    <input type="text" 
                           name="degreeID" 
                           id="degreeID" 
                           value="<%=studentsBean.degreeID%>"><br> <!-- Default value -->
                <input type="submit" value="Modify Student" name="modstudent" />
            </form>
        <% }                                                             %>
        
        <br>
        <ul>
            <li><a href="modstudent_select.jsp">Cancel Modification</a></li>
        </ul>
    </body>
</html>
