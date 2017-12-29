package zion.pruebasegundotrimestre;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Administrador on 22/8/2017.
 */

public class Lista extends AppCompatActivity
{
   ArrayList<String> MiListaPeliculas;
   @Override
   protected void onCreate(Bundle savedInstanceState)
   {
	  super.onCreate(savedInstanceState);
	  setContentView(R.layout.lista);
	  Peliculas MisPeliculas = new Peliculas();
   
	  MiListaPeliculas = MisPeliculas.ObtenerTodas();
	  ListView MiListViewPeliculas = (ListView)findViewById(R.id.ListviewPeliculas);
	  AdaptadorPeliculas Adapter = new AdaptadorPeliculas(MiListaPeliculas, this);
	  MiListViewPeliculas.setAdapter(Adapter);
   }
   
}
