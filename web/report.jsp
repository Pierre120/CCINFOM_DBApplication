<%-- 
    Document   : report
    Created on : 01 8, 22, 1:05:46 PM
    Author     : Cyril Reyes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Generate Report</title>
        <style>
            .li-nav {
                display: block;
                padding: 10px 0px;
            }
        </style>
    </head>
    <body>
        <h1>Enter Report Info</h1>
        <form name="report" action="generatereport.jsp" method="POST">
            Enter term: <input type="number" name="term" id="term" required><br>
            Enter school year: <input type="number" name="schoolyear" id="schoolyear" required><br>
            <input type="submit" value="Generate Report" name="report" />
        </form>
        
        <br>
        <ul>
            <li class='li-nav'>
                <a href="index.jsp">Back to Main Menu</a>
            </li>
        </ul>
    </body>
</html>
