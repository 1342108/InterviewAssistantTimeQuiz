package com.example.android.interviewassistant;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.*;


public class Login extends AppCompatActivity {

    public EditText etUsername;
    public EditText etPassword;
    public TextView tvLoginFail;

    public static String welcomeUsername = "";
    public int success = 0; // 1 is success, 2 is wrong email/password, 3 is wrong email and password/don't exist on db
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        final TextView tvRegisterLink = (TextView) findViewById(R.id.tvRegisterLink);
        final Button bLogin = (Button) findViewById(R.id.bSignIn);
        tvLoginFail = (TextView) findViewById(R.id.tvLoginFail);

        tvRegisterLink.setOnClickListener(v -> {
            Intent registerIntent = new Intent(Login.this, Register.class);
            Login.this.startActivity(registerIntent);
        });

        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new LoginRequest().execute();
                if(success == 1)
                {
                    Intent intent = new Intent(Login.this, Homepage.class);
                    Toast.makeText(Login.this,"Welcome, "+welcomeUsername+"!",Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }
                else if(success == 2)
                {
                    Toast.makeText(Login.this,"Wrong email or password",Toast.LENGTH_SHORT).show();
                }

                else
                {
                    //Toast.makeText(Login.this,"No match for what you have entered. Make sure you have registered by clicking on 'Register Here'",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private class LoginRequest extends AsyncTask<String,String,String>
    {

        // What user entered
        String username = etUsername.getText().toString();
        String password = etPassword.getText().toString();

        // What values are in the database
        String dbUsername = "";
        String dbPassword = "";
        @Override
        protected String doInBackground(String... params) {
            try
            {
                Class.forName("com.mysql.jdbc.Driver");

                Connection connection = DriverManager.getConnection("jdbc:mysql://134.83.83.25:47000/grp2_interview_assistant", "l2grp2", "l2grp2");

                Statement statement = connection.createStatement();

                ResultSet resultSet = statement.executeQuery("SELECT * FROM PROFILE");

                while(resultSet.next())
                {
                    dbUsername = resultSet.getString("username");
                    dbPassword = resultSet.getString("password");

                    if(username.equals(dbUsername) && password.equals(dbPassword))
                    {
                        success = 1;
                        welcomeUsername = username;
                    }
                    else if( !(username.equals(dbUsername) || password.equals(dbPassword)) )
                    {
                        success = 2;
                    }
                    else
                    {
                        success = 3;
                    }
                }
                connection.close();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            return null;
        }
    }
}