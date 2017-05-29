package com.example.osl.mysqldemo;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    EditText UsernameEt, PasswordEt;
    Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UsernameEt = (EditText)findViewById(R.id.etUserName);
        PasswordEt = (EditText)findViewById(R.id.etPassword);
        btnLogin = (Button)findViewById(R.id.btnLogin);
    }

    public void OnLogin(View view) {
        final String username = UsernameEt.getText().toString();
        final String password = PasswordEt.getText().toString();
        final String type = "login";


        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, username, password);
    }
//        btnLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                if((!UsernameEt.getText().toString().equals(""))&&(!PasswordEt.getText().toString().equals("")))
//                {
//
//                else {
//                    Toast.makeText(getApplicationContext(),
//                            "Username or password field is empty", Toast.LENGTH_SHORT).show();
//                }
//
//            }
//        });


    }



