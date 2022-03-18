<%-- 
    Document   : addtodrop
    Created on : 01 19, 22, 3:09:37 PM
    Author     : Ben Kennard Ong
--%>

<%@page import="java.sql.*, java.util.*, mod4enrollment.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Enrollment Dropped</title>
    </head>
    <body>
        <h1>Enrollment Dropped</h1>
        <jsp:useBean id="dropBean" class="mod4enrollment.drop" scope="session" />
        
        <% enrollment e = new enrollment();                                                 %>
        <% e.studentID = Long.parseLong(request.getParameter("studentid"));               %>
        <% e.courseID    = request.getParameter("coursedegree");                            %>
        <% e.term  = Integer.parseInt(request.getParameter("term"));                        %>
        <% e.schoolyear  = Integer.parseInt(request.getParameter("schoolyear"));            %>
        <% dropBean.DropEnrollmentList.add(e);                                                %>
        
        <form name="drop" action="drop.jsp" method="POST">
        <input type="hidden" name="studentid" id="studentid" value=<%=request.getParameter("studentid")%>>                
        <input type="hidden" name="term" id="term" value=<%=request.getParameter("term")%>>
        <input type="hidden" name="schoolyear" id="schoolyear" value=<%=request.getParameter("schoolyear")%>>    
        Click here to drop another course <input type="submit" value="drop" name="drop">
        </form>
    </body>
</html>