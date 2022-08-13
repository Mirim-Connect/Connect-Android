package com.example.connect_android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;


public class Login extends AppCompatActivity {
    EditText email_text;
    EditText password_text;
    Button login_btn;
    Button siqnup_btn;

    private FirebaseAuth mAuth;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email_text = findViewById(R.id.email_text);
        password_text = findViewById(R.id.password_text);
        login_btn = findViewById(R.id.login_btn);
        siqnup_btn = findViewById(R.id.siqnup_btn);

        siqnup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(Login.this, SignUp.class);
                startActivity(in);
            }
        });

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userLogin();
            }

            private void userLogin() {
            }
        });
    }
}
