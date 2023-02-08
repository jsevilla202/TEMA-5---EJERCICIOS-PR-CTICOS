package ej2;

import java.util.Arrays;
import java.util.Scanner;

public class Funcion {
	final static String[] palos = { "oros", "copas", "espadas", "bastos"};
	final static int[] cartas = {1,2,3,4,5,6,7,8,9,10};
	final static String j1 = "JUGADOR 1";
	final static String j2 = "JUGADOR 2";
	static int[] duplicados = new int [1];
	static boolean duplicado = true;
	static Scanner sc = new Scanner(System.in);
	
	static double juego(double pj) {
		String eleccion = "s";
		int randompalos;
		int randomcartas;
		
		System.out.println();
		while(eleccion.equals("s")&&pj<=7.5) {
			System.out.println();
			System.out.print("¿Quieres sacar una carta (s/n)? ");
			eleccion = sc.next();
			if(eleccion.equals("s")) {
				randompalos = (int) (Math.random()*palos.length);
				randomcartas = (int) (Math.random()*cartas.length);
				Funcion.descartes(randompalos, randomcartas);
				if(duplicado = true) {
					//Muestra los puntos al jugador
					pj = Funcion.cartas(randompalos, randomcartas, pj);
					System.out.println("Tienes " + pj);
				}
				else {
					//Se repite hasta que dejan de salir duplicados
					while(duplicado=false) {
						randompalos = (int) (Math.random()*palos.length);
						randomcartas = (int) (Math.random()*cartas.length);
						Funcion.descartes(randompalos, randomcartas);
					}
					//Muestra los puntos al jugador
					Funcion.cartas(randompalos, randomcartas, pj);
					System.out.println("Tienes " + pj + " puntos");
				}
			}
			if(!eleccion.equals("n")&&!eleccion.equals("s")) {
				System.out.println("ERROR: Valor introducido no valido");
				eleccion = "s";
			}
		}
		System.out.println();
		return pj;
	}
	
	//Switch para mostrar al usuario la carta que ha sacado
	static double cartas(int rpalos, int rcartas, double pj) {
		switch(rcartas) {
		case 0, 1, 2, 3,4, 5, 6:
			System.out.println("Tu carta es: " + cartas[rcartas] + " de " + palos[rpalos]);
			pj += cartas[rcartas];
			break;
		case 7: 
			System.out.println("Tu carta es: " + "Sota"+ " de " + palos[rpalos]);
			pj += 0.5;
			break;
		case 8: 
			System.out.println("Tu carta es: " + "Caballo"+ " de " + palos[rpalos]);
			pj += 0.5;
			break;
		case 9: 
			System.out.println("Tu carta es: " + "Rey"+ " de " + palos[rpalos]);
			pj += 0.5;
			break;
		}
		return pj;
	}
	
	//Funcion para guardar las cartas usadas
	static void descartes(int rpalos, int rcartas) {
		duplicado = true;
		//Junta los numeros
		int dup = Integer.parseInt(Integer.toString(rpalos) + Integer.toString(rcartas));
		//Comprueba si ya estaba el duplicado en el array
		for(int i = 0; i < duplicados.length; i++) {
			if(dup == duplicados[i]) {
				duplicado = false;
			}
		}
		//Lo añade a la lista
		if(duplicado = true) {
			duplicados = Arrays.copyOf(duplicados, duplicados.length+1);
			duplicados[duplicados.length-1] = dup;
		}
	}
	
	
}
