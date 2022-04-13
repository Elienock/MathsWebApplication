/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.business;

/**
 *
 * @author lubay
 */
public class Question {
    private Integer questionAsked;
    private String question;
    private Integer userAns;
    private Integer correctAnswer;
    private String outcome;

    public Question(Integer questionAsked ,String question, Integer userAns, Integer correctAnswer, String outcome) {
        this.question = question;
        this.userAns = userAns;
        this.correctAnswer = correctAnswer;
        this.outcome = outcome;
        this.questionAsked=questionAsked;
    }

    public Integer getQuestionAsked() {
        return questionAsked;
    }

    public void setQuestionAsked(Integer questionAsked) {
        this.questionAsked = questionAsked;
    }

    
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Integer getUserAns() {
        return userAns;
    }

    public void setUserAns(Integer userAns) {
        this.userAns = userAns;
    }

    public Integer getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(Integer correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcomee) {
        this.outcome = outcomee;
    }
    
    
}
