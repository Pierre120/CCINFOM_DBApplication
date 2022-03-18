<%-- 
    Document   : enroll
    Created on : 01 18, 22, 10:13:13 AM
    Author     : Ben Kennard Ong
--%>


<%@page import="java.sql.*, java.util.*, mod4enrollment.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Enroll</title>
    </head>
    <body>
        <jsp:useBean id="enrollBean" class="mod4enrollment.enroll" scope="session" />
        <% enrollBean.Student.studentID = Long.parseLong(request.getParameter("studentid"));  %>
        <% enrollBean.Student.getRecord();                                                      %>
        <% enrollBean.loadCourses();                                                            %>
        
        <form name="enrollment" action="addtoenroll.jsp" method="POST">
        Select Course Degree  <select name="coursedegree" id="coursedegree">
                            <% for (int i = 0; i < enrollBean.CourseList.size(); i++){         %>  
                            <%     coursedegree cd = new coursedegree();                        %>
                            <%     cd = enrollBean.CourseList.get(i);                           %>
                            <option value ="<%=cd.courseID%>"><%=cd.courseID%></option>
                            <% }                                                                %>
                        </select><br>
        <input type="hidden" name="studentid" id="studentid" value=<%=request.getParameter("studentid")%>>                
        <input type="hidden" name="term" id="term" value=<%=request.getParameter("term")%>>
        <input type="hidden" name="schoolyear" id="schoolyear" value=<%=request.getParameter("schoolyear")%>>                
        <input type="submit" value="Add to Enroll" name="addtoenroll">
        </form>
                        
        <form name="confirmEnrollment" action="submitenroll.jsp" method="POST">
        Submit Enrollment <input type="submit" value="Submit Enroll" name="submitenroll">
        </form>
    </body>
</html>
