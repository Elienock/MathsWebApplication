/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.business;

import javax.ejb.Local;
import javax.servlet.http.HttpSession;

/**
 *
 * @author lubay
 */
@Local
public interface MathSBLocal {

    Integer generateNumber();

    String generateOperation();

    Integer incrementQuestionAsked(HttpSession session);

    String createQuestion(HttpSession session);

    Integer correctAnswer(HttpSession session);

    String determineOutcome(Integer userAns, Integer correctAns);
    
}
