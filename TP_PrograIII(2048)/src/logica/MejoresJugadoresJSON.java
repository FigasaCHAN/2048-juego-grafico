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
		
//		if(jugadoresLeidos.size()<5) {			
//			jugadoresLeidos.add(jugador);
//		}else if(jugadoresLeidos.get(jugadoresLeidos.size()-1).getPuntaje()<jugador.getPuntaje()) {
//			jugadoresLeidos.remove(jugadoresLeidos.size()-1);
//			jugadoresLeidos.add(jugador);
//		}
		
					
		String jsonPretty = mejoresJugadores.generarJSON();
		mejoresJugadores.guardarJSON(jsonPretty, "MejoresJugadores.JSON");
		
	}
	
	private ArrayList<Jugador> ordenarPuntajes(ArrayList<Jugador> jugadores){
		ArrayList<Jugador> puntajesOrdenados=new ArrayList<>();
		//implementar
		return puntajesOrdenados;
		
	}
	
	public ArrayList<Jugador> obtenerJugadoresJSON() {
		MejoresJugadoresJSON mejoresJugadores=new MejoresJugadoresJSON();
		
		ArrayList<Jugador> jugadoresLeidos=mejoresJugadores.leerJSON("MejoresJugadores.JSON").getJugadores();
		
		return jugadoresLeidos;
				
	}
}
