package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editTextId, editTextPassword;
    private Button buttonGiris;
    private Button buttonSignUp;
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextId=(EditText) findViewById(R.id.editTextId);
        editTextPassword=(EditText)  findViewById(R.id.editTextPassword);
        buttonGiris=(Button) findViewById(R.id.buttonGiris);
        buttonSignUp=(Button) findViewById(R.id.buttonSıgnUp);

        sp=getSharedPreferences("GirisBilgi",MODE_PRIVATE);
        editor=sp.edit();

        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,SignUp.class));
            }
        });
        buttonGiris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editTextId.getText().toString().equals("admin") && editTextPassword.getText().toString().equals("12345")){
                    editor.putString("username",editTextId.getText().toString());
                    editor.putString("password",editTextPassword.getText().toString());
                    editor.commit();

                    startActivity(new Intent(MainActivity.this,AnaEkran.class));
                }else{
                    Toast.makeText(getApplicationContext(), "Hatalı Giriş Yaptınız",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}