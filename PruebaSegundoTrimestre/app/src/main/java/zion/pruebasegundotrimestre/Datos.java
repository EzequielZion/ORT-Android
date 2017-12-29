package zion.pruebasegundotrimestre;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Administrador on 22/8/2017.
 */

public class Datos extends AppCompatActivity
{
   EditText EdtDatos;
   String Datos;
   DbHelper AccesoDb;
   SQLiteDatabase BaseDeDatosRicolina;
   
   @Override
   protected void onCreate(Bundle savedInstanceState)
   {
	  super.onCreate(savedInstanceState);
	  setContentView(R.layout.datos);
	  EdtDatos = (EditText)findViewById(R.id.EditTextDatos);
   }
   
   public boolean ConexionBaseDatos()
   {
	  boolean Respuesta = false;
	  //Declaro el helper y la base de datos
	  AccesoDb = new DbHelper(this, "BaseSegundaPrueba", null, 1);
	  BaseDeDatosRicolina = AccesoDb.getWritableDatabase();
	  //Verifico que la base de datos exista, comprobando que no sea null
	  if (BaseDeDatosRicolina != null)
	  {
		 Respuesta = true;
	  }
	  return Respuesta;
   }
   public void AgregarDatos(View vista)
   {
	  Datos = EdtDatos.getText().toString();
	  if(ConexionBaseDatos())
	  {
		 if (!ExisteEnLaBaseDeDatos(Datos))
		 {
			AgregarABaseDatos(Datos);
			EdtDatos.setText("");
		 }
		 else
		 {
			Toast MensajeError = Toast.makeText(this, "Ese dato ya está ingresado, sorry bro :(", Toast.LENGTH_SHORT);
			MensajeError.show();
		 }
	  }
	  else
	  {
		 Toast MensajeError = Toast.makeText(this, "Hubo un error con la base de datos", Toast.LENGTH_SHORT);
		 MensajeError.show();
	  }
   }
   public boolean ExisteEnLaBaseDeDatos(String Datoo)
   {
	  if (ConexionBaseDatos())
	  {
		 //Ejecuto una consulta que devuelve los registros
		 Cursor Registros = BaseDeDatosRicolina.rawQuery("select Dato from Datos", null);
		 //Si hay registros entro al if y la repetitiva
		 if (Registros.moveToFirst())
		 {
			//Leo los registros hasta que encuentre un nombre igual al ingresado, o que termine de recorer los registros
			do
			{
			   //Si el nombre ingresado es igual al del registro, devuelvo true finalizando el do while
			   String NombreSQL = Registros.getString(0);
			   int Comparador = NombreSQL.compareTo(Datoo);
			   if (Comparador == 0)
			   {
				  return true;
			   }
			} while (Registros.moveToNext());
		 }
	  }
	  //Si no encontre un nombre igual o no pude abrir la Db devuelvo false
	  return false;
   }
   public void AgregarABaseDatos(String Datazo)
   {
	  if (ConexionBaseDatos())
	  {
		 ContentValues NuevoRegistro = new ContentValues();
		 NuevoRegistro.put("Datos", Datazo);
		 BaseDeDatosRicolina.insert("Datos", null, NuevoRegistro);
		 BaseDeDatosRicolina.close();
	  }
   }
}
		 
		 

