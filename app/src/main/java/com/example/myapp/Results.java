package com.example.myapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Results extends AppCompatActivity {

    private int resultID;
    private TextView textViewRes;

    public Results () { };

    public Results(int resultID) {
        this.resultID = resultID;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        textViewRes = findViewById(R.id.resTextView);
        textViewRes.getText(MainActivity.question [0].getQuestionResId ());
    }
}