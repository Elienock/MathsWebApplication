<%-- 
    Document   : outcome
    Created on : 13 Apr 2022, 6:57:16 PM
    Author     : lubay
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Outcome Page</title>
        <%
        String fname = (String) session.getAttribute("fname");
    String lname = (String) session.getAttribute("lname");
    String outcome = (String) session.getAttribute("outcome");
    String question =(String) session.getAttribute("question");
    Integer userAns =(Integer) session.getAttribute("userAns");
    Integer correctAns =(Integer) session.getAttribute("correctAns");
        %>
    </head>
    <body>
        <h1>Hi <%=fname%> <%=lname%> </h1>
        <strong>Question : </strong>  <%=question%> <br>
        <strong>Your Answer : </strong>  <%=userAns%> <br>
        <strong>Correct Answer : </strong>  <%=correctAns%> <br>
        <strong>Outcome : </strong>  <%=outcome%> <br>
        click <a href="MathServlet.do">here</a> to play gain <br>
        click <a href="summary.jsp">here</a> to end game
    </body>
</html>
