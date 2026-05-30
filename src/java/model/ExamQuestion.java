/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Sahil
 */
public class ExamQuestion {

    private int id;
    private int examId;
    private int questionId;

    public ExamQuestion() {
    }

    public ExamQuestion(int examId, int questionId) {
        this.examId = examId;
        this.questionId = questionId;
    }

    public ExamQuestion(int id, int examId, int questionId) {
        this.id = id;
        this.examId = examId;
        this.questionId = questionId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

}
