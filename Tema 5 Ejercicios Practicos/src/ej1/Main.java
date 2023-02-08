package ej1;

public class Main {

	public static void main(String[] args){
		//Crea una tabla de longitud 20
		char  tabla[] = new char [20];
		//Importa las funciones de la clase Funcion
		final Funcion funcion = new Funcion();
		
		//Iguala la tabla principal a la tabla que devuelve el metodo minas
		tabla = funcion.minas(tabla);
		
		//Introduce al usuario en el juego
		System.out.println("Bienvenid@ al juego de las minas, el juego es muy sencillo\n 1. Inserta un número del 1 al 20"+
		"\n 2. Si recibes un número, el 0 o el 1 o el 2, significa que ceca hay esa cantidad de minas"+
				"\n 3. Si sale una bomba, has perdido\nPasalo bien jugando, el juego empezara automaticamente");
		//Introduce la tabla obtenida en el juego
		funcion.juego(tabla);

	}

}
