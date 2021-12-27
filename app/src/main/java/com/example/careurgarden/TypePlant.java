package com.example.careurgarden;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class TypePlant extends AppCompatActivity {

    private Button siguiente;
    private String type;
    private RadioGroup typeButton;
    /*
    * Tipo de planta secano o regadío
    * */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_typeplant);

        siguiente = findViewById(R.id.siguiente);
        typeButton = findViewById(R.id.typeButton);

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(type == "Regadio") {
                    // valor a regadio
                    String r = type;
                }else{
                    //valor a secano
                    String r  = type;
                }

                Intent i = new Intent(TypePlant.this, HeightPlant.class);
                //Pasar un objeto planta

                startActivity(i);
            }
        });


        typeButton.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                //TODO meter el valor en el type de la planta
                switch(checkedId) {
                    case R.id.regadioButton:
                        type = "Regadio";
                        break;
                    case R.id.secanoButton:
                        type = "Secano";
                        break;
                }
            }
        });
    }
}