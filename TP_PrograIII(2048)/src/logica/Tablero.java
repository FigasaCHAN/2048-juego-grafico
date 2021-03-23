package logica;

import java.util.ArrayList;

public class Tablero {
	
	private int [][] tabla;
	private int lugaresPreviosOcupados; //la utilizo para corroborar que no tengo lugares ocupados 
										//antes de la celda actual.
	
	public Tablero(int [][] mat) {
		if(mat.length==0 || mat==null) {
			throw new RuntimeException("Para crear el tablero la matriz no tiene que estar vacia ni debe ser null");
		}
		if(mat.length==1) {
			throw new RuntimeException("La matriz no puede tener solo una fila");
		}
		this.tabla=mat;
		this.lugaresPreviosOcupados=0;
	}
	
	public void recorrerMatrix(String direccion,int fila,int columna,int ultimoIndiceRevisado) {
		if(this.tabla[fila][columna]!=0) {	
			
			if(direccion.equals("izquierda")) {
//			movimientoIzq(...);
			movimientoIzq(fila,columna,this.tabla[fila][columna]);
			this.lugaresPreviosOcupados++;
			}else if(direccion.equals("derecha")) {
//			movimientoDer(...);
			}
		}
	}

	public void movimientoUsuario(String direccion) {
		int fila=0, columna=0,ultimoIndiceRevisado=0;
		
		while(fila<this.tabla.length) {//empieza a recorrer la tabla segun la direccion que diga el usuario
				recorrerMatrix(direccion,fila,columna,ultimoIndiceRevisado);	
			 if(columna==this.tabla[0].length-1) {
				fila++;
				columna=0;
				ultimoIndiceRevisado=0;
				this.lugaresPreviosOcupados=0;
			}else {
				columna++;
				ultimoIndiceRevisado++;				
			}
			
		}
	}
	
	
	
	public void moverArriba() {
		if(this.tabla.length==0) {
			throw new RuntimeException("La matriz no puede estar vacia");
		}

		for(int columna= 0; columna<this.tabla[0].length; columna++) {
			//suponiendo que la matriz es cuadrada
			moverColumArriba(columna);
		}
	}


	private void moverColumArriba(int columna) {
		if(columna<0 || columna>this.tabla[0].length ) {
			//suponiendo que la matriz es cuadrada
			throw new RuntimeException("La columna tiene que ser >=0 && <CantidadDeColumna");
		}
		
		ArrayList<Integer> arrayColumna= sumarNumerosIguales ( columnaToArray(this.tabla, columna) ); 
		System.out.println("Columna: " + columna + arrayColumna.toString() + "Columna Array: " + columnaToArray(this.tabla, columna).toString() );
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
		}
	}

	public void moverAbajo() {
		if(this.tabla.length==0) {
			throw new RuntimeException("La matriz no puede estar vacia");
		}

		for(int columna= 0; columna<this.tabla[0].length; columna++) {
			moverColumAbajo(columna);
		}
	}


	private void moverColumAbajo(int columna) {
		if(columna<0 || columna>this.tabla[0].length ) {
			//suponiendo que la matriz es cuadrada
			throw new RuntimeException("La columna tiene que ser >=0 && <CantidadDeColumna");
		}
		
		ArrayList<Integer> arrayColumna= sumarNumerosIguales( columnaToArray(this.tabla, columna) ); 
		int iArrayList=arrayColumna.size()-1; //indice del arrayList de columna, agarro el ultimo
		int cantElemArrayList= arrayColumna.size(); //la cantidad de elem que tengo que agregar 
		for(int fila=this.tabla.length-1; fila>=0;fila--) { 

			if(cantElemArrayList>0) {

				this.tabla[fila][columna]= arrayColumna.get(iArrayList);

				iArrayList--; //resto el indice
				cantElemArrayList--; //resto la cantidad de elem

			}
			else {

				this.tabla[fila][columna]=0;
			}
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
	
	public void movimientoIzq(int filaActual,int columnaActual,int valor) {
		
		for(int colum=0;colum<columnaActual;colum++) { //ej si pulsa tecla izquierda 
			if(this.tabla[filaActual][colum]==0) { 

				this.tabla[filaActual][columnaActual]=0;
				this.tabla[filaActual][colum]=valor;
				this.lugaresPreviosOcupados--;
				break;
			}
			else if(this.tabla[filaActual][colum]==valor && colum>=this.lugaresPreviosOcupados-1) {
			
				this.tabla[filaActual][columnaActual]=0;
				this.tabla[filaActual][colum]=sumarLinea(valor,this.tabla[filaActual][colum]);				
				break;
			}
		}
	}
	
	public void movimientoDer(int filaActual,int columnaActual, int valor) {

		for(int colum=3;colum>columnaActual;colum--) { //ej si pulsa tecla derecha 
			if(this.tabla[filaActual][colum]==0) {
				this.tabla[filaActual][columnaActual]=0;
				this.tabla[filaActual][colum]=valor;
			
				break;
			}
			else if(this.tabla[filaActual][columnaActual]==valor) {
				this.tabla[filaActual][columnaActual]=0;
				this.tabla[filaActual][colum]=sumarLinea(valor,this.tabla[filaActual][colum]);				
				break;
			}
		}
	}
	
	private int sumarLinea(int valor1,int valor2) {
		return valor1+valor2;
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
			if(array.get(i)==array.get(i+1)) {
				int suma= array.get(i)+array.get(i+1); //los sumo
				nuevaArray.add(suma);
				i++; //incremento el i para no fijarme el siguiente, al finalizar el ciclo tambien va a sumar i
			}
			else {
				nuevaArray.add(array.get(i));
				}
		}
		return nuevaArray;
	}

//	public static void main(String[] args) {
////		int[][] mat= { {4,2,2,16},{4,32,2,8},{0,64,2,0},{4,2,4,16} };
////		System.out.println(imprimirTablero(mat));
////		System.out.println("Muevo para arriba");
////		moverArriba(mat);
////		System.out.println(imprimirTablero(mat));
//	}
}
