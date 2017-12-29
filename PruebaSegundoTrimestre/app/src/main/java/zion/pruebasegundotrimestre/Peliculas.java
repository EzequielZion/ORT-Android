package zion.pruebasegundotrimestre;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrador on 22/8/2017.
 */

public class Peliculas
{
   public ArrayList<String> ObtenerTodas()
   {
	  ArrayList<String> ListaADevolver;
	  ListaADevolver = new ArrayList<>();
	  ListaADevolver.add("Volver al Futuro");
	  ListaADevolver.add("Indiana Jones");
	  ListaADevolver.add("Forrest Gump");
	  ListaADevolver.add("Rocky");
	  ListaADevolver.add("Rambo");
	  ListaADevolver.add("Toy Story");
	  ListaADevolver.add("Toy Story 2");
	  ListaADevolver.add("Toy Story 3");
	  ListaADevolver.add("Mi villano favorito");
	  ListaADevolver.add("Wall-E");
	  return ListaADevolver;
   }
}
