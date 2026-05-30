/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Sahil
 */
import java.sql.Date;

public class Exam {

    private int id;
    private int subjectId;
    private String examName;
    private Date examDate;
    private int duration;

    public Exam() {
    }

    public Exam(int id, int subjectId, String examName, Date examDate, int duration) {
        this.id = id;
        this.subjectId = subjectId;
        this.examName = examName;
        this.examDate = examDate;
        this.duration = duration;
    }

    public Exam(int subjectId, String examName, Date examDate, int duration) {
        this.subjectId = subjectId;
        this.examName = examName;
        this.examDate = examDate;
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public Date getExamDate() {
        return examDate;
    }

    public void setExamDate(Date examDate) {
        this.examDate = examDate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

}
