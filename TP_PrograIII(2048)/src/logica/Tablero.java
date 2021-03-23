package logica;

import java.util.ArrayList;

public class Tablero {


	public static void moverArriba(int[][] matriz) {
		if(matriz.length==0) {
			throw new RuntimeException("La matriz no puede estar vacia");
		}

		for(int columna= 0; columna<matriz[0].length; columna++) {
			//suponiendo que la matriz es cuadrada
			moverColumArriba(matriz,columna);
		}
	}


	public static void moverColumArriba(int[][] matriz, int columna) {
		if(columna<0 || columna>matriz[0].length ) {
			//suponiendo que la matriz es cuadrada
			throw new RuntimeException("La columna tiene que ser >=0 && <CantidadDeColumna");
		}
		ArrayList<Integer> arrayColumna= sumarNumerosIguales ( columnaToArray(matriz, columna) ); 

		int iArrayList=0; //indice del arrayList de columna
		int cantElemArrayList= arrayColumna.size(); //la cantidad de elem que tengo que agregar 
		for(int fila=0; fila<matriz.length;fila++) { 
			if(cantElemArrayList>0) {
				matriz[fila][columna]= arrayColumna.get(iArrayList);
				iArrayList++; //sumo el indice
				cantElemArrayList--; //resto la cantidad de elem
				/*
					 Esta forma fue omitida porque remove es O(n) y este algoritmo pasaria a ser O(n*n)

					matriz[fila][col]= arrayColumna.get(0);
					arrayColumna.remove(0);

				 */
			}
			else {
				matriz[fila][columna]=0;
			}
		}
	}




	public static void moverAbajo(int[][] matriz) {
		if(matriz.length==0) {
			throw new RuntimeException("La matriz no puede estar vacia");
		}

		for(int columna= 0; columna<matriz[0].length; columna++) {
			moverColumAbajo(matriz,columna);
		}
	}


	public static void moverColumAbajo(int[][] matriz, int columna) {
		if(columna<0 || columna>matriz[0].length ) {
			//suponiendo que la matriz es cuadrada
			throw new RuntimeException("La columna tiene que ser >=0 && <CantidadDeColumna");
		}
		ArrayList<Integer> arrayColumna= sumarNumerosIguales( columnaToArray(matriz, columna) ); 

		int iArrayList=arrayColumna.size()-1; //indice del arrayList de columna, agarro el ultimo
		int cantElemArrayList= arrayColumna.size(); //la cantidad de elem que tengo que agregar 
		for(int fila=matriz.length-1; fila>=0;fila--) { 

			if(cantElemArrayList>0) {

				matriz[fila][columna]= arrayColumna.get(iArrayList);

				iArrayList--; //resto el indice
				cantElemArrayList--; //resto la cantidad de elem

			}
			else {

				matriz[fila][columna]=0;
			}
		}
	}

	public static ArrayList<Integer> columnaToArray(int[][]matriz, int columna) {
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

	public static String imprimirTablero(int[][] matriz) {
		StringBuilder tableroS= new StringBuilder();
		for(int[] fila: matriz) {
			tableroS.append('|');
			for(int elem : fila) {
				tableroS.append(elem + "|"); //agrega el elem
			}
			tableroS.append('\n'); //agrega el salto en linea
		}
		return tableroS.toString();
	}

	private static ArrayList<Integer> sumarNumerosIguales(ArrayList<Integer> array){
		//solo suma si estan uno al lado del otro
		ArrayList<Integer> nuevaArray= new ArrayList<Integer>();
		if(array.size()==1) {
			nuevaArray.add(array.get(0));
			return nuevaArray;
		}
		for(int i=0; i<=array.size()-1; i++) { //va solo hasta el ante ultimo

			if(array.get(i)==array.get(i+1)) {
				int suma= array.get(i)+array.get(i+1); //los sumo
				nuevaArray.add(suma);
				i++; //incremento el i para no fijarme el siguiente, al finalizar el ciclo tambien va a sumar i
			}
			else {
				nuevaArray.add(i);
			}

		}
		return nuevaArray;
	}

	public static void main(String[] args) {
		int[][] mat= { {0,2,0,8},{4,2,0,8},{0,2,0,0},{4,2,0,0} };
		System.out.println(imprimirTablero(mat));
		System.out.println("Muevo para arriba");
		moverArriba(mat);
		System.out.println(imprimirTablero(mat));
		moverAbajo(mat);
		moverAbajo(mat);
		moverArriba(mat);
		System.out.println(imprimirTablero(mat));
	}
}
