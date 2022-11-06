package com.example.myquizapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.myquizapplication.Modul.Question;

public class MainPmActivity extends AppCompatActivity {

    private TextView textRaqam;
    private TextView textsavol;
    private Button btn4;
    private RadioGroup rg;
    private RadioButton rb1, rb2, rb3, rb4, rbTanlangan;
    private int questionid = 0;
    private int ball = 0;
    private int correct = 0;
    private int error = 0;
    private Question question;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_pm);

        btn4 = (Button) findViewById(R.id.button);
        textsavol = (findViewById(R.id.textView12));
        textRaqam = (TextView) findViewById(R.id.textView2);
        rb1 = (RadioButton) findViewById(R.id.radioButton2);
        rb2 = (RadioButton) findViewById(R.id.radioButton7);
        rb3 = (RadioButton) findViewById(R.id.radioButton8);
        rb4 = (RadioButton) findViewById(R.id.radioQuisButton9);

        int savolRaqami = questionid;
        textRaqam.setText(String.format("%s", savolRaqami++));
        textsavol.setText(question.questionProgramming[questionid]);
        extracted();

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAns();
                if (questionid == 5) {
                    Intent i = new Intent(MainPmActivity.this, MainEshActivity.class);

                    i.putExtra("ball", ball);
                    i.putExtra("corract", correct);
                    i.putExtra("error", error);
                    startActivity(i);

                }
            }
        });
    }

    private void extracted() {
        rb1.setText(question.answeryPr[questionid][0]);
        rb2.setText(question.answeryPr[questionid][1]);
        rb3.setText(question.answeryPr[questionid][2]);
        rb4.setText(question.answeryPr[questionid][3]);
    }


    private void checkAns() {
        int id = rg.getCheckedRadioButtonId();
        rbTanlangan = (RadioButton) findViewById(id);
        if (question.trueAnswer[questionid] == rbTanlangan.getText().toString()) {
            rbTanlangan.setChecked(false);
            ball += 20;
            correct++;
            questionid++;
        } else {
            rbTanlangan.setChecked(false);
            questionid++;
            error++;
            ball -= 10;
        }
        if (questionid == question.questionProgramming.length){
            Intent i = new Intent();
            i.putExtra("ball",ball);
            i.putExtra("correct",correct);
            i.putExtra("error",error);
            startActivity(i);
        }else {
            setQuestion();
        }
    }
    void setQuestion(){
        int savolRaqam = questionid;
        textRaqam.setText(String.format("%s", savolRaqam += 1));
        String a = question.questionProgramming[questionid];
        textsavol.setText(a);
        rb1.setText(question.answeryPr[questionid][0]);
        rb2.setText(question.answeryPr[questionid][1]);
        rb3.setText(question.answeryPr[questionid][2]);
        rb4.setText(question.answeryPr[questionid][3]);


    }
}