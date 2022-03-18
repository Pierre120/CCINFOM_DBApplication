<%-- 
    Document   : submitenroll
    Created on : 01 18, 22, 10:25:44 AM
    Author     : Ben Kennard Ong
--%>

<%@page import="java.sql.*, mod4enrollment.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Submit Enrollment</title>
        <style>
            .li-nav {
                display: block;
                padding: 10px 0px;
            }
        </style>
    </head>
    <body>
        <jsp:useBean id="enrollBean" class="mod4enrollment.enroll" scope="session" />
        <% enrollBean.confirmEnrollment(); %>
        Enrollment Confirmed<br>
        <br>
        <ul>
            <li class='li-nav'>
                <a href="index.jsp">Back to Main Menu</a>
            </li>
        </ul>
    </body>
</html>
