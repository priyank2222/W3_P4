package com.example.priyankshah.w3_p4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    private TextView ran1;
    private TextView ran2;
    private TextView txtGenerate;
    private EditText txtInput;
    private TextView txtAns;
    private Button btnSub2;
    private TextView txtDiv;
    private TextView txtMsg;
    private Button btnRestart;
    int total_correct = 0;
    int total_questions = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent my_intent = getIntent();
        setContentView(R.layout.activity_main2);
        String abc = my_intent.getStringExtra("key");

        ran1 = (TextView) findViewById(R.id.ran1);
        ran2 = (TextView) findViewById(R.id.ran2);
        txtGenerate = (TextView) findViewById(R.id.txtGenerate);
        txtInput = (EditText) findViewById(R.id.txtInput);
        txtAns = (TextView) findViewById(R.id.txtAns);
        btnSub2 = (Button) findViewById(R.id.btnSub2);
        txtDiv = (TextView) findViewById(R.id.txtDiv);
        txtMsg = (TextView) findViewById(R.id.txtMsg);
        btnRestart = (Button) findViewById(R.id.btnRestart);

        Toast.makeText(getApplicationContext(), "Welcome : "+abc+"", Toast.LENGTH_SHORT).show();

        generateRandom();

        btnRestart.setVisibility(View.INVISIBLE);

        btnSub2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(total_questions == 9) {
                    txtMsg.setText("Total Correct : " + total_correct + "/ 10");
                    btnRestart.setVisibility(View.VISIBLE);
                }
                else
                {
                    checkAnswer();
                    nextQuestion();
                }
            }
        });

        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                total_questions = 0;
                total_correct = 0;
                nextQuestion();
                btnRestart.setVisibility(View.INVISIBLE);
            }
        });



    }

    protected void checkAnswer()
    {
        int answer = Integer.parseInt(ran1.getText().toString()) / Integer.parseInt(ran2.getText().toString());
        if(answer == Integer.parseInt(txtInput.getText().toString()))
        {
            Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
            total_correct++;
        }
        else
            Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();
    }

    protected void nextQuestion()
    {
        generateRandom();
        total_questions++;
    }

    protected void generateRandom()
    {
        int random1;
        int random2;

        while(true)
        {
            int rand1 =  (int) (Math.random() * 500 + 1);
            int rand2 =  (int) (Math.random() * 500 + 1);

            if(rand1 % rand2 == 0)
            {
                random1 = rand1;
                random2 = rand2;
                break;
            }
        }

        ran1.setText(random1+"");
        ran2.setText(random2+"");

    }

    protected void onSaveInstanceState(Bundle outState) {

        outState.putInt("total_questions", total_questions);
        outState.putInt("correct_ans" , total_correct);
        outState.putString("ran1" , ran1.getText().toString() );
        outState.putString("ran2", ran2.getText().toString());

        super.onSaveInstanceState(outState);  //QUESTION: why do we do this last?

    }

    protected void onRestoreInstanceState(Bundle savedInstanceState) {   //QUESTIONS: Will this always be called, if not, why not?
        super.onRestoreInstanceState(savedInstanceState);

        total_questions = savedInstanceState.getInt("total_questions");
        total_correct = savedInstanceState.getInt("correct_ans");
        ran1.setText(savedInstanceState.getString("ran1"));
        ran2.setText(savedInstanceState.getString("ran2"));

    }


}
