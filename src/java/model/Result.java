package model;

import java.sql.Timestamp;

public class Result {

    private int id;
    private int studentId;
    private String studentName;
    private String subjectName;
    private String examName;
    private int examId;
    private int marks;
    private Timestamp examDate;

    public Result() {
    }

    public Result(int studentId, int examId, int marks) {
        this.studentId = studentId;
        this.examId = examId;
        this.marks = marks;
    }

    public Result(int id, int studentId, String studentName, String subjectName,
            String examName, int examId, int marks, Timestamp examDate) {
        this.id = id;
        this.studentId = studentId;
        this.studentName = studentName;
        this.subjectName = subjectName;
        this.examName = examName;
        this.examId = examId;
        this.marks = marks;
        this.examDate = examDate;
    }

    public Result(int id, int studentId, int examId, int marks, Timestamp examDate) {
        this.id = id;
        this.studentId = studentId;
        this.examId = examId;
        this.marks = marks;
        this.examDate = examDate;
    }

    public Result(int id, int studentId, String studentName, String examName, int examId, int marks, Timestamp examDate) {
        this.id = id;
        this.studentId = studentId;
        this.examId = examId;
        this.marks = marks;
        this.examDate = examDate;
        this.studentName = studentName;
        this.examName = examName;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public Timestamp getExamDate() {
        return examDate;
    }

    public void setExamDate(Timestamp examDate) {
        this.examDate = examDate;
    }
}
