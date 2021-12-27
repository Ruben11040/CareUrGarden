package com.example.careurgarden;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class HeightPlant extends AppCompatActivity {

    private Button create;
    private TextView txtHight;
    private SeekBar seekBar;

    /*
    *   Spinner en centimertros
    * */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heightplant);

        txtHight = findViewById(R.id.txtHight);
        seekBar = findViewById(R.id.seekbar);
        create = findViewById(R.id.create);

        seekBar.setProgress(0);
        seekBar.setMax(1000);

        seekBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {

                    //hace un llamado a la perilla cuando se arrastra
                    @Override
                    public void onProgressChanged(SeekBar seekBar,
                                                  int progress, boolean fromUser) {
                        txtHight.setText(String.valueOf(progress)+" cm");
                    }

                    //hace un llamado  cuando se toca la perilla
                    public void onStartTrackingTouch(SeekBar seekBar) {
                    }

                    //hace un llamado  cuando se detiene la perilla
                    public void onStopTrackingTouch(SeekBar seekBar) {
                    }
                });

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO pasar el valor de la altura y crear la planta añadiendola a tu jardín correspondiente
                Intent i = new Intent(HeightPlant.this, List.class);
                //Pasar un objeto planta

                startActivity(i);
            }
        });
    }
}