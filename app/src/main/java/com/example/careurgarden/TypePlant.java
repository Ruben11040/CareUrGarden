package com.example.careurgarden;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TypePlant extends AppCompatActivity {

    private Button siguiente;
    /*
    * Tipo de planta secano o regadío
    * */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_typeplant);

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TypePlant.this, HeightPlant.class);
                //Pasar un objeto planta

                startActivity(i);
            }
        });
    }
}