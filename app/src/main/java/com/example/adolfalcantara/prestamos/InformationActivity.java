package com.example.adolfalcantara.prestamos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Calendar;

public class InformationActivity extends AppCompatActivity {

    private int tiempo;
    private double monto;
    private double tasa;
    private String tipo;

    TextView tvMontoSolicitado,tvTiempo,tvFinPago,tvMontoAjust,tvMontoInt,tvCuota,tvTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        tvMontoSolicitado = (TextView) findViewById(R.id.tvMonto);
        tvTiempo = (TextView) findViewById(R.id.tvTiempo);
        tvFinPago = (TextView) findViewById(R.id.tvFinPago);
        tvMontoAjust = (TextView) findViewById(R.id.tvMontoAjustado);
        tvMontoInt = (TextView) findViewById(R.id.tvMontoInteres);
        tvCuota = (TextView) findViewById(R.id.tvCuota);
        tvTotal = (TextView) findViewById(R.id.tvTotal);

        Intent i = getIntent();
        monto = i.getDoubleExtra(MainActivity.MONTO,0.0);
        tiempo = i.getIntExtra(MainActivity.TIEMPO,0);
        tipo = i.getStringExtra(MainActivity.TIPO);

        tvMontoSolicitado.setText(monto+"");
        tvTiempo.setText(tiempo+"");
        Calendar date = Calendar.getInstance();
        date.add(Calendar.YEAR,tiempo);
        tvFinPago.setText(date.toString());
        double extra,tasa;
        switch(tipo){
            case "auto":
                extra = monto*0.3;
                tasa=0.25;
                break;
            case "vivienda":
                extra =3000;
                tasa = 0.1;
                break;
            default:
                extra=0;
                tasa =0.35;
        }
        double ma = monto+extra;
        double mi = monto*tasa*tiempo;
        tvMontoAjust.setText(ma+"");
        tvMontoInt.setText(mi+"");
        tvCuota.setText(((monto+ma+mi)/(tiempo*12))+"");
        tvTotal.setText((ma+mi)+"");


    }
}
