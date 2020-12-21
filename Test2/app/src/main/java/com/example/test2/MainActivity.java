package com.example.test2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView Username;
    TextView Password;
    TextView Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Username = findViewById(R.id.txt_UserName);
        Password = findViewById(R.id.txt_Password);
        Login = (Button)findViewById(R.id.btn_Login);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Username.getText().toString(), Password.getText().toString());
            }
        });
    }


    private void validate (String U_name, String U_pass)
    {
        if ((U_name != "")  && (U_pass != "")) {
            if ((U_name == "user1") && (U_pass == "password1")) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
            else {
                Toast.makeText(getApplicationContext(), "Please enter a valid username and password", Toast.LENGTH_LONG).show();
            }
        }
        else {
            Toast.makeText(getApplicationContext(), "Please enter a username and password", Toast.LENGTH_LONG).show();
        }
    }



}