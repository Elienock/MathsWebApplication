package za.ac.tut.web;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import za.ac.tut.business.MathSBLocal;

/**
 *
 * @author lubay
 */
public class MathServlet extends HttpServlet {

    @EJB
    private MathSBLocal mathSB;

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        //get the session
        HttpSession session = request.getSession();
        
        //generate the 2 random number
        Integer num1 = mathSB.generateNumber();
        Integer num2= mathSB.generateNumber();
        //generate operation
        String op= mathSB.generateOperation();
        
        
        
        //increment count
        Integer questionAsked = mathSB.incrementQuestionAsked(session);
        //method that will calculate the correct answer
        //update it in a session
        updateSession(session,num1,num2,op,questionAsked);
        //method that will create a question
       
        //send it to a jsp
        RequestDispatcher disp = request.getRequestDispatcher("question.jsp");
        disp.forward(request, response);
       
    }

    private void updateSession(HttpSession session, Integer num1, Integer num2, String op,Integer questionAsked) {
       session.setAttribute("num1", num1);
       session.setAttribute("num2", num2);
       session.setAttribute("op", op);
       session.setAttribute("questionAsked", questionAsked);
    }


}
