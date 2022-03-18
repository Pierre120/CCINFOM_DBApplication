<%-- 
    Document   : drop
    Created on : 01 18, 22, 10:16:37 AM
    Author     : Ben Kennard Ong
--%>

<%@page import="java.sql.*, java.util.*, mod4enrollment.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Drop</title>
    </head>
    <body>
        <jsp:useBean id="dropBean" class="mod4enrollment.drop" scope="session" />
        <% dropBean.Student.studentID = Long.parseLong(request.getParameter("studentid"));  %>
        <% dropBean.Student.getRecord();                                                      %>
        <% dropBean.loadEnrollment(Integer.parseInt(request.getParameter("term")), Integer.parseInt(request.getParameter("schoolyear")));%>
        
        <form name="drop" action="addtodrop.jsp" method="POST">
        Select Course Degree  <select name="coursedegree" id="coursedegree">
                            <% for (int i = 0; i < dropBean.CourseList.size(); i++){         %>  
                            <%     coursedegree cd = new coursedegree();                        %>
                            <%     cd = dropBean.CourseList.get(i);                           %>
                            <option value ="<%=cd.courseID%>"><%=cd.courseID%></option>
                            <% }                                                                %>
                        </select><br>
        <input type="hidden" name="studentid" id="studentid" value=<%=request.getParameter("studentid")%>>                
        <input type="hidden" name="term" id="term" value=<%=request.getParameter("term")%>>
        <input type="hidden" name="schoolyear" id="schoolyear" value=<%=request.getParameter("schoolyear")%>>                
        <input type="submit" value="Add to Drop" name="addtodrop">
        </form>                                                               
        
        <form name="confirmDrop" action="submitdrop.jsp" method="POST">
        Submit Drop <input type="submit" value="Submit Drop" name="submitdrop">
        </form>
    </body>
</html>
