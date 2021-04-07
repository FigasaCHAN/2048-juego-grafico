package logica;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Tablero {
	
	private int [][] tabla;
	public Map<Point, Integer> diccionario;
	final byte[] NUM_RANDOM_POSIBLES;
	private int puntos;
	private boolean gameOver;
	private int maximoNumEnElTablero; //me va a servir para determinar si el jugador gano o perdio
	
	public Tablero(int [][] mat) {
		if(mat.length==0 || mat==null) {
			throw new RuntimeException("Para crear el tablero la matriz no tiene que estar vacia ni debe ser null");
		}
		if(mat.length==1) {
			throw new RuntimeException("La matriz no puede tener solo una fila");
		}
		if(!laMatrizEsCuadrada(mat)) {
			throw new RuntimeException("La matriz no es cuadrada");
		}
		this.NUM_RANDOM_POSIBLES= new byte[]{2,4}; //los numeros randoms posibles que puedo agregar
		this.tabla=mat;
		this.diccionario= new HashMap<Point,Integer>();
		for (int iFila= 0; iFila<mat.length; iFila++) { //al diccionario le agrego todos los puntos con sus valores correspondientes
			for(int iColumna= 0;iColumna<mat[iFila].length;iColumna++ ) {
				diccionario.put(new Point(iFila,iColumna), mat[iFila][iColumna]);
			}
		}
		this.puntos=0;
		this.gameOver= false;
		this.maximoNumEnElTablero= 0;
	}
	
	public Tablero(int cantidadFilas) {
		int[][] array= generarMatrizCuadradaAlAzar(cantidadFilas); 
		Tablero tableroAux= new Tablero(array);
		this.tabla= tableroAux.tabla;
		this.diccionario= tableroAux.diccionario;
		this.NUM_RANDOM_POSIBLES= tableroAux.NUM_RANDOM_POSIBLES;
		this.puntos= tableroAux.puntos;
		this.gameOver= tableroAux.gameOver;
		this.maximoNumEnElTablero= tableroAux.maximoNumEnElTablero;
	}
	public void moverArriba() {
		if(this.tabla.length==0) {
			throw new RuntimeException("La matriz no puede estar vacia");
		}
		if(!this.gameOver) {
			for(int columna= 0; columna<this.tabla[0].length; columna++) {
				//suponiendo que la matriz es cuadrada
				moverColumArriba(columna);
			}
			
		}
		
		
	}


	private void moverColumArriba(int columna) {
		if(columna<0 || columna>this.tabla[0].length ) {
			//suponiendo que la matriz es cuadrada
			throw new RuntimeException("La columna tiene que ser >=0 && <CantidadDeColumna");
		}
		
		ArrayList<Integer> arrayColumna= sumarNumerosIguales ( columnaToArray(this.tabla, columna) ); 
		//O(3*n + 12)
		int iArrayList=0; //indice del arrayList de columna
		int cantElemArrayList= arrayColumna.size(); //la cantidad de elem que tengo que agregar 
		for(int fila=0; fila<this.tabla.length;fila++) { 
			if(cantElemArrayList>0) {
				this.tabla[fila][columna]= arrayColumna.get(iArrayList);
				iArrayList++; //sumo el indice
				cantElemArrayList--; //resto la cantidad de elem
				/*
					 Esta forma fue omitida porque remove es O(n) y este algoritmo pasaria a ser O(n*n)

					matriz[fila][col]= arrayColumna.get(0);
					arrayColumna.remove(0);

				 */
				
			}
			else {
				this.tabla[fila][columna]=0;
			}
			this.diccionario.replace(new Point(fila,columna), this.tabla[fila][columna]); //reemplazo la key del punto
		}
		
	}

	public void moverAbajo() {
		if(this.tabla.length==0) {
			throw new RuntimeException("La matriz no puede estar vacia");
		}
		if(!this.gameOver) {
			
			for(int columna= 0; columna<this.tabla[0].length; columna++) {
				moverColumAbajo(columna);
			}				
			insertarRandom();	
				
		}
		
		
	}


	private void moverColumAbajo(int columna) {
		if(columna<0 || columna>this.tabla[0].length ) {
			//suponiendo que la matriz es cuadrada
			throw new RuntimeException("La columna tiene que ser >=0 && <CantidadDeColumna");
		}
		
		ArrayList<Integer> arrayColumna= sumarNumerosIgualesReves( columnaToArray(this.tabla, columna) ); 
		int iArrayList=0; //indice del arrayList de columna, agarro el primero ya que la lista esta al reves (los primeros numeros son los ultimos que tengo que agregar
		int cantElemArrayList= arrayColumna.size(); //la cantidad de elem que tengo que agregar 
		for(int fila=this.tabla.length-1; fila>=0;fila--) { //reemplazo los valores de atras para adelante 

			if(cantElemArrayList>0) {

				this.tabla[fila][columna]= arrayColumna.get(iArrayList);

				iArrayList++; //sumo el indice para no chequear el siguiente
				cantElemArrayList--; //resto la cantidad de elem

			}
			else {
				this.tabla[fila][columna]=0;
			}
			this.diccionario.replace(new Point(fila,columna),this.tabla[fila][columna]);
		}
	}

	private ArrayList<Integer> columnaToArray(int[][]matriz, int columna) {
		ArrayList<Integer>  columnaArray= new ArrayList<Integer>();

		if(columna<0 || columna>matriz[0].length ) {
			//suponiendo que la matriz es cuadrada
			throw new RuntimeException("La columna tiene que ser >=0 && <CantidadDeColumna");
		}

		for(int fila=0; fila<matriz.length; fila++) {
			if(matriz[fila][columna]!=0) { //solo agrego aquellos que no son 0
				columnaArray.add(matriz[fila][columna]);
			}

		}
		return columnaArray;
	}
	
	
	@Override
	public String toString() {
		StringBuilder tableroS= new StringBuilder();
		for(int[] fila:this.tabla ) {
			tableroS.append('|');
			for(int elem : fila) {
				tableroS.append(elem + "|"); //agrega el elem
			}
			tableroS.append('\n'); //agrega el salto en linea
		}
		return tableroS.toString();
	}

	private ArrayList<Integer> sumarNumerosIguales(ArrayList<Integer> array){
		//solo suma si estan uno al lado del otro
		//suma de izquierda a derecha
		ArrayList<Integer> nuevaArray= new ArrayList<Integer>();
		if(array.size()==1) {
			nuevaArray.add(array.get(0));
			return nuevaArray;
		}
		for(int i=0; i<=array.size()-1; i++) { //va solo hasta el ante ultimo
			if(i==array.size()-1) {
				nuevaArray.add(array.get(i)); //cuando llega al ultimo
				return nuevaArray;
			}
			if(array.get(i).equals(array.get(i+1))) {
			//if(array.get(i)==array.get(i+1)) {
				int suma= (array.get(i)+array.get(i+1)); //los sumo
				nuevaArray.add(suma);
				i++; //incremento el i para no fijarme el siguiente, al finalizar el ciclo tambien va a sumar i
				this.puntos+= suma; //a los puntos le agrego la suma
				if(this.maximoNumEnElTablero<suma) { // si pasa esto, entonces encontre un numero mas grande
					this.maximoNumEnElTablero= suma;
				}
				if(2048==suma) { //si la suma es 2048 entonces finaliza el juego
					this.gameOver= true;
				}
			}
			else {
				nuevaArray.add(array.get(i));
				}
		}
		return nuevaArray;
	}
	private ArrayList<Integer> sumarNumerosIgualesReves(ArrayList<Integer> array){
		//suma de derecha a izquierda, ideal para el movimiento a la derecha y abajo
		ArrayList<Integer> nuevaArray= new ArrayList<Integer>();
		if(array.size()==1) {
			nuevaArray.add(array.get(0));
			return nuevaArray;
		}
		for(int i=array.size()-1; i>=0; i--) { //va solo hasta el ante ultimo
			if(i==0) {
				nuevaArray.add(array.get(i)); //cuando llega al ultimo
				return nuevaArray;
			}
			if(array.get(i).equals(array.get(i-1))) {
			//if(array.get(i)==array.get(i+1)) {
				int suma= (array.get(i)+array.get(i-1)); //los sumo
				nuevaArray.add(suma);
				i--; //incremento el i para no fijarme el siguiente, al finalizar el ciclo tambien va a sumar i
				this.puntos+= suma; //a los puntos le agrego la suma
				if(this.maximoNumEnElTablero<suma) { // si pasa esto, entonces encontre un numero mas grande
					this.maximoNumEnElTablero= suma;
				}
				if(2048==suma) { //si la suma es 2048 entonces finaliza el juego
					this.gameOver= true;
				}
			}
			else {
				nuevaArray.add(array.get(i));
				}
		}
		return nuevaArray;
	}
	
	public void moverIzquierda() {

		if(!this.gameOver ) {
			for(int numFila=0; numFila<this.tabla.length;numFila++) {
				moverFilaIzquierda(this.tabla[numFila],numFila);
			}
		
				insertarRandom();	
			
		}

	}
	private void moverFilaIzquierda(int [] fila, int numFila) {
		ArrayList<Integer> arraylistFila= sumarNumerosIguales( filaToArrayList(fila) );
		int cantElemEnElArray= arraylistFila.size();
		int iArrayList=0;
		for(int i=0; i<fila.length; i++) {
			if(cantElemEnElArray>0) {
				this.tabla[numFila][i]= arraylistFila.get(iArrayList);
				iArrayList++;
				cantElemEnElArray--;
			}
			else {
				this.tabla[numFila][i]= 0;
			}
			this.diccionario.replace(new Point( numFila, i), this.tabla[numFila][i]);
		}
	}
	
	public void moverDerecha() {
		if(!this.gameOver) {
			for(int numFila=0; numFila<this.tabla.length;numFila++) {
				moverFilaDerecha(this.tabla[numFila],numFila);
			}			
			insertarRandom();					
		}

	}
	private void moverFilaDerecha(int [] fila, int numFila) {
		ArrayList<Integer> arraylistFila= sumarNumerosIgualesReves( filaToArrayList(fila) );
		int cantElemEnElArray= arraylistFila.size();
		int iArrayList=0;
		for(int i=fila.length-1; i>=0; i--) {
			if(cantElemEnElArray>0) {
				this.tabla[numFila][i]= arraylistFila.get(iArrayList);
				iArrayList++;
				cantElemEnElArray--;
			}
			else {
				this.tabla[numFila][i]= 0;
			}
			this.diccionario.replace(new Point( numFila, i), this.tabla[numFila][i] );
		}
	}
	
	
	private ArrayList<Integer> filaToArrayList(int[] array){
		//devuelve arraylist integer sin 0
		ArrayList<Integer> nuevaArray= new ArrayList<Integer>();
		for(int elem : array) {
			if(elem!=0) {
				nuevaArray.add(elem);
			}
		}
		return nuevaArray;
	}
	
	private boolean laMatrizEsCuadrada(int[][] mat) {
		boolean todasIguales=true;
		int cantDeFilas= mat.length; 
		for (int[] fila : mat) {
			if( fila.length == cantDeFilas ) {
				todasIguales= todasIguales&& true;
			}
			else {
				todasIguales= todasIguales && false;
			}
		}
		return todasIguales;
	}
	public void insertarRandom() {
		ArrayList<Point> iPosibles= new ArrayList<Point>();
		for (Point elem: this.diccionario.keySet()) {
			if(this.diccionario.get(elem)==0) {
				iPosibles.add(elem);
			}
		}
		int iRandom_delArray =  (int) (Math.random()* (iPosibles.size()) ); //num random para un i 
		int numRandom =  (int) (Math.random()* 2); //va a ser 0 o 1 y lo voy a utilizar para seleccionar un elem del array de numerosRandom(2 o 4)
		if(iPosibles.size()!=0) {
			//this.gameOver=true;
			this.tabla[iPosibles.get(iRandom_delArray).x][iPosibles.get(iRandom_delArray).y]= this.NUM_RANDOM_POSIBLES[numRandom]; //a la casilla random, le asigno el numero random
		}
		else {
//			if(!puedeSumar()) {
//				this.gameOver=true;
//			}
		}
	}
	
	public ArrayList<Integer> matrizToArray(){
		ArrayList<Integer> nueva= new ArrayList<Integer>();
		for(int [] fila: this.tabla) {
			for(int  elem: fila) {
				nueva.add(elem);
			}
		}
		return nueva;
	}
	public int getPuntos() {
		return this.puntos;
	}
	
	private int[][] generarMatrizCuadradaAlAzar(int cantidadFilas){
		//inicializa todo con 0
		int [][] array= new int[cantidadFilas][cantidadFilas];
		int[] numPosibles= {2,4};
		for(int fila= 0; fila<array.length;fila++) {
			for(int elem=0; elem<array.length; elem++) {
				array[fila][elem]= 0;
			}
		}
		
		for(int i=0; i<2; i++) {
			int filaRandom= (int) (Math.random()* (cantidadFilas) ); //un numero al azar que va de 0 a cantidadFila
			int columRandom= (int) (Math.random()* (cantidadFilas) );
			int iNumRandom= (int) (Math.random()* (2) );
			array[filaRandom][columRandom]= numPosibles[iNumRandom];
		}
		return array;
	}
	public int[][] getTablero(){
		return this.tabla;
	}
	public boolean getGameOver() {
		return this.gameOver;
	}
	public int getMaximoNumEnElTablero() {
		return this.maximoNumEnElTablero;
	}
	
	public void puedeSumar() {
		boolean todasFilas= false;
		boolean todasColum= false;
		ArrayList<Integer> filaArray;
		ArrayList<Integer> columArray;
		for(int[] fila:this.tabla) {
			filaArray= sumarNumerosIguales2(filaToArrayList(fila));
			todasFilas= todasFilas || filaArray.size()!=fila.length; //si filaArray es distinto del length de la fila, significa que pudo sumar 
		}
		for(int i= 0; i<this.tabla.length;i++) {
			columArray= sumarNumerosIguales2(columnaToArray(this.tabla,i));
			todasColum= todasColum || columArray.size()!=this.tabla.length;
		}
			if((!todasFilas && !todasColum)) {
				this.gameOver=true;
			}

		
	}
	private ArrayList<Integer> sumarNumerosIguales2(ArrayList<Integer> array){
		//solo suma si estan uno al lado del otro
		//suma de izquierda a derecha
		ArrayList<Integer> nuevaArray= new ArrayList<Integer>();
		if(array.size()==1) {
			nuevaArray.add(array.get(0));
			return nuevaArray;
		}
		for(int i=0; i<=array.size()-1; i++) { //va solo hasta el ante ultimo
			if(i==array.size()-1) {
				nuevaArray.add(array.get(i)); //cuando llega al ultimo
				return nuevaArray;
			}
			if(array.get(i).equals(array.get(i+1))) {
			//if(array.get(i)==array.get(i+1)) {
				int suma= (array.get(i)+array.get(i+1)); //los sumo
				nuevaArray.add(suma);
				i++; //incremento el i para no fijarme el siguiente, al finalizar el ciclo tambien va a sumar i
			}
			else {
				nuevaArray.add(array.get(i));
				}
		}
		return nuevaArray;
	}
}
