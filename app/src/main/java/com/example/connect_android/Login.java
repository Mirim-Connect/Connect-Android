package com.example.connect_android;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
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
                String email = email_text.getText().toString().trim();
                String password = password_text.getText().toString().trim();

                if(email.isEmpty()){
                    email_text.setError("이메일은 반드시 입력해야합니다.");
                    email_text.requestFocus();
                    return;
                }

                if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    email_text.setError("유효한 이메일을 입력하세요. ");
                    email_text.requestFocus();
                    return;
                }

                if(password.length() < 10){
                    password_text.setError("비밀번호는 최소 10자리 입니다.");
                    password_text.requestFocus();
                    return;
                }

                mAuth = FirebaseAuth.getInstance();

                mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()){
                            Intent in = new Intent(Login.this, choose_menu.class);
                            startActivity(in);
                        }else{
                            Toast.makeText(getApplicationContext(), "로그인을 실패하였습니다.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}
