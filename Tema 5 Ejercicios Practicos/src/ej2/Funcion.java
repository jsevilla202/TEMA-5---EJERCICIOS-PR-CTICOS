package ej2;

import java.util.Arrays;
import java.util.Scanner;

public class Funcion {
	//Array que contiene la lista de palos
	final static String[] palos = { "oros", "copas", "espadas", "bastos"};
	//Array que contiene los numeros de las cartas
	final static int[] cartas = {1,2,3,4,5,6,7,8,9,10};
	//Nombre del jugador 1
	final static String j1 = "JUGADOR 1";
	//Nombre del jugador 2
	final static String j2 = "JUGADOR 2";
	//Array que contiene las cartas duplicadas
	static int[] duplicados = new int [1];
	//Booleano que indica si la carta es repetida
	static boolean duplicado = true;
	//Scanner nombrado "sc"
	static Scanner sc = new Scanner(System.in);
	
	//Funcion del juego
	static double juego(double pj) {
		//Parametro que almacena la aleccion del jugador
		String eleccion = "s";
		//Parametro que almacena un número random de la lista de palos
		int randompalos;
		//Parametro que almacena un número random de la lista de nº de cartas
		int randomcartas;
		
		System.out.println();
		//Bucle que se repetira mientras el jugador quiera más cartas introduciendo "s" y tenga menos o igual a 7,5 puntos
		while(eleccion.equals("s")&&pj<=7.5) {
			System.out.println();
			//Pregunta al jugador si quiere más cartas
			System.out.print("¿Quieres sacar una carta (s/n)? ");
			//Guarda en el parametro eleccion la respuesta del usuario
			eleccion = sc.next();
			//si la respuesta es "s", continua con el programa
			if(eleccion.equals("s")) {
				//Genera numeros random con un maximo a la longitud de los arrays correspondientes y los guarda en su parametro correspondiente
				randompalos = (int) (Math.random()*palos.length);
				randomcartas = (int) (Math.random()*cartas.length);
				//Comprueba si está repetida
				Funcion.descartes(randompalos, randomcartas);
				//Si no está repetida, continua
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
			//Si es otra respuesta y no es "n", salta un error
			if(!eleccion.equals("n")&&!eleccion.equals("s")) {
				System.out.println("ERROR: Valor introducido no valido");
				eleccion = "s";
			}
		}
		System.out.println();
		//Devuelve los puntos
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
