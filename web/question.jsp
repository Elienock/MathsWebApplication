<%-- 
    Document   : question
    Created on : 13 Apr 2022, 5:21:18 PM
    Author     : lubay
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Question Page</title>
    </head>
    <%
    String fname = (String) session.getAttribute("fname");
    String lname = (String) session.getAttribute("lname");
    String op = (String) session.getAttribute("op");
    Integer num1 = (Integer) session.getAttribute("num1");
    Integer num2 = (Integer) session.getAttribute("num2");
    Integer questionAsked =(Integer) session.getAttribute("questionAsked");
    %>
    <body>
        <h1>Hi <%=fname%> <%=lname%> </h1> 
        <p>Please answer this questions</p>
        <h3>Question <%=questionAsked%></h3>
        
        <form action="OutcomeServlet.do" method="POST">
            <table>
                <tr>
                    <td><%=num1%> <%=op%> <%=num2%></td>
                </tr>
                <tr>
                    <td><input type="text" name="userAns"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" name="submit"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
