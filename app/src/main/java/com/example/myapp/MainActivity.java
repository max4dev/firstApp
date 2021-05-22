package com.example.myapp;


import android.content.Intent;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button yesBtn;
    private Button noBtn;
    private Button resBtn;
    private TextView textView;
    private int questionIndex = 0;
    private Question[] question = new Question [] {
        new Question(R.string.question0, true),
        new Question(R.string.question1, false),
        new Question(R.string.question2, true),
        new Question(R.string.question3, true),
        new Question(R.string.question4, false)
    };

    private Results [] results = new Results[5];


    @Override
    protected void onCreate (Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        Log.d("КОНТРОЛЬ!!!", "onCreate запущен");
        setContentView(R.layout.activity_main);
        if (saveInstanceState != null) {
            questionIndex = saveInstanceState.getInt("questionIndex");

        }

        textView = findViewById(R.id.textView);
        textView.setText(question [questionIndex].getQuestionResId ());

        yesBtn = findViewById(R.id.btnYes);
        yesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (question[questionIndex].isAnswerTrue()) {
                    Toast.makeText(MainActivity.this, R.string.correct, Toast.LENGTH_SHORT).show();
                    results[questionIndex] = new Results(R.string.incorrect);
                  //  System.out.println("yesBtn - Да" + results[questionIndex].getString(R.string.correct));
                } else {
                    Toast.makeText(MainActivity.this, R.string.incorrect, Toast.LENGTH_SHORT).show();
                    results[questionIndex] = new Results(R.string.incorrect);
                    System.out.println("yesBtn - Нет" + results[questionIndex]);
                }
            questionIndex = (questionIndex + 1) % question.length;
            textView.setText(question[questionIndex].getQuestionResId());
            }
        });

        noBtn = findViewById(R.id.btnNo);
        noBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (question[questionIndex].isAnswerTrue()) {
                    Toast.makeText(MainActivity.this, R.string.incorrect, Toast.LENGTH_SHORT).show();
                    results [questionIndex] = new Results (R.string.incorrect);
                } else {
                    Toast.makeText(MainActivity.this, R.string.correct, Toast.LENGTH_SHORT).show();
                    results [questionIndex] = new Results (R.string.correct);
                }
            questionIndex = (questionIndex + 1) % question.length;
            textView.setText(question[questionIndex].getQuestionResId());
            }
        });

        resBtn = findViewById(R.id.btnRes);
        resBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Results.class);
                startActivity(intent);
            }
        });
    }



    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState (savedInstanceState);
        Log.d("КОНТРОЛЬ!!!", "onSavedInstanceState запущен");
        savedInstanceState.putInt("questionIndex", questionIndex);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("КОНТРОЛЬ!!!", "onResume запущен");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("КОНТРОЛЬ!!!", "onStop запущен");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("КОНТРОЛЬ!!!", "onDestroy запущен");
    }

    @Override
    protected void onPause () {
        super.onPause();
        Log.d("КОНТРОЛЬ!!!", "onPause запущен");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("КОНТРОЛЬ!!!", "onStart запущен");
    }




}
