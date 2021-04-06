package logica;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;



public class MejoresJugadoresJSON {
	private ArrayList<Jugador> jugadores;
	
	
	public MejoresJugadoresJSON() {
		this.jugadores=new ArrayList<>();
	}
	
	public void agregarJugadorALista(Jugador jugador) {
		this.jugadores.add(jugador);
	}

	public ArrayList<Jugador> getJugadores() {
		return jugadores;
	}
	
	public String generarJSON() {
		Gson gson= new GsonBuilder().setPrettyPrinting().create();
		String json= gson.toJson(this);
		
		return json;
	}
	
	public void guardarJSON(String jsonParaGuardar,String archivoDestino) {
		
		try {
			
			FileWriter writer=new FileWriter(archivoDestino);
			writer.write(jsonParaGuardar);
			writer.close();
			 
		}catch(Exception e){
			e.printStackTrace();
		}	
	}
	
	public static MejoresJugadoresJSON leerJSON(String archivo) {
		Gson gson= new Gson();
		MejoresJugadoresJSON ret=null;
		
		try {
			BufferedReader br= new BufferedReader(new FileReader(archivo));
			ret=gson.fromJson(br, MejoresJugadoresJSON.class);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return ret;
	}
	
	public void agregarJugadorAJSON(Jugador jugador) {
		MejoresJugadoresJSON mejoresJugadores=new MejoresJugadoresJSON();
		
		ArrayList<Jugador> jugadoresLeidos=mejoresJugadores.leerJSON("MejoresJugadores.JSON").getJugadores();
		jugadoresLeidos.add(jugador);
		
		for(Jugador persona:jugadoresLeidos) {
			mejoresJugadores.agregarJugadorALista(persona);
		}
				
		String jsonPretty = mejoresJugadores.generarJSON();
		mejoresJugadores.guardarJSON(jsonPretty, "MejoresJugadores.JSON");
		
	}
	
	public ArrayList<Jugador> obtenerJugadoresJSON() {
		MejoresJugadoresJSON mejoresJugadores=new MejoresJugadoresJSON();
		
		ArrayList<Jugador> jugadoresLeidos=mejoresJugadores.leerJSON("MejoresJugadores.JSON").getJugadores();
		
		return jugadoresLeidos;
				
	}
}
