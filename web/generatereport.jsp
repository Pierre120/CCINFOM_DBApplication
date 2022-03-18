<%-- 
    Document   : generatereport
    Created on : 01 8, 22, 1:09:47 PM
    Author     : ccslearner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*, mod4enrollment.*" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Generate Report</title>
        <style>
          table, th, td {
            border:1px solid black;
            text-align: center;
          }
        </style>
    </head>
    <body>
        <jsp:useBean id="reportBean" class="mod4enrollment.report" scope="session" />
        <%
          reportBean.repTerm = Integer.parseInt(request.getParameter("term"));
          reportBean.repSchoolYear = Integer.parseInt(request.getParameter("schoolyear"));
          reportBean.generateReport();
        %>
        <h1>Report for Term <%=reportBean.repTerm%> AY <%=reportBean.repSchoolYear%></h1>
        
        <table>
            <tr>
                <th>Course ID</th>
                <th>Course Name</th>
                <th>Number of Students</th>
            </tr>
        <% for(int i = 0; i < reportBean.courseArr.size(); i++) { %>
            <tr>
                <td><%=reportBean.courseArr.get(i).courseID%></td>
                <td><%=reportBean.courseArr.get(i).courseName%></td>
                <td><%=reportBean.countArr.get(i)%></td>
            </tr>
        <% }                                                      %>
        </table>
        
        <br>
        <ul>
            <li class='li-nav'>
                <a href="index.jsp">Back to Main Menu</a>
            </li>
        </ul>
    </body>
</html>
