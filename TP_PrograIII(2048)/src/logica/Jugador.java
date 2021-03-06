package logica;

public class Jugador implements Comparable{
	private String nombre;
	private int puntaje;
	
	public Jugador(String nombre,int puntaje) {
		this.nombre=nombre;
		this.puntaje=puntaje;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre= nombre;
	}

	public int getPuntaje() {
		return puntaje;
	}
	public void setPuntaje(int puntos) {
		this.puntaje=puntos;
	}
	
	
	@Override
	public int compareTo(Object o) {
		int comparePuntaje=((Jugador)o).getPuntaje();
		return comparePuntaje-this.puntaje ;
	}
	

}
