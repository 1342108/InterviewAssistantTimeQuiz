package com.example.android.loginregister;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivityLogin extends AppCompatActivity implements View.OnClickListener {

    private Button bSignIn;
    private TextView registerLink;
    private EditText etEmail;
    private EditText etPassword;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);


        mAuth = FirebaseAuth.getInstance();
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        bSignIn = (Button) findViewById(R.id.bSignIn);
        registerLink = (TextView) findViewById(R.id.tvRegister);

        bSignIn.setOnClickListener(this);

        registerLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(MainActivityLogin.this, MainActivityRegister.class);
                startActivity(registerIntent);
            }
        });
    }

    public void signIn() {
        final String email = etEmail.getText().toString().trim();
        final String password = etPassword.getText().toString().trim();

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            finish();
                            Toast.makeText(MainActivityLogin.this, "Signed in",Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(MainActivityLogin.this, UserArea.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(MainActivityLogin.this, "Failure to sign in",Toast.LENGTH_LONG).show();
                        }
                    }
                });

    }

    public void onClick(View view) {
        if(view == bSignIn) {
            signIn();
        }
    }
}
