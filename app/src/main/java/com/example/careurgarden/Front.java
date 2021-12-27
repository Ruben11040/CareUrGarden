package com.example.careurgarden;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class Front extends AppCompatActivity {
    private Button letBegin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front);

        UsersSQLiteHelper ussqlh = new UsersSQLiteHelper(this);
        SQLiteDatabase db = ussqlh.getWritableDatabase();

        letBegin = findViewById(R.id.letBegin);

        letBegin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (db != null) {
                    String name = "Usuario";
                    String surname = "Surname";
                    String birthday = "11/04/02";
                    String email = "usuario";
                    String password = "user1";
                    ArrayList<Plant> garden = new ArrayList<>();

                    ContentValues cv = new ContentValues();
                    cv.put("name", name);
                    cv.put("surname", surname);
                    cv.put("birthday", birthday);
                    cv.put("email", email);
                    cv.put("password", password);
                    cv.put("garden", String.valueOf(garden));

                    //Insertamos los datos en la tabla Usuarios
                    //db.insert("Users", null, cv);

                    //Cerramos la base de datos
                    db.close();
                }

                Intent intent = new Intent(Front.this, SingIn.class);
                startActivity(intent);
            }
        });
    }
}