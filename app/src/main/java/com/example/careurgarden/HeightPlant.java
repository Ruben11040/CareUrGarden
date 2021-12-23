package com.example.careurgarden;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HeightPlant extends AppCompatActivity {

    private Button siguiente;
    /*
    *   Spinner en centimertros
    * */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heightplant);

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HeightPlant.this, List.class);
                //Pasar un objeto planta

                startActivity(i);
            }
        });
    }
}