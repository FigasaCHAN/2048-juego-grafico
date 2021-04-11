package logica;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MejoresJugadores {
	private ArrayList<Jugador> jugadores;
		
	public MejoresJugadores() {
		this.jugadores=new ArrayList<>();
	}
	
	public void agregarJugadorAlArchivo(Jugador jugador) {
		MejoresJugadores mejoresJugadores=new MejoresJugadores();
		
		ArrayList<Jugador> jugadoresLeidos=mejoresJugadores.leerJSON("MejoresJugadores.JSON").getJugadores();
		Collections.sort(jugadoresLeidos);
		
		jugadoresLeidos.add(jugador);
		
		for(Jugador jugadorIterador:jugadoresLeidos) {
			mejoresJugadores.agregarJugadorALista(jugadorIterador);
		}
									
		String jsonPretty = mejoresJugadores.generarJSON();
		mejoresJugadores.guardarJSON(jsonPretty, "MejoresJugadores.JSON");

	}
	
	
	public ArrayList<Jugador> obtenerJugadores() {
		MejoresJugadores mejoresJugadores=new MejoresJugadores();
		
		ArrayList<Jugador> jugadoresLeidos=mejoresJugadores.leerJSON("MejoresJugadores.JSON").getJugadores();
		Collections.sort(jugadoresLeidos);
		
		return jugadoresLeidos;
				
	}
	
	private void agregarJugadorALista(Jugador jugador) {
		this.jugadores.add(jugador);
	}

	private ArrayList<Jugador> getJugadores() {
		return jugadores;
	}
	
	private String generarJSON() {
		Gson gson= new GsonBuilder().setPrettyPrinting().create();
		String json= gson.toJson(this);
		
		return json;
	}
	
	private void guardarJSON(String jsonParaGuardar,String archivoDestino) {
		
		try {
			
			FileWriter writer=new FileWriter(archivoDestino);
			writer.write(jsonParaGuardar);
			writer.close();
			 
		}catch(Exception e){
			e.printStackTrace();
		}	
	}
	
	private static MejoresJugadores leerJSON(String archivo) {
		Gson gson= new Gson();
		MejoresJugadores ret=null;
		
		try {
			BufferedReader br= new BufferedReader(new FileReader(archivo));
			ret=gson.fromJson(br, MejoresJugadores.class);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return ret;
	}
	
	
}
