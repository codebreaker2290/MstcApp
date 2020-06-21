package com.example.mstcapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private EditText mUserEmail,mUserPassword;
    private Button mUserLogin,mForgotPassword;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //INITIALIZING VIEWS
        mUserEmail= findViewById(R.id.loginEmail);
        mUserPassword=findViewById(R.id.loginPassword);
        mUserLogin=findViewById(R.id.btn_Login);
        mForgotPassword=findViewById(R.id.forgotPassword);

        FirebaseApp.initializeApp(getApplicationContext());
        mAuth=FirebaseAuth.getInstance();

       /* if(mAuth.getCurrentUser()!=null){
            Toast.makeText(LoginActivity.this, "User already logged in", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        }*/

        mUserLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email=mUserEmail.getText().toString().trim();
                String password=mUserPassword.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    mUserEmail.setError("Email is Required.");
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    mUserPassword.setError("Password is Required.");
                    return;
                }

                if(password.length()<6){
                    mUserPassword.setError("Password Must be >= 6 Characters");
                    return;
                }

                //AUTHENTICATING USERS

                mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        }
                        else{
                            Toast.makeText(LoginActivity.this, "Unable to login" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}