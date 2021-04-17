package com.saifrasel.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    Button loginButton;
    EditText userName;
    EditText password;
    public String name = "";
    public String pass = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginButton = (Button) findViewById(R.id.buttonLogin);
        userName = (EditText) findViewById(R.id.editTextTextPersonName);
        password = (EditText) findViewById(R.id.editTextTextPassword);
        loginButton.setOnClickListener(this);

    }


    private boolean checkPassword(String pass,String name){
        String passwrd = pass.trim();

        if(passwrd.charAt(2) == 'w')
        {
            return true;
        }
        else if(passwrd.isEmpty() && name.isEmpty())
        {
            return  false;
        }
        return false;
    }

    private boolean checkEmpty(String pass,String name)
    {
        if((pass.isEmpty() && name.isEmpty() )|| pass.isEmpty() ||name.isEmpty())
        {
            return false;
        }
        else
        {
            return  true;
        }
    }

    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.buttonLogin :

//                Intent i = new Intent(this,NextActivity.class);
//                startActivity(i);

                if( checkEmpty(password.getText().toString(),userName.getText().toString()) && checkPassword(password.getText().toString(),userName.getText().toString()) && password.getText().toString().length()>=5){
                    Intent i = new Intent(this,NextActivity.class);
                    startActivity(i);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Login\nfailed! Enter your password again!",Toast.LENGTH_LONG).show();
                }

        }
    }
}