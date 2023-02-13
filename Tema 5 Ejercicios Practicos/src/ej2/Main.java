package ej2;

public class Main {

	public static void main(String[] args) {
		//Puntos de los jugadores
		double p1 = 0;
		double p2 = 0;
		
		//Bienvenida al juego
		System.out.println("Bienvenid@ al juego del Siete y Medio, te explico las reglas:\n 1. Busca a alguien con quien jugar"+
		"\n 2. El primer jugador va a pedir cartas hasta llegar o aproximarse al 7,5\n 3. El segundo jugador hará lo mismo"+
		"\n 4 Gana quien se acerque más al 7,5 y si te pasas pierdes"+
		"\nEs un juego basado en la baraja española así que la sota, el caballo y el rey valen 0,5");
		
		//Mensaje para empezar
		System.out.println("\n"+ "\033[1;36m"+"EMPEZEMOS!!!!");
		//Resetear el color
		System.out.println("\033[0m");
		
		//Turno del jugador 1
		System.out.println("Es el turno del "+Funcion.J1);
		p1 = Funcion.juego(p1);
		//Si ha terminado con menos o igual a 7,5 puntos
		if(p1<=7.5) {
			//Turno del jugador 2
			System.out.println("Es el turno del "+Funcion.J2);
			p2 = Funcion.juego(p2);
			//Si el jugador 2 ha sacado más de 7,5 gana el jugador 1
			if(p2>7.5) {
				System.out.println("\033[0;32m" + "Enhorabuena" + "\033[0m"+ ", "+ Funcion.J1+", ha ganado la partida");
			}
			//En otro caso
			else {
				//Si el jugador 2 tiene más puntos que el jugador 1, gana el jugador 2
				if(p2>p1) {
					System.out.println("\033[0;32m" + "Enhorabuena" + "\033[0m"+ ", "+ Funcion.J2+", ha ganado la partida");
				}
				//Si el jugador 1 tiene más puntos que el jugador 2, gana el jugador 1
				else if(p2<p1) {
					System.out.println("\033[0;32m" + "Enhorabuena" + "\033[0m"+ ", "+ Funcion.J1+", ha ganado la partida");
				}
				//Si tienen los mismos puntos, hay un empate
				else {
					System.out.println("EMPATE!!!");
				}
			}
		}
		//Si el jugador 1 ha sacado más de 7,5 gana el jugador 2
		else {
			System.out.println("\033[0;32m" + "Enhorabuena" + "\033[0m"+ ", "+ Funcion.J2+", ha ganado la partida");
		}
	}

}
