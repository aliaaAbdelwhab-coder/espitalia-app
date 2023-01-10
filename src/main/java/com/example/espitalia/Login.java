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

public class Login extends AppCompatActivity {
    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    "(?=.*[0-9])" +         //at least 1 digit
                    "(?=.*[a-z])" +         //at least 1 lower case letter
                    "(?=.*[A-Z])" +         //at least 1 upper case letter
                  //  "(?=.*[a-zA-Z])" +      //any letter
                    "(?=.*[@#$%^&+=])" +    //at least 1 special character
                    "(?=\\S+$)" +           //no white spaces
                    ".{6,}" +               //at least 4 characters
                    "$");
    private Button loginbutton;
    Button Login;

    EditText Login_Email,Password;
    Button Login_bu;
    TextView loginback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Login_Email = findViewById(R.id.loginButtonEmail);
        Password = findViewById(R.id.loginbuttonPassword);
        Login_bu = findViewById(R.id.loginbutton);

        loginbutton = (Button) findViewById(R.id.loginbutton);

        Login = findViewById(R.id.loginbutton);

        loginback = findViewById(R.id.textView4);
        loginback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this,choose.class);
                startActivity(intent);
            }
        });

    }

    private boolean validateEmail(){
        String emailInput =Login_Email.getEditableText().toString().trim();//have error here
        if(emailInput.isEmpty()){
            Login_Email.setError("Field can't be empty");
            return false;
        }
        else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()){
            Login_Email.setError("please enter a valid email address");
            return false;

        }
        else{
            Login_Email.setError(null);
            return true;
        }


    }
    private boolean validatePassword(){
        String passwordInput = Password.getText().toString().trim();

        if (passwordInput.isEmpty()) {
            Password.setError("Field can't be empty");
            return false;
        } else if (!PASSWORD_PATTERN.matcher(passwordInput).matches()) {
            Password.setError("Password too weak");
            return false;
        } else {
            Password.setError(null);
            return true;
        }
    }
    public void confirmInput(View v) {
        if (!validateEmail()  | !validatePassword()) {
            return;
        }
        openhomepage();

        String input = "Email: " + Login_Email.getText().toString();
        input += "\n";

       input += "Password: " + Password.getText().toString();

        Toast.makeText(this, input, Toast.LENGTH_SHORT).show();
       // loginbutton.setOnClickListener(new View.OnClickListener() {

          //  @Override
         //   public void onClick(View v) {
           //     openhomepage();

         //   }
       // });
    }

    public void openhomepage() {
        Intent intent = new Intent(Login.this, HomePage.class);
        startActivity(intent);
    }

}