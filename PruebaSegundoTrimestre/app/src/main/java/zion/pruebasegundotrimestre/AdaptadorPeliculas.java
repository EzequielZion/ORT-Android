package zion.pruebasegundotrimestre;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Administrador on 13/7/2017.
 */

public class AdaptadorPeliculas extends BaseAdapter
{
   private ArrayList<String> _MiListaPeliculas;
   private Context _Context;
   public AdaptadorPeliculas(ArrayList<String>ListaDePeliculas, Context ContextoAUsar)
   {
	  _MiListaPeliculas = ListaDePeliculas;
	  _Context = ContextoAUsar;
   }
  
   
   public int getCount()
   {
	  return _MiListaPeliculas.size();
   }
   
   public String getItem(int PosAObt)
   {
	  String NombreADevolver;
	  NombreADevolver = _MiListaPeliculas.get(PosAObt);
	  return NombreADevolver;
   }
   
   public long getItemId(int PosAObt)
   {
	  return PosAObt;
   }
   
   public View getView(int PosicionActual, View VistaActual, ViewGroup GrupoActual)
   {
	  View VistaADevolver;
	  LayoutInflater InfladorDeLayouts = (LayoutInflater) _Context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	  VistaADevolver = InfladorDeLayouts.inflate(R.layout.listview_peliculas_detalles, GrupoActual, false);
	  	  
	  TextView Pelicula = (TextView) VistaADevolver.findViewById(R.id.TxtNombrePelicula);
	  TextView CantCaracteres = (TextView) VistaADevolver.findViewById(R.id.CantCaracteres);
	  	  
	  String TextoPelicula = getItem(PosicionActual);
	  Pelicula.setText("Pelicula: " + TextoPelicula);
	  
	  int CantCaracteresPelicula = TextoPelicula.length();
	  CantCaracteres.setText("Cantidad de caracteres: " + CantCaracteresPelicula);
	  	  
	  return VistaADevolver;
   }
   
}
