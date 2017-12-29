package zion.pruebasegundotrimestre;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrador on 21/6/2017.
 */

public class DbHelper extends SQLiteOpenHelper
{
   
   public DbHelper(Context Contexto, String Nombre, SQLiteDatabase.CursorFactory Fabrica, int Version)
   {
	  super(Contexto, Nombre, Fabrica, Version);
   }
   
   @Override
   public void onCreate(SQLiteDatabase DatabaseLOL)
   {
	  String CrearTablaDatos = "create table Datos (Dato text)";
	  DatabaseLOL.execSQL(CrearTablaDatos);
   }
   @Override
   public void onUpgrade(SQLiteDatabase Db, int versionAnterior, int versionNueva)
   {
   }
   
}