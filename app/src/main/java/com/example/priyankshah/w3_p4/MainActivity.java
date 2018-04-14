package com.example.priyankshah.w3_p4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txtUser;
    private TextView txtPass;
    private EditText user;
    private EditText pass;
    private Button btnSub;
    private TextView txtTitle;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtTitle = (TextView) findViewById(R.id.txtTitle);
        txtUser = (TextView) findViewById(R.id.txtUser);
        txtPass = (TextView) findViewById(R.id.txtPass);
        user = (EditText) findViewById(R.id.user);
        pass = (EditText) findViewById(R.id.pass);
        btnSub = (Button) findViewById(R.id.btnSub);

        final String user_name = "abc";
        final String password = "abc123";

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(user.getText().toString().equals(user_name) && pass.getText().toString().equals(password))
                {
                    Intent my_intent = new Intent(MainActivity.this,Main2Activity.class);
                    my_intent.putExtra("key","abc");
                    MainActivity.this.startActivity(my_intent);
                }

            }
        });



    }

}
