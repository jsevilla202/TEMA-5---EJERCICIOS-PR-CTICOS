package ej1;

import java.io.IOException;

public class Main {

	public static void main(String[] args){
		char  tabla[] = new char [20];
		
		final Funcion funcion = new Funcion();
		
		tabla = funcion.minas(tabla);
		
		System.out.println("Bienvenid@ al juego de las minas, el juego es muy sencillo\n 1. Inserta un número del 1 al 20"+
		"\n 2. Si recibes un número, el 0 o el 1 o el 2, significa que ceca hay esa cantidad de minas"+
				"\n 3. Si sale una bomba, has perdido\nPasalo bien jugando, el juego empezara automaticamente");
		funcion.juego(tabla);

	}

}
