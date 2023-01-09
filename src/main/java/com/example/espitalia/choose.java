package com.example.espitalia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class choose extends AppCompatActivity {
    private Button button1;
    private Button button2;

    Button Login;
    Button Signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);


        Login= findViewById(R.id.button1);
        Signup= findViewById(R.id.button2);


        Login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                openlogin();

            }
        });

        Signup.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                opensignup();
            }
        });

    }

    public void openlogin() {
        Intent intent = new Intent(choose.this, Login.class);
        startActivity(intent);
    }
    public void opensignup(){
        Intent intent = new Intent(choose.this, signup.class);
        startActivity(intent);
    }

}