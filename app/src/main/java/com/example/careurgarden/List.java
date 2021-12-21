package com.example.careurgarden;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class List extends AppCompatActivity {

    private ListView listView;
    private int imagenView;
    private String name;
    private String scientificName;
    private ArrayList<Plant> plantsList = new ArrayList();

    /*
    Tiene que entrar en el array de la base de datos
    solo te entra en esta actividad y te crea esta lista
    */

    private Plant[] data = new Plant[]{
        new Plant("Helianthus annuus", "Girasol",R.drawable.girasol,"Regadio",56),
        new Plant("Helianthus annuus", "Girasol",R.drawable.girasol,"Regadio",56),
        new Plant("Helianthus annuus", "Girasol",R.drawable.girasol,"Regadio",56),
        new Plant("Helianthus annuus", "Girasol",R.drawable.girasol,"Regadio",56)
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        name = "";
        scientificName = "";
        imagenView = 0;
        listView = findViewById(R.id.listView);

        AdaptadorPlant adaptador =
                new AdaptadorPlant(this, data);

        listView.setAdapter(adaptador);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {

                imagenView=((Plant) a.getItemAtPosition(position)).getImage();
                name=((Plant) a.getItemAtPosition(position)).getName();
                scientificName=((Plant) a.getItemAtPosition(position)).getScientificName();

                //Alternativa 1:
                try { //por si pinchamos en la cabecera, que da excepcion

                    for (int i = 0; i < a.getCount(); i++){
                        if(position == i){
                            a.getChildAt(i).setBackgroundResource(R.color.purple_200);
                        }else{
                            a.getChildAt(i).setBackgroundColor(Color.WHITE);
                        }

                    }
                }
                catch(Exception e){}

            }
        });


    }


    class AdaptadorPlant extends ArrayAdapter<Plant> {

        public AdaptadorPlant(Context context, Plant[] data) {
            super(context, R.layout.list_plantas, data);
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.list_plantas, null);

            ImageView icon=item.findViewById(R.id.list_image);
            icon.setImageResource(data[position].getImage());

            TextView lblName = item.findViewById(R.id.name);
            lblName.setText(data[position].getName());

            TextView lblScientificName = item.findViewById(R.id.scientificName);
            lblScientificName.setText(data[position].getScientificName());

            return(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Revisar menu
        switch (item.getItemId()) {
            case R.id.MnuOpc3:

                return true;
            case R.id.SubMnuOpc1:
                //Cuenta

                return true;
            case R.id.SubMnuOpc2:
                //Acerca de
                Intent intent =  new Intent(List.this, About.class);
                startActivity(intent);
                return true;
            case R.id.SubMnuOpc3:
                //Cerrar sesion
                Intent in =  new Intent(List.this, Singin.class);
                startActivity(in);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}