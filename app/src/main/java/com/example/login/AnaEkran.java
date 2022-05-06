package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AnaEkran extends AppCompatActivity {
    private Button buttonCikisYap;
    private Button buttonSarkiDinle;
    private TextView textViewCikti;
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;
    private String username;
    private String password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ana_ekran);
        buttonSarkiDinle = (Button) findViewById(R.id.buttonMuzikDinle);
        buttonCikisYap = (Button) findViewById(R.id.buttonCikisYap);
        textViewCikti = (TextView) findViewById(R.id.textViewCikti);

        sp=getSharedPreferences("GirisBilgi",MODE_PRIVATE);
        editor=sp.edit();

        username = sp.getString("username", "kullanıcı adı yok");
        password = sp.getString("password","şifre yok");

        textViewCikti.setText("Username: "+username+" Password: "+password);

        buttonCikisYap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AnaEkran.this,MainActivity.class));
            }
        });
        buttonSarkiDinle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AnaEkran.this,MusicList.class));
            }
        });
    }
}