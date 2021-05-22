package com.example.myapp;

public class Question {
    private int questionResId;
    private boolean answerTrue;

    public Question(int questionResId, boolean answerTrue) {
        this.questionResId = questionResId;
        this.answerTrue = answerTrue;
    }

    public int getQuestionResId() {
        return questionResId;
    }

    public boolean isAnswerTrue() {
        return answerTrue;
    }
}
