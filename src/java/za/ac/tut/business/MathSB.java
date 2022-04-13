/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.business;

import java.util.Objects;
import javax.ejb.Stateless;
import javax.servlet.http.HttpSession;

/**
 *
 * @author lubay
 */
@Stateless
public class MathSB implements MathSBLocal {
    String[] operations={"+","*"};
    @Override
    public Integer generateNumber() {
        Integer randNum;
        
        randNum = 1 + (int)Math.floor(Math.random()*10);
        
        return randNum;
    }

    @Override
    public String generateOperation() {
        Integer randNum;
        
        randNum = (int)Math.floor(Math.random()*2);
        
        return operations[randNum];
    }

    @Override
    public Integer incrementQuestionAsked(HttpSession session) {
        //we get the quesstion asked from the session
      Integer questionAsked = (Integer) session.getAttribute("questionAsked");
      
       questionAsked ++;
       return questionAsked;
    }

    @Override
    public String createQuestion(HttpSession session) {
        String question;
       Integer num1 = (Integer)session.getAttribute("num1");
       Integer num2 = (Integer)session.getAttribute("num2");
       String op = (String)session.getAttribute("op");
       
       question = num1 + " " +op +" " + num2;
       
       return question;
    }

    @Override
    public Integer correctAnswer(HttpSession session) {
        Integer correctAns;
        
       Integer num1 = (Integer)session.getAttribute("num1");
       Integer num2 = (Integer)session.getAttribute("num2");
       String op = (String)session.getAttribute("op");
       
       if(op.equals("+")){
           correctAns = num1 + num2;
       }else{
           correctAns = num1 * num2;
       }
       
       return correctAns;
    }

    @Override
    public String determineOutcome(Integer userAns, Integer correctAns) {
       String outcome;
       
       if(Objects.equals(userAns, correctAns)){
           outcome="Correct";
       }else{
           outcome="Wrong";
       }
       
       return outcome;
    }
    
    
    
}
