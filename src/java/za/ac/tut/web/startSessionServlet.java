package za.ac.tut.web;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import za.ac.tut.business.Question;

/**
 *
 * @author lubay
 */
public class startSessionServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       //create session
       HttpSession session = request.getSession(true);
       
       //get parameters
       String fname= request.getParameter("fname");
       String lname = request.getParameter("lname");
       
       //initialise the session
       initialiseSession(session,fname,lname);
       
       //send it to another servlet where we will generate the question
       response.sendRedirect("MathServlet.do");
    }

    private void initialiseSession(HttpSession session, String fname, String lname) {
        Integer questionAsked=0, correctAns=0,userAns=0,num1=0,num2=0;
        String op ="";
        Double percentage=0.00;
        String outcome="", question="";
        List<Question> questions = new ArrayList<>();
        
        session.setAttribute("lname", lname);
        session.setAttribute("fname", fname);
        session.setAttribute("questionAsked", questionAsked);
        session.setAttribute("op", op);
        session.setAttribute("percentage", percentage);
        session.setAttribute("correctAns", correctAns);
        session.setAttribute("outcome", outcome);
        session.setAttribute("userAns", userAns);
        session.setAttribute("num1", num1);
        session.setAttribute("num2", num2);
        session.setAttribute("questions", questions);
        session.setAttribute("question", question);
    }

 
}
