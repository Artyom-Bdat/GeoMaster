package com.example.tyomo_prodaqshn.model.users_models;

public class Qmodel {
    private String Qname;
    private String Question;
    private String answer,userName;


    public Qmodel(String qname, String question, String answer, String userName) {
        Qname = qname;
        Question = question;
        this.answer = answer;
        this.userName = userName;
    }

    public Qmodel() {
    }

    public String getQname() {
        return Qname;
    }

    public void setQname(String qname) {
        Qname = qname;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
