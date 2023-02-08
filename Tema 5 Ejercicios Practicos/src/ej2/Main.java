package ej2;

public class Main {

	public static void main(String[] args) {
		double p1 = 0;
		double p2 = 0;
		
		System.out.println("Bienvenid@ al juego del Siete y Medio, te explico las reglas:\n 1. Busca a alguien con quien jugar"+
		"\n 2. El primer jugador va a pedir cartas hasta llegar o aproximarse al 7,5\n 3. El segundo jugador hará lo mismo"+
		"\n 4 Gana quien se acerque más al 7,5 y si te pasas pierdes"+
		"\nEs un juego basado en la baraja española así que la sota, el caballo y el rey valen 0,5");
		
		System.out.println("\n"+ "\033[1;36m"+"EMPEZEMOS!!!!");
		System.out.println("\033[0m");
		
		System.out.println("Es el turno del "+Funcion.j1);
		p1 = Funcion.juego(p1);
		if(p1<=7.5) {
			System.out.println("Es el turno del "+Funcion.j2);
			p2 = Funcion.juego(p2);
			if(p2>7.5) {
				System.out.println("\033[0;32m" + "Enhorabuena" + "\033[0m"+ ", "+ Funcion.j1+", ha ganado la partida");
			}
			else {
				if(p2>p1) {
					System.out.println("\033[0;32m" + "Enhorabuena" + "\033[0m"+ ", "+ Funcion.j2+", ha ganado la partida");
				}
				else if(p2<p1) {
					System.out.println("\033[0;32m" + "Enhorabuena" + "\033[0m"+ ", "+ Funcion.j1+", ha ganado la partida");
				}
				else {
					System.out.println("EMPATE!!!");
				}
			}
		}
		else {
			System.out.println("\033[0;32m" + "Enhorabuena" + "\033[0m"+ ", "+ Funcion.j2+", ha ganado la partida");
		}
	}

}
