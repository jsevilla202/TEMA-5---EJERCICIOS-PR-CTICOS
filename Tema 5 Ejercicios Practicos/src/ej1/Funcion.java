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
		int pos;
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println();
			System.out.print("Inserta un número del 1 al 20:");
			pos = sc.nextInt();
		}
		while(t[pos]!='*');
	}
	
}
