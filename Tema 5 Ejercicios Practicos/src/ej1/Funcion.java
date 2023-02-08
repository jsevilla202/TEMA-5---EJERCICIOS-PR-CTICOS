 package ej1;
 
import java.util.Arrays;
import java.util.Scanner;

public class Funcion {
	//Establecemos un parametro para el límite de minas
	final int minas = 6;
	//Funcion minas
	char[] minas(char[] t) {
		//Crea una tabla con la misma longitud que la recibida
		char tabla[] = new char [t.length];
		//Parametro que recoge la posición aleatoria en la tabla
		int pos;
		//Rellenamos aleatoriamente celdas con minas
		for(int i = 0; i<minas; i++) {
			pos = (int) (Math.random()*20);
			//En caso de que en la celda escogida haya una mina, retrocede el contador
			if(tabla[pos] == '*') {
				i--;
			}
			//Si no es el caso, hace lo siguiente
			else {
				//Pone la mina
				tabla[pos] = '*';
				//Comprueba que no esté en la ultima posición
				if(pos!=tabla.length-1) {
					//Si no lo está, comprueba que no haya una mina en la posición siguiente
					if(tabla[pos+1] != '*') {
						//Si no la hay coloca en 1
						tabla[pos+1] = '1';
					}
				}
				//Comprueba que no esté en la primera posición
				if(pos!=0) {
					//Si no lo está, comprueba que no haya una mina en la posición anterior
					if(tabla[pos-1] != '*') {
						//Si no la hay coloca en 1
						tabla[pos-1] = '1';
					}
			}
		}
		}
		//Con este bucle corregiremos el error de 1 en la celdas rodeadas por minas
		for(int i = 1; i<tabla.length-1; i++) {
			//Comprueba que en la posición anterior y en la siguiente haya una mina y que en la posición no haya una mina
			if(tabla[i-1]=='*'&&tabla[i+1]=='*'&&tabla[i]!='*') {
				//Si se cumplen los requisitos, cambia el 1 por el 2
				tabla[i]='2';
			}
		}
		//Rellena los huecos vacios con 0
		for(int i = 0; i<tabla.length; i++) {
			//Comprueba que en esa posición no haya una mina, un 1 o un 2
			if(tabla[i]!='*'&&tabla[i]!='1'&&tabla[i]!='2') {
				//Si se cumplen los requisitos, pone un 0
				tabla[i]='0';
			}
		}
		//Devuelve la tabla
		return tabla;
	}
	
	//Funcion juego
	void juego(char[] t) {
		//Crea una tabla con la misma longitud que la recibida, esta tabla va a ser la que el usuario vea
		char[] tabla = new char [t.length];
		//La rellena con simbolos de interrogación
		Arrays.fill(tabla, '?');
		//Parametro que comprueba si el jugador ha muerto
		boolean muerto = false;
		//Parametro que recoge la posición introducida por el usuario
		int pos;
		//Contador
		int i = 0;
		//crea un Scanner y lo nombra "sc"
		Scanner sc = new Scanner(System.in);
		
		//Bucle del juego
		do {
			System.out.println();
			System.out.println(Arrays.toString(tabla));
			if(i==14) {
				break;
			}
			System.out.println();
			System.out.print("Inserta un número del 1 al 20: ");
			pos = sc.nextInt();
			pos--;
			if(t[pos]=='*') {
				muerto = true;
				break;
			}
			tabla[pos] = t[pos];
			i++;
		}
		while(t[pos]!='*');
		
		sc.close();
		System.out.println();
		System.out.println(muerto? "\033[0;1m" + "\033[31;1;1mPERDISTES, UNA MINA TE HA MATADO\033[0m" : "\033[0;1m" + "\033[32;1;1mENHORABUENA, HAS GANADO!!\033[0m");
	}
	
}
