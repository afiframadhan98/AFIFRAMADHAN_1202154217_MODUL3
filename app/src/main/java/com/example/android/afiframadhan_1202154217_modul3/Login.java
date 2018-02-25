package com.example.android.afiframadhan_1202154217_modul3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText username, password;        // Membuat variabel EditText untuk username dan password
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);        // Menampilkan layout activity_login.xml
        username = (EditText) findViewById(R.id.et_username);   // Assign variabel dengan id EditText username yang ada pada layout
        password = (EditText) findViewById(R.id.et_password);   // Assign variabel dengan id EditText password yang ada pada layout
    }

    public void onLogin(View view) {

        if (username.getText().toString().equals("EAD") && password.getText().toString().equals("MOBILE")) {
            // Membuat dan menampilkan Toast Login berhasil
            Toast.makeText(getApplicationContext(),"Login Successfully", Toast.LENGTH_SHORT).show();
            // Menuju MainActivity.class
            Intent intent = new Intent(this, MainActivity.class);
            // Menjalankan Intent
            startActivity(intent);
        } else {
            // Membuat dan menampilkan Toast Gagal login
            Toast.makeText(getApplicationContext(),"Username or Password has wrong, please Try Again", Toast.LENGTH_SHORT).show();
        }
    }
}
