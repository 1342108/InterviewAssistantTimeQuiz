package com.example.android.interviewassistant;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.*;


public class Register extends AppCompatActivity {
    private EditText etAge;
    private EditText etName;
    private EditText etUsername;
    private EditText etPassword;
    private Button bRegister;

    private static int registerSuccess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        etAge = (EditText) findViewById(R.id.etAge);
        etName = (EditText) findViewById(R.id.etName);
        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        bRegister = (Button) findViewById(R.id.bRegister);

        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new RegisterRequest().execute();

                Intent intent = new Intent(Register.this, Login.class);
                Register.this.startActivity(intent);

            }
        });
    }

    private class RegisterRequest extends AsyncTask<String,String,String>
    {
        String name = etName.getText().toString();
        String username = etUsername.getText().toString();
        int age = Integer.parseInt(etAge.getText().toString());
        String password = etPassword.getText().toString();

        @Override
        protected String doInBackground(String... params) {
            try
            {
                Class.forName("com.mysql.jdbc.Driver");

                Connection connection = DriverManager.getConnection("jdbc:mysql://134.83.83.25:47000/grp2_interview_assistant", "l2grp2", "l2grp2");

                Statement statement = connection.createStatement();

                String sql = "INSERT INTO PROFILE (name, username, age, password) VALUES ('"+name+"', '"+username+"', "+age+", '"+password+"')";
                statement.executeUpdate(sql);

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