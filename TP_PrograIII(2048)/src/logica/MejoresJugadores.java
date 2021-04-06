package logica;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class MejoresJugadores {
	private ArrayList<Jugador> jugadores;
	
	
	public MejoresJugadores() {
		this.jugadores=new ArrayList<>();
	}
	
	public void agregarJugador(Jugador jugador) {
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
	
	public static MejoresJugadores leerJSON(String archivo) {
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
