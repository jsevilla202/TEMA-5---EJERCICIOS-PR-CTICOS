 package ej1;
 
import java.util.Arrays;
import java.util.Scanner;

public class Funcion {
	char[] minas(char[] t) {
		char tabla[] = new char [t.length];
		final int limite = 6;
		int pos;
		for(int i = 0; i<limite; i++) {
			pos = (int) (Math.random()*20);
			
			if(tabla[pos] == '*') {
				i--;
			}
			else {
				tabla[pos] = '*';
				if(pos!=tabla.length-1) {
					if(tabla[pos+1] != '*') {
						tabla[pos+1] = '1';
					}
				}
				if(pos!=0) {
					if(tabla[pos-1] != '*') {
						tabla[pos-1] = '1';
					}
			}
		}
		}
		
		for(int i = 1; i<tabla.length-1; i++) {
			if(tabla[i-1]=='*'&&tabla[i+1]=='*'&&tabla[i]!='*') {
				tabla[i]='2';
			}
		}
		for(int i = 0; i<tabla.length; i++) {
			if(tabla[i]!='*'&&tabla[i]!='1'&&tabla[i]!='2') {
				tabla[i]='0';
			}
		}
		System.out.println(Arrays.toString(tabla));
		return tabla;
	}
	
	void juego(char[] t) {
		char[] tabla = new char [t.length];
		Arrays.fill(tabla, '?');
		boolean muerto = false;
		int pos;
		int i = 0;
		Scanner sc = new Scanner(System.in);
		
		do {
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
			System.out.println(Arrays.toString(tabla));
			i++;
		}
		while(t[pos]!='*');
		sc.close();
		System.out.println();
		System.out.println(muerto? "\033[0;1m" + "\033[31;1;1mPERDISTES, UNA MINA TE HA MATADO\033[0m" : "\033[0;1m" + "\033[32;1;1mENHORABUENA, HAS GANADO!!\033[0m");
	}
	
}
