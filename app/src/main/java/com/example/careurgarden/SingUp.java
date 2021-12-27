package com.example.careurgarden;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;

public class SingUp extends AppCompatActivity {
    private EditText name;
    private TextInputLayout nameTil;
    private EditText surname;
    private TextInputLayout surnameTil;
    private EditText birthday;
    private EditText email;
    private TextInputLayout emailTil;
    private EditText password;
    private TextInputLayout passwordTil;
    private EditText passwordConfirm;
    private TextInputLayout passwordConfirmTil;
    private Button createAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);

        UsersSQLiteHelper ussqlh = new UsersSQLiteHelper(this);
        SQLiteDatabase db = ussqlh.getWritableDatabase();

        name = findViewById(R.id.name);
        nameTil = findViewById(R.id.nameTil); // errores de cada uno de los campos
        surname = findViewById(R.id.surname);
        surnameTil = findViewById(R.id.surnameTil);
        birthday = findViewById(R.id.birthdate);
        email = findViewById(R.id.emailSingup);
        emailTil = findViewById(R.id.emailTil);
        password = findViewById(R.id.passwordSingup);
        passwordTil = findViewById(R.id.passwordTil);
        passwordConfirm = findViewById(R.id.passwordconfirm);
        passwordConfirmTil = findViewById(R.id.passwordconfirmTil);
        createAccount = findViewById(R.id.createAccount);
        nameTil.setErrorEnabled(true);
        surnameTil.setErrorEnabled(true);
        emailTil.setErrorEnabled(true);
        passwordTil.setErrorEnabled(true);
        passwordConfirmTil.setErrorEnabled(true);

        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SingUp.this, SingIn.class);

                nameTil.setError(null);
                surnameTil.setError(null);
                emailTil.setError(null);
                passwordTil.setError(null);
                passwordConfirmTil.setError(null);

                if (!password.getText().toString().equals(passwordConfirm.getText().toString())
                        || name.getText().toString().isEmpty()
                        || surname.getText().toString().isEmpty()
                        || birthday.getText().toString().isEmpty()
                        || email.getText().toString().isEmpty()
                        || password.getText().toString().isEmpty()
                        || passwordConfirm.getText().toString().isEmpty()) {

                    // Mostrar error del password confirm

                    if (name.getText().toString().isEmpty())
                        nameTil.setError("Introduzca el nombre");
                    if (surname.getText().toString().isEmpty())
                        surnameTil.setError("Introduzca los apellidos");
                    if (email.getText().toString().isEmpty())
                        emailTil.setError("Introduzca un email");
                    if (password.getText().toString().isEmpty())
                        passwordTil.setError("Introduzca una contraseña");
                    if (passwordConfirm.getText().toString().isEmpty())
                        passwordConfirmTil.setError("Introduzca la confirmación de la contraseña");
                    if (!password.getText().toString().equals(passwordConfirm.getText().toString()))
                        passwordConfirmTil.setError("La contraseña de confirmación no es igual a la contraseña");

                }else {

                    String e = email.getText().toString();
                    String[] args = new String[]{e};

                    Cursor cursor = db.rawQuery("SELECT email FROM Users WHERE email = ?", args);

                    if (db != null || cursor.moveToFirst()) {

                        // TODO mensaje de error en el email
                        emailTil.setError("Este email ya se encuentra registrado");

                    } else {
                        //Insertamos los datos en la tabla Users

                        ContentValues cv = new ContentValues();
                        cv.put("name", name.getText().toString());
                        cv.put("surname", surname.getText().toString());
                        cv.put("birthday", birthday.getText().toString());
                        cv.put("email", email.getText().toString());
                        cv.put("password", password.getText().toString());

                        //db.execSQL("INSERT INTO Users ( name, surname, birthday, email, password ) VALUES ('" + name + "', '" + surname + "','" + birthdate + "','" + email + "','" + password + "') ");

                        db.insert("Users", null, cv);
                        db.close();


                        startActivity(intent);


                    }
                }
            }
        });
    }
}