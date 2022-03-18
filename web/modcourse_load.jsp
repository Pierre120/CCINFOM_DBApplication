<%-- 
    Document   : modcourse_load
    Created on : 01 19, 22, 12:18:56 PM
    Author     : Pierre Vincent C. Hernandez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*, mod4enrollment.*" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modify Course Load</title>
    </head>
    <body>
        <h1>Modify Course Load</h1>
        <jsp:useBean id="coursesBean" class="mod4enrollment.courses" scope="session" />
        <%
            // Load course record to be modified
            coursesBean.courseID = request.getParameter("courseID");
            coursesBean.getRecord();
        %>
        
        <!-- If course record doesn't exist, notify user and don't show the form -->
        <% if(coursesBean.courseID.equals("")) {                        %>
            <h4>[WARNING] Entered course doesn't exist in the course records.</h4>
        <% } else { // Course record exists. Ask user for modifications %>
            Course Record Being Modified:<br>
            Course ID   : <%=coursesBean.courseID%><br>
            Course Name : <%=coursesBean.courseName%><br>
            Department  : <%=coursesBean.department%><br>
            <br>
        
            <h3>Modify Course Details</h3>
            <form name="modcourse" action="modcourse_save.jsp" method="POST">
                Enter new course name: 
                    <input type="text" 
                           name="courseName" 
                           id="courseName" 
                           value="<%=coursesBean.courseName%>"><br> <!-- Default value -->
                Enter new course department: 
                    <input type="text" 
                           name="dept" 
                           id="dept" 
                           value="<%=coursesBean.department%>"><br> <!-- Default value -->
                <input type="submit" value="Modify Course" name="modcourse" />
            </form>
        <% }                                                            %>
        
        <br>
        <ul>
            <li><a href="modcourse_select.jsp">Cancel Modification</a></li>
        </ul>
    </body>
</html>
