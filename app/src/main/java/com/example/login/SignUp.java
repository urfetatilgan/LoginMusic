package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUp extends AppCompatActivity {

    private EditText textViewBaslik;
    private Button buttonKayit;
    private EditText editTextSignName, editTextSignPassword,editTextPhoneNumber,editTextMail;
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        editTextSignName=(EditText) findViewById(R.id.editTextSignName);
        editTextSignPassword=(EditText) findViewById(R.id.editTextSignPassword);
        editTextPhoneNumber=(EditText) findViewById(R.id.editTextPhoneNumber);
        editTextMail=(EditText) findViewById(R.id.editTextMail);
        buttonKayit=(Button) findViewById(R.id.buttonKayit);

        sp=getSharedPreferences("KayitBilgi",MODE_PRIVATE);
        editor=sp.edit();

        buttonKayit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailsend = editTextMail.getText().toString();
                String emailsubject = editTextSignName.getText().toString() + "adlı kullanıcının uygulama kaydı.";
                String emailbody = "Kullanıcı Adı: " + editTextSignName.getText().toString() +", Şifre: "+ editTextSignPassword.getText().toString()
                        +", Mail: "+ editTextMail.getText().toString() + ", Telefon:" + editTextPhoneNumber.getText().toString();

                Intent intent = new Intent(Intent.ACTION_SEND);

                intent.putExtra(Intent.EXTRA_EMAIL, new String[] {emailsend});
                intent.putExtra(Intent.EXTRA_SUBJECT, emailsubject);
                intent.putExtra(Intent.EXTRA_TEXT, emailbody);

                intent.setType("message/822");
                startActivity(
                        Intent.createChooser(intent,"choose an Email client")
                );
                //startActivity(new Intent(SignUp.this,MainActivity.class));
            }
        });
    }
}