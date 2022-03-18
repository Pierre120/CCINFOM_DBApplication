<%-- 
    Document   : drop_login
    Created on : 01 19, 22, 2:56:50 PM
    Author     : Ben Kennard Ong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Login</title>
        <style>
            .li-nav {
                display: block;
                padding: 10px 0px;
            }
        </style>
    </head>
    <body>
        <h1>Enter Student Info</h1>
        <form name="drop" action="drop.jsp" method="POST">
            Enter student ID: <input type="text" name="studentid" id="studentid"><br>
            Enter term: <input type="text" name="term" id="term"><br>
            Enter school year: <input type="text" name="schoolyear" id="schoolyear"><br>
            <input type="submit" value="drop" name="drop" />
        </form>
        
        <br>
        <ul>
            <li class='li-nav'>
                <a href="index.jsp">Back to Main Menu</a>
            </li>
        </ul>
    </body>
</html>


