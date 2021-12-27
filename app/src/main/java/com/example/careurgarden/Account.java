package com.example.careurgarden;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Account extends AppCompatActivity {

    //TODO pasar el email del inicio de sesión y extraer los valores
    private TextView tvName;
    private TextView tvSurname;
    private TextView tvBirthday;
    private TextView tvEmail;
    private String name;
    private String surname;
    private String birthday;
    private String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        UsersSQLiteHelper ussqlh = new UsersSQLiteHelper(this);
        SQLiteDatabase db = ussqlh.getReadableDatabase();

        String [] args = new String [] {"usuario"};
        Cursor cursor = db.rawQuery("SELECT name,surname, birthday, email FROM Users WHERE email = ? ", args);

        if (db != null) {
            if (cursor.moveToFirst()) {
                //Recorremos el cursor hasta que no haya más registros

                do {
                    name= cursor.getString(0);
                    surname = cursor.getString(1);
                    birthday = cursor.getString(2);
                    email = cursor.getString(3);

                } while(cursor.moveToNext());
            }
        }
        //entro en la base de datos y sustituyo los valores
        tvName.setText(name);
        tvSurname.setText(surname);
        tvBirthday.setText(birthday);
        tvEmail.setText(email);

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}