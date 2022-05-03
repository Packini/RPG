 package RPG;
import java.util.Scanner;
import java.io.IOException;

public class Main {
	
	public static void main(String args[]) throws IOException {
		Scanner s = new Scanner(System.in);
		Scanner o = new Scanner(System.in);
		Scanner a = new Scanner(System.in);
		
		//roles
									//rol, HP, MP, ATK, DEF
		Player player = null;			
		Player oponente = null;
		//Items
						//atk, def, vida, mana
		Item item = null;
		
		int r;
		System.out.println("BIENVENIDO A LA SIMULACION DE PELEA \nEscoge tu rol en el juego: ");
		//Afirmacion del rol que escogio
		do {
			System.out.println(" 1. ARQUERO \n 2. MAGO \n 3. GUERRERO");
			r = s.nextInt();
			switch (r) {
			case 1:
				System.out.println("HAS ESCOGIDO ARQUERO");
				player = new Arquero("Arquero", 200, 150, 200, 30);
				break;
			case 2:
				System.out.println("HAS ESCOGIDO MAGO");
				player = new Mago("Mago", 200, 400, 150, 20);
				break;
			case 3:
				System.out.println("HAS ESCOGIDO GUERRERO");
				player = new Guerrero( "Guerrero", 250, 100, 85, 80);
				break;
			default:
				System.out.println("ESCOGE UN ROL PARA AVANZAR");
				break;
			}
		}while (r != 1 && r != 2 && r != 3);
		
		//ESCOGER ROL DEL OPONENTE
		System.out.println("ESCOGE EL ROL DE TU OPONENTE");
		int z;
		//CONFIRMACION DEL ROL DEL OPONENTE
		do {
			System.out.println(" 1. ARQUERO \n 2. MAGO \n 3. GUERRERO");
			z = o.nextInt();
			switch (z) {
			case 1:
				System.out.println("HAS ESCOGIDO ARQUERO");
				oponente = new Arquero("Arquero", 200, 100, 300, 30);;
				break;
			case 2:
				System.out.println("HAS ESCOGIDO MAGO");
				oponente = new Mago("Mago", 200, 400, 150, 20);			
				break;
			case 3:
				System.out.println("HAS ESCOGIDO GUERRERO");
				oponente = new Guerrero( "Guerrero", 220, 100, 85, 40);
				break;
			default:
				System.out.println("ESCOGE UN ROL PARA AVANZAR");
				break;
			}
		}while (z != 1 && z != 2 && z != 3);
		
		//INICIA EL COMBATE!!
		
		int c;
		System.out.println("HA INICIADO EL COMBATE");
		System.out.println("EQUIPATE UN ARMA\n 1- ARCO\n 2- HACHA\n 3- BASTON");
		r = s.nextInt();
		switch (r) {
		case 1: 
			item = new Arco(70, 10, 100, 50);
		case 2: 
			item = new Hacha(50, 50, 200, 70);
		case 3:
			item = new Baston(100, 20, 150, 200);
		}
		player.Equipar(item);
		
		do {
			System.out.println("- SELECCIONA TU PROXIMO MOVIMIENTO");
			System.out.println(" 1- ATACAR\n 2- TOMAR POCION CURATIVA\n 3- TOMAR POCION DE MANA");
			c = a.nextInt();
			if (c == 1) {
				player.Atacar(oponente);
			} else if (c == 2) {
				player.TomarPocionCuradora();
			}else if (c == 3) {
				player.TomarPocionMana();
			}
			
			
			int rdm = (int) (Math.random()*(1-4)+4);
			if (rdm == 1) {
				oponente.Atacar(player);
			}else if (rdm == 2) {
				oponente.TomarPocionCuradora();
			}else if (rdm == 3) {
				oponente.TomarPocionMana();
				System.out.println(oponente.mana);
			}
		}while (oponente.vida > 0 && player.vida > 0);
		System.out.println("HA TERMINADO EL COMBATE\n EL GANADOR ES: ");
		if (oponente.vida <= 0) {
			System.out.println("PLAYER");
		}else {
			System.out.println("OPONENTE");
		}
	}
}
