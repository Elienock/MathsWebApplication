<%-- 
    Document   : summary
    Created on : 13 Apr 2022, 7:52:49 PM
    Author     : lubay
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Summary Page</title>
    </head>
    <body>
        <h1>Summary Page</h1>
        <c:forEach items='${sessionScope["questions"]}' var="question">
            <ul>
                <li> <h1><strong>Question</strong> ${question.getQuestionAsked()}</h1></li>
                <li><strong>Question :</strong>  ${question.getQuestion()} </li>
                <li><strong>Your Answer :</strong>  ${question.getUserAns()} </li>
                <li><strong>Correct Answer :</strong>  ${question.getCorrectAnswer()}</li>
                 <li><strong>Outcome :</strong> ${question.getOutcome()}</li>
                
            </ul>
        </c:forEach>
    </body>
</html>
