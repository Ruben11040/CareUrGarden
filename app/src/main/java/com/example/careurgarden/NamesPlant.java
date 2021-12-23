package com.example.careurgarden;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NamesPlant extends AppCompatActivity {

    private EditText namePlant;
    private EditText scientificnamePlant;
    private Button siguiente;

    /*
    * Mote
    * Nombre cientifico
    *
    * */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_namesplant);

        namePlant = findViewById(R.id.namePlant);
        scientificnamePlant = findViewById(R.id.scientificNamePlant);
        siguiente = findViewById(R.id.siguiente);

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(NamesPlant.this, TypePlant.class);
                //Pasar un objeto planta

                startActivity(i);
            }
        });
    }

}