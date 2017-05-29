package com.example.osl.mysqldemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

public class MainPage extends AppCompatActivity {

    Button buttonPro;
    Button buttonBr;
    Button buttonSu;
    Button buttonPl;
    Button buttonPr;

    // Intent intent = new Intent(getIntent());
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);


        buttonPro = (Button) findViewById(R.id.buttonPro);
        buttonBr = (Button) findViewById(R.id.buttonBr);
        buttonSu = (Button) findViewById(R.id.buttonSu);
        buttonPl = (Button) findViewById(R.id.buttonPl);
        buttonPr = (Button) findViewById(R.id.buttonPr);




    }
}
