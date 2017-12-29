package zionapps.pruebaprimertrimestre;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    int ContadorL;
    int CantIguales;
    int CantCheckBoxTildado;
    int CantTextoMasCorto = 999999;
    int CantIgnorados;

    /*
    La mecánica es la siguiente:

- El usuario ingresa textos en los dos campos, tilda o no el checkbox, y presiona el botón.

- Los datos ingresados se procesan de acuerdo a la consigna indicada a continuación, y los dos campos de texto deben vaciarse para un nuevo ingreso.

- Si alguno de los dos campos de texto (o los dos) no se completó, el ingreso no debe procesarse, mostrando un mensaje de error, de la forma que quieran.

- Cuando el usuario ingresa la palabra “Fin” en alguno de los dos campos (o en ambos), se termina el procesamiento, y se muestran los resultados.

Es decir que el usuario ingresa algo en los EditText, tilda o no el checkbox, y presiona el botón. Ingresa otra cosa, y vuelve a presionar.
Y así hasta que se aburre e ingresa un “Fin” en alguno de los EditText (o en los dos, si es que está muy aburrido).
Recién entonces se deben mostrar, en una nueva Activity, los siguientes resultados:*/

public void CheckboxChequeado(View view)
    {
    }

    public void Boton (View VistaBoton)
    {
        EditText Texto1 = (EditText)findViewById(R.id.Texto1);
        EditText Texto2 = (EditText)findViewById(R.id.Texto2);
        String StringTexto1 = Texto1.getText().toString();
        String StringTexto2 = Texto2.getText().toString();
        CheckBox Checky = (CheckBox)findViewById(R.id.Checkbox);

        if(StringTexto1.toLowerCase().contains("fin")|| StringTexto2.toLowerCase().contains("fin"))
        {
           if(StringTexto1.toLowerCase().contains("fin")&& StringTexto2.toLowerCase().contains("fin"))
           {
               Toast Aburrido = Toast.makeText(this, "Veo que estás muy aburrido, Leo, qué triste :(", Toast.LENGTH_SHORT);
               Aburrido.show();
           }
            Intent ActividadResultado = new Intent(MainActivity.this, ActivityResultados.class);
            Bundle Variables = new Bundle();
            Variables.putInt("ContadorL", ContadorL);
            Variables.putInt("CantIguales", CantIguales);
            Variables.putInt("CantCheckboxTildado", CantCheckBoxTildado);
            Variables.putInt("CantTextoMasCorto", CantTextoMasCorto);
            Variables.putInt("CantIgnorados", CantIgnorados);
            ActividadResultado.putExtras(Variables);
            startActivity(ActividadResultado); //Leo, cuando entregué esto u}ya eran las doce y no funcoinaba. Muchas gracias por dejarme terminar igual. Sos grande leolob
        }
        else
        {
            if (StringTexto1.length() == 0 || StringTexto2.length() == 0)
            {
                Toast MensajeError = Toast.makeText(this, "Leo, te aviso que no se va a procesar nada porque alguno, o los dos campos, están vacíos", Toast.LENGTH_SHORT);
                MensajeError.show();
                CantIgnorados++;
            }
            else
            {
                PuntoA(StringTexto1, StringTexto2);
                PuntoB(StringTexto1, StringTexto2);
                PuntoC(Checky);
                PuntoD(StringTexto1, StringTexto2, Checky);
                Texto1.setText("");
                Texto2.setText("");
            }
        }
    }
    public void PuntoA(String Texto1, String Texto2)
    {
        //La cantidad de veces en la que alguno de los textos ingresados tenía alguna “L”
        char LetraAContar = 'l';
        if(Texto1.indexOf(LetraAContar) != -1)
        {
            ContadorL++;
        }
        if(Texto2.indexOf(LetraAContar) != -1)
        {
            ContadorL++;
        }
    }
    public void PuntoB(String Texto1, String Texto2)
    {
        //La cantidad de veces en la que los dos EditText tenían exactamente el mismo contenido.
        if(Texto1 == Texto2)
        {
            CantIguales++;
        }
    }
    public void PuntoC(CheckBox Checky)
    {
        //La cantidad de veces que se presionó el botón de procesamiento estando el CheckBox tildado.
        if (Checky.isChecked())
        {
            CantCheckBoxTildado++;
        }
    }
    public void PuntoD(String Texto1, String Texto2, CheckBox Checky)
    {
        //La cantidad de caracteres del texto más corto (entre todos los ingresados), solo tomando en cuenta los ingresos en los que CheckBox NO estuvo tildado.
        int CantTexto1 = Texto1.length();
        int CantTexto2 = Texto2.length();

        if (Checky.isChecked() == false)
        {
            if(CantTexto1 < CantTextoMasCorto)
            {
                CantTextoMasCorto = Texto1.length();
            }
            if(CantTexto2 < CantTextoMasCorto)
            {
                CantTextoMasCorto = Texto2.length();
            }
        }
    }
}
