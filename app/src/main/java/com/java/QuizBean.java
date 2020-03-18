package com.java;

import com.google.gson.annotations.SerializedName;

public class QuizBean {

    @SerializedName("id_question")
    private Long id_question;

    @SerializedName("description_question")
    private String description_question;

    @SerializedName("id_answer")
    private Long id_answer;

    @SerializedName("description_answer")
    private String description_answer;

    public Long getId_question() {
        return id_question;
    }

    public void setId_question(Long id_question) {
        this.id_question = id_question;
    }

    public String getDescription_question() {
        return description_question;
    }

    public void setDescription_question(String description_question) {
        this.description_question = description_question;
    }

    public Long getId_answer() {
        return id_answer;
    }

    public void setId_answer(Long id_answer) {
        this.id_answer = id_answer;
    }

    public String getDescription_answer() {
        return description_answer;
    }

    public void setDescription_answer(String description_answer) {
        this.description_answer = description_answer;
    }
}
