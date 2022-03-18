<%-- 
    Document   : submitdrop
    Created on : 01 18, 22, 10:26:04 AM
    Author     : Ben Kennard Ong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Submit Drop</title>
        <style>
            .li-nav {
                display: block;
                padding: 10px 0px;
            }
        </style>
    </head>
    <body>
        <jsp:useBean id="dropBean" class="mod4enrollment.drop" scope="session" />
        <% dropBean.confirmDrop(); %>
        Drop Confirmed<br>
        <br>
        <ul>
            <li class='li-nav'>
                <a href="index.jsp">Back to Main Menu</a>
            </li>
        </ul>
    </body>
</html>
