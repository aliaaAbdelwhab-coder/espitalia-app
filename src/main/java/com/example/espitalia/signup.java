package com.example.espitalia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
//import android.support.design.widget.TextInputLayout;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import java.util.regex.Pattern;

public class signup extends AppCompatActivity {
    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    "(?=.*[0-9])" +         //at least 1 digit
                    "(?=.*[a-z])" +         //at least 1 lower case letter
                    "(?=.*[A-Z])" +         //at least 1 upper case letter
                    //  "(?=.*[a-zA-Z])" +      //any letter
                    "(?=.*[@#$%^&+=])" +    //at least 1 special character
                    "(?=\\S+$)" +           //no white spaces
                    ".{6,}" +               //at least 6 characters
                    "$");
    // private Button signup;
    // Button Sign_up;

    EditText Signup_name,Signup_password,Signup_phone,Signup_Email;
    Button Signup_bu;

    TextView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);
        Signup_name=findViewById(R.id.Signup_Name);
        Signup_phone=findViewById(R.id.Signup_phone);
        Signup_password=findViewById(R.id.Signup_password);
        Signup_Email=findViewById(R.id.signup_Email);
        Signup_bu=findViewById(R.id.Signup_Button);


        back = findViewById(R.id.textView);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(signup.this,choose.class);
                startActivity(intent);
            }
        });



        // Signup_bu = findViewById(R.id.Signup_Button);
        Signup_bu.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //openhomepage();
                confirmInput();
            }

        });
        // Sign_up = findViewById(R.id.signup);
    }
    private boolean validateEmail(){
        String emailInput =Signup_Email.getEditableText().toString().trim();//have error here
        if(emailInput.isEmpty()){
            Signup_Email.setError("Field can't be empty");
            return false;
        }
        else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()){
            Signup_Email.setError("please enter a valid email address");
            return false;

        }
        else{
            Signup_Email.setError(null);
            return true;
        }


    }
    private boolean validatePassword(){
        String passwordInput = Signup_password.getText().toString().trim();

        if (passwordInput.isEmpty()) {
            Signup_password.setError("Field can't be empty");
            return false;
        } else if (!PASSWORD_PATTERN.matcher(passwordInput).matches()) {
            Signup_password.setError("Password too weak");
            return false;
        } else {
            Signup_password.setError(null);
            return true;
        }
    }
    private boolean validateName(){
        String emailInput =Signup_name.getEditableText().toString().trim();
        if(emailInput.isEmpty()){
            Signup_name.setError("Field can't be empty");
            return false;
        }

        else{
            Signup_name.setError(null);
            return true;
        }


    }
    private boolean validatephone(){
        String emailInput =Signup_phone.getEditableText().toString().trim();
        if(emailInput.isEmpty()){
            Signup_phone.setError("Field can't be empty");
            return false;
        }

        else{
            Signup_phone.setError(null);
            return true;
        }


    }
    public void confirmInput() {
        if (!validateEmail()  | !validatePassword() | !validatephone() | !validateName()) {
            return;
        }
        openhomepage();

        String input = "Email: " + Signup_Email.getText().toString();
        input += "\n";

        input += "Password: " + Signup_password.getText().toString();

        Toast.makeText(this, input, Toast.LENGTH_SHORT).show();
        // loginbutton.setOnClickListener(new View.OnClickListener() {

        //  @Override
        //   public void onClick(View v) {
        //     openhomepage();

        //   }
        // });
    }
    public void openhomepage() {
        Intent intent = new Intent( signup.this, HomePage.class);
        startActivity(intent);
    }

}