package com.example.careurgarden;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;

public class SingIn extends AppCompatActivity {
    private Button signin;
    private Button signup;
    private EditText email;
    private EditText password;
    private TextInputLayout emailTil;
    private TextInputLayout passwordTil;
    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singin);

        signin = findViewById(R.id.btnSingin);
        signup = findViewById(R.id.btnSingup);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        emailTil = findViewById(R.id.emailTil);
        passwordTil = findViewById(R.id.passwordTil);
        emailTil.setErrorEnabled(true);
        passwordTil.setErrorEnabled(true);

        UsersSQLiteHelper ussqlh = new UsersSQLiteHelper(this);
        SQLiteDatabase db = ussqlh.getReadableDatabase();

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String e = email.getText().toString();
                String p = password.getText().toString();
                String [] args = new String [] {e,p};
                emailTil.setError(null);
                passwordTil.setError(null);

                cursor = db.rawQuery("SELECT email, password FROM Users WHERE email = ? AND password = ?", args);

                if (db != null) {
                    if (cursor.moveToFirst()) {
                        //Recorremos el cursor hasta que no haya más registros

                        do {
                            String email= cursor.getString(0);
                            System.out.println(email);
                            System.out.println(e);
                            String password = cursor.getString(1);
                            System.out.println(password);
                            System.out.println(p);

                            if(e == email && p == password ){
                                Intent intent = new Intent(SingIn.this, List.class);
                                startActivity(intent);
                            }else {
                                if(e != email )
                                    emailTil.setError("Introduzca el email correspondiente");
                                if(p != password )
                                    passwordTil.setError("Introduzca la contraseña correcta");
                            }
                        } while(cursor.moveToNext());
                    }
                }
                
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  new Intent(SingIn.this, SingUp.class);
                startActivity(intent);
            }
        });
    }
}