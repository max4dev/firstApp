package com.example.myapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Results extends AppCompatActivity {

    private int resultID;

    private int index;

    private String answer;
    private TextView textViewRes;
    private Button Backbtn;

    //КОНСТРУКТОРЫ
    public Results () { };

    public Results (int index, String answer) {
        this.answer = answer;
        this.index = index;
    }


    //ГЕТТЕРЫ
    public int getResultID() {
        return resultID;
    }

    public int getIndex() {
        return index;
    }

    public String getAnswer() {
        return answer;
    }


    //МЕТОД ВЫВОДА РЕЗУЛЬТАТОВ НА ЭКРАН
    static String showRes (int j, String s, Results array []) {
       String a = "";
        for (int i=0; i < j+1; i++) {
           a += "Ответ на вопрос: " + (array [i].index + 1) + " - " + array [i].answer + "\n";
        }
        return a;
    }

    //ВЫВОД НА ЭКРАН АКТИВНОСТИ

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        textViewRes = findViewById(R.id.resTextView);
        Bundle receiver = getIntent().getExtras();
        textViewRes.setText (receiver.get("answers").toString());


        Backbtn = findViewById((R.id.btnBack));
        Backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Results.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}