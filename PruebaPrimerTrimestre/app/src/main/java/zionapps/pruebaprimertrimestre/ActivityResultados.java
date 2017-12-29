package zionapps.pruebaprimertrimestre;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;

import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Administrador on 30/5/2017.
 */

public class ActivityResultados extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);
        TextView PuntoA = (TextView)findViewById(R.id.PuntoA);
        TextView PuntoB = (TextView)findViewById(R.id.PuntoB);
        TextView PuntoC = (TextView)findViewById(R.id.PuntoC);
        TextView PuntoD = (TextView)findViewById(R.id.PuntoD);
        TextView PuntoE = (TextView)findViewById(R.id.PuntoE);

        Bundle Variables = getIntent().getExtras();
        int ResultadoPuntoA = Variables.getInt("ContadorL");
        int ResultadoPuntoB = Variables.getInt("CantIguales");
        int ResultadoPuntoC = Variables.getInt("CantCheckboxTildado");
        int ResultadoPuntoD = Variables.getInt("CantTextoMasCorto");
        int ResultadoPuntoE = Variables.getInt("CantIgnorados");

        PuntoA.setText("Punto A: La cantidad de letras 'L' fue de "+ ResultadoPuntoA + " veces");
        PuntoB.setText("Punto B: La cantidad de veces que los textos fueron iguales fue" + ResultadoPuntoB + " veces");
        PuntoC.setText("Punto C: La cantidad de veces que el se recibieron datos con el Checkbox tildado fueron " + ResultadoPuntoC + " veces");
        PuntoD.setText("Punto D: La cantidad de caracteres del texto más corto ingresado fue " + ResultadoPuntoD + " caracteres");
        PuntoE.setText("Punto E: La cantidad de veces que se dejó uno o ambos espacios sin texto fue de " + ResultadoPuntoE + " veces");

    }
}
