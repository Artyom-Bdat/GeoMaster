package com.example.tyomo_prodaqshn.model;

public class question_model {

    String question;

    String patasxan;

    String ImageURL;


    public question_model() {
    }

    public question_model(String question, String patasxan, String imageURL) {
        this.question = question;
        this.patasxan = patasxan;
        ImageURL = imageURL;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getPatasxan() {
        return patasxan;
    }

    public void setPatasxan(String patasxan) {
        this.patasxan = patasxan;
    }

    public String getImageURL() {
        return ImageURL;
    }

    public void setImageURL(String imageURL) {
        ImageURL = imageURL;
    }
}
