/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import za.ac.tut.business.MathSBLocal;
import za.ac.tut.business.Question;

/**
 *
 * @author lubay
 */
public class OutcomeServlet extends HttpServlet {

    @EJB
    private MathSBLocal mathSB;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       //we get the session
       HttpSession session = request.getSession();
       
       //we get the parameters
       int userAns = Integer.parseInt(request.getParameter("userAns"));
       
       //method that will create question
       String question = mathSB.createQuestion(session);
       
       //method that will calculate the correct answer
       int correctAns = mathSB.correctAnswer(session);
       
       //method that will calculate the outcome
       String outcome = mathSB.determineOutcome(userAns, correctAns);
       
       //get the question asked
       Integer questionAsked = (Integer)session.getAttribute("questionAsked");
       
       //create object Question(question,userAns,correctAnswer,Outcome)
       Question question1 = new Question(questionAsked,question,userAns,correctAns,outcome);
       //get the list
       //
       //add it in a list
       List<Question> questions =(List<Question>)session.getAttribute("questions");
       questions.add(question1);
       
       //update the session
       updateSession(session,questions,outcome,correctAns,question,userAns);
       
       //send it to the jsp
       RequestDispatcher disp = request.getRequestDispatcher("outcome.jsp");
       disp.forward(request, response);
    }

    private void updateSession(HttpSession session,List<Question> questions, String outcome, Integer correctAns, String question, Integer userAns) {
      
       session.setAttribute("questions", questions);
       session.setAttribute("outcome", outcome);
       session.setAttribute("correctAns", correctAns);
       session.setAttribute("question", question);
       session.setAttribute("userAns", userAns);
    }


}
