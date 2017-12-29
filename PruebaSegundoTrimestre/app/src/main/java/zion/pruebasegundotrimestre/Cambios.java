package zion.pruebasegundotrimestre;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

/**
 * Created by Administrador on 22/8/2017.
 */

public class Cambios extends AppCompatActivity
{
   EditText Texto1;
   EditText Texto2;
   String Texto1Posta;
   String Texto2Posta;
   @Override
   protected void onCreate(Bundle savedInstanceState)
   {
	  super.onCreate(savedInstanceState);
	  setContentView(R.layout.cambios);
	  Texto1 = (EditText)findViewById(R.id.TextoFragment1);
	  Texto2 = (EditText)findViewById(R.id.TextoFragment2);
   }
   private void MostrarMasGrande()
   {
	  Texto1Posta = Texto1.toString();
	  Texto2Posta = Texto2.toString();
	  
   
   }
}
