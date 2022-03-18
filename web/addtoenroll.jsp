<%-- 
    Document   : addtoenroll
    Created on : 01 18, 22, 2:02:33 PM
    Author     : Ben Kennard Ong
--%>

<%@page import="java.sql.*, java.util.*, mod4enrollment.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Enrollment Added</title>
    </head>
    <body>
        <h1>Enrollment added</h1>
        <jsp:useBean id="enrollBean" class="mod4enrollment.enroll" scope="session" />
        
        <% enrollment e = new enrollment();                                                 %>
        <% e.studentID = Long.parseLong(request.getParameter("studentid"));               %>
        <% e.courseID    = request.getParameter("coursedegree");                            %>
        <% e.term  = Integer.parseInt(request.getParameter("term"));                        %>
        <% e.schoolyear  = Integer.parseInt(request.getParameter("schoolyear"));            %>
        <% enrollBean.EnrollmentList.add(e);                                                %>
        
        <form name="enroll" action="enroll.jsp" method="POST">
        <input type="hidden" name="studentid" id="studentid" value=<%=request.getParameter("studentid")%>>                
        <input type="hidden" name="term" id="term" value=<%=request.getParameter("term")%>>
        <input type="hidden" name="schoolyear" id="schoolyear" value=<%=request.getParameter("schoolyear")%>>    
        Click here to enroll another course <input type="submit" value="enroll" name="enroll">
        </form>
    </body>
</html>
