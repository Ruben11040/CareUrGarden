package com.example.careurgarden;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Singin extends AppCompatActivity {
    private Button signin;
    private Button signup;
    private EditText email;
    private EditText password;
    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singin);

        signin = findViewById(R.id.btnSingin);
        signup = findViewById(R.id.btnSingup);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //Cursor c = db.rawQuery(" SELECT codigo,nombre FROM Usuarios WHERE nombre='usu1' ", null);
                Intent intent =  new Intent(Singin.this, List.class);
                startActivity(intent);
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  new Intent(Singin.this, SingUp.class);
                startActivity(intent);
            }
        });
    }
}