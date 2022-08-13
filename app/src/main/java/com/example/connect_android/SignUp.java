package com.example.connect_android;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;


public class SignUp extends AppCompatActivity {

    private FirebaseAuth mAuth;
    EditText email_text;
    EditText password_text;
    EditText nickname_text;
    Button siqn_up_btn;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mAuth = FirebaseAuth.getInstance();

        siqn_up_btn = findViewById(R.id.siqn_up_btn);
//        siqn_up_btn.setOnClickListener(this);
        email_text = (EditText) findViewById(R.id.email_text);
        password_text = (EditText) findViewById(R.id.password_text);
        nickname_text = (EditText) findViewById(R.id.nickname_text);

        siqn_up_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUser();
            }
        });
    }
//    @Override
//    public void onClick(View v) {
//        switch (v.getId()){
//            case R.id.siqn_up_btn:
//                registerUser();
//                break;
//        }
//    }

    private void registerUser() {
        String email = email_text.getText().toString().trim();
        String pw = password_text.getText().toString().trim();
        String name = nickname_text.getText().toString().trim();

        if(email.isEmpty()){
            email_text.setError("이메일은 필수로 입력해야합니다. ");
            email_text.requestFocus();
            return;
        }
        if(pw.isEmpty()){
            password_text.setError("비밀번호는 필수로 입력해야합니다. ");
            password_text.requestFocus();
            return;
        }
        if(name.isEmpty()){
            nickname_text.setError("닉네임은 필수로 입력해야합니다. ");
            nickname_text.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            email_text.setError("유효한 이메일을 입력하세요!");
            email_text.requestFocus();
            return;
        }

        if(pw.length()<10){
            password_text.setError("비밀번호는 최소 10자리 입니다.");
            password_text.requestFocus();
            return;
        }

        mAuth.createUserWithEmailAndPassword(email, pw)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            User user = new User(name, email);

                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful()){
                                        Toast.makeText(getApplicationContext(), "회원가입이 완료되었습니다!", Toast.LENGTH_SHORT).show();
                                    }else{
                                        Toast.makeText(getApplicationContext(), "회원가입이 실패하였습니다", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                        }else{
                            Toast.makeText(getApplicationContext(), "회원가입이 실패하였습니다", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
