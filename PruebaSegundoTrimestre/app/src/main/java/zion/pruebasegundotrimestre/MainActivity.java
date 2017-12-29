package zion.pruebasegundotrimestre;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity
{

   
   @Override
   protected void onCreate(Bundle savedInstanceState)
   {
	  super.onCreate(savedInstanceState);
	  setContentView(R.layout.activity_main);
   }
   public void IrADatos(View vista)
   {
	  Intent ActividadDeDestino = new Intent(MainActivity.this, Datos.class);
	  startActivity(ActividadDeDestino);
   }
   public void IrALista(View view)
   {
	  Intent ActividadDeDestino = new Intent(MainActivity.this, Lista.class);
	  startActivity(ActividadDeDestino);
   }
   public  void IrACambios (View view)
   {
	  Intent ActividadDeDestino = new Intent(MainActivity.this, Cambios.class);
	  startActivity(ActividadDeDestino);
   }
   
}
