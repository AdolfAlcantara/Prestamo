package com.example.adolfalcantara.prestamos;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etmonto,ettiempo;
    ImageButton botonAuto,botonVivienda,botonPersonal;

    int tiempo;
    double monto;
    String tipo;

    Intent intent;
    final static String MONTO = "Cantidad del prestamo";
    final static String TIEMPO = "Cantidad de tiempo";
    final static String TIPO = "Tipo de prestamo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etmonto = (EditText)findViewById(R.id.etMonto);
        ettiempo = (EditText) findViewById(R.id.etTiempo);
        botonAuto = (ImageButton) findViewById(R.id.ibAuto);
        botonVivienda = (ImageButton) findViewById(R.id.ibVivienda);
        botonPersonal = (ImageButton) findViewById(R.id.ibPersonal);

        addListenerOnButton(botonAuto);
        addListenerOnButton(botonVivienda);
        addListenerOnButton(botonPersonal);

        monto = Double.parseDouble(etmonto.getText().toString());
        tiempo = Integer.parseInt(ettiempo.getText().toString());

        intent = new Intent(this,InformationActivity.class);
        intent.putExtra(MONTO,monto);
        intent.putExtra(TIEMPO,tiempo);
    }

    public void vivienda(View view) {
        if(monto>5000 & tiempo!=0) {
            tipo = "vivienda";
            intent.putExtra(TIPO, tipo);
            startActivity(intent);
        }else{
            Toast.makeText(this,"Debe ingresar monto y años",Toast.LENGTH_LONG).show();
        }
    }

    public void auto(View view) {
        if(monto>5000 & tiempo!=0){
            tipo = "auto";
            intent.putExtra(TIPO,tipo);
            startActivity(intent);
        }else{
            Toast.makeText(this,"Debe ingresar monto y años",Toast.LENGTH_LONG).show();
        }
    }

    public void personal(View view) {
        if(monto>5000 & tiempo!=0){
            tipo = "personal";
            intent.putExtra(TIPO,tipo);
            startActivity(intent);
        }else{
            Toast.makeText(this,"Debe ingresar monto y años",Toast.LENGTH_LONG).show();
        }
    }

    public void addListenerOnButton(ImageButton b) {



        b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this,"ImageButton is clicked!", Toast.LENGTH_SHORT).show();

            }

        });

    }
}
