package com.example.maptrack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // inicializamos la variable
    EditText etSource, etDestination;
    Button btTrack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Asignamos la variable
        etSource = findViewById(R.id.et_source);
        etDestination = findViewById(R.id.et_destination);
        btTrack = findViewById(R.id.bt_track);

        btTrack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Recibe el valor de edit text
                String sSource = etSource.getText().toString().trim();
                String sDestination = etDestination.getText().toString().trim();

                // Revisa la condicion
                if (sSource.equals("")&& sDestination.equals("")) {
                    //cuando ambas tienen su valor en blanco
                    Toast.makeText(getApplicationContext(), "Enter both location", Toast.LENGTH_SHORT).show();

                }
                else
                {
                    //cuando ambosvalores se llenan en blanco
                    // vista
                    DisplayTrack(sSource,sDestination);



                }

            }
        });
    }
    private void DisplayTrack(String sSource, String sDestination){
        // si el dispositivo no tiene un tapete instalado, redirigirlo a Play Store
        try {

            // cuando Google Mal está instalado
            // inicializamos uri
            Uri uri = Uri.parse("https://www.google.co.in/maps/dir/" + sSource + "/" + sDestination);
            // Inicializamos intent en la vista de acción
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            // establecer paquete
            intent.setPackage("com.google.android.apps.maps");
            // establecemos la bandera
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            // Iniciamos la actividad
            startActivity(intent);
        }
        catch (ActivityNotFoundException e){
            // donde google maps no esta instalado
            // Inicializamos uri
            Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=com.google.android.apps.maps");
            // Inicializamos intent en la vista de acción
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            // establecer paquete
            intent.setPackage("com.google.android.apps.maps");
            // establecemos la bandera
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            // Iniciamos la actividad
            startActivity(intent);


        }
    }
}