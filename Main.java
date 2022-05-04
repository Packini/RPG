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
		System.out.println("BIENVENIDO A LA SIMULACION DE PELEA \nEscribe tu nombre: ");
		String name = funcs.leerstr();
		
		//DECISION PARA FUERTE CONTRA & DEBIL CONTRA
		//mago duplica su daño vs guerrero 
		//guerrero duplica su daño vs Arquero
		//arquero duplica su daño vs mago
		//arquero = 1, mago = 2, guerrero = 3
		int chingo;
		int mechinga;

		//Afirmacion del rol que escogio
		System.out.println("Bien, ahora escribe que rol deseas jugar:");

		/*IBA A "OPTIMIZAR PERO YA ESTA BIEN, LOL"*/
		do {
			System.out.println(" 1. ARQUERO \n 2. MAGO \n 3. GUERRERO");
			r = s.nextInt();
			switch (r) {
			case 1:
				chingo = 2;
				mechinga = 3;
				System.out.println("HAS ESCOGIDO ARQUERO");
				player = new Arquero(name, "Arquero", 200, 150, 200, 30, chingo, mechinga, true);
				break;
			case 2:
				chingo = 3;
				mechinga = 1;
				System.out.println("HAS ESCOGIDO MAGO");
				player = new Mago(name, "Mago", 200, 400, 150, 20, chingo, mechinga, true);
				break;
			case 3:
				chingo = 1;
				mechinga = 2;
				System.out.println("HAS ESCOGIDO GUERRERO");
				player = new Guerrero(name, "Guerrero", 250, 100, 85, 80, chingo, mechinga, true);
				break;
			default:
				System.out.println("ESCOGE UN ROL PARA AVANZAR");
				break;
			}
		}while (r != 1 && r != 2 && r != 3);
		//QUE NO ME LLAMO VAGINA CABRON
		// asies, hablo de esto XDDDDDD https://www.youtube.com/watch?v=zbE_QwyrOZU
		//no ya en serio, ponerle name al rival
		System.out.print("\nOH GENIAL... ahora ponle nombre a tu oponente\n");
		String nameop = funcs.leerstr();

		//ESCOGER ROL DEL OPONENTE
		System.out.println("ESCOGE EL ROL DE TU OPONENTE");
		int z;
		//CONFIRMACION DEL ROL DEL OPONENTE
		do {
				System.out.println(" 1. ARQUERO \n 2. MAGO \n 3. GUERRERO");
				z = s.nextInt();
				switch (z) {
				case 1:
					chingo = 2;
					mechinga = 3;
					System.out.println("HAS ESCOGIDO ARQUERO");
					oponente = new Arquero(nameop, "Arquero", 200, 150, 200, 30, chingo, mechinga, false);
					break;
				case 2:
					chingo = 3;
					mechinga = 1;
					System.out.println("HAS ESCOGIDO MAGO");
					oponente = new Mago(nameop, "Mago", 200, 400, 150, 20, chingo, mechinga, false);
					break;
				case 3:
					chingo = 1;
					mechinga = 2;
					System.out.println("HAS ESCOGIDO GUERRERO");
					oponente = new Guerrero(nameop, "Guerrero", 250, 100, 85, 80, chingo, mechinga, false);
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
		System.out.println("Ponle nombre");
		String arma = funcs.leerstr();
		boolean efect = false;
		switch (r) {
		case 1: 
		if (player.rol == "Arquero"){efect = true;}
			item = new Arco(arma, 70, 10, 100, 50, efect);
		case 2: 
			if (player.rol == "Guerrero"){efect = true;}
			item = new Hacha(arma, 50, 50, 200, 70, efect);
		case 3:
			if (player.rol == "Mago"){efect = true;}
			item = new Baston(arma, 100, 20, 150, 200, efect);
		}
		player.Equipar(item);
		
		do {
			System.out.println("- SELECCIONA TU PROXIMO MOVIMIENTO");
			System.out.println(" 1- ATACAR\n 2- TOMAR POCION CURATIVA\n 3- TOMAR POCION DE MANA");
			
			//ELEGIR QUE HARA NUESTRO PERSONAJE
			c = a.nextInt();
			if (c == 1) {
				player.Atacar(oponente);
			} else if (c == 2) {
				
				player.TomarPocionCuradora();
			}else if (c == 3) {
				player.TomarPocionMana();
			}
			
			//RANDOMIZAR ACCION DEL OPONENTE EN BASE A PROBABILIDAD
			int rdm = funcs.randomizar(100);
			if (rdm > 70) {
				oponente.Atacar(player);
			}else if (rdm <71 && rdm > 40) {
				oponente.TomarPocionCuradora();
			}else if (rdm <41) {
				oponente.TomarPocionMana();
				System.out.println(oponente.mana);
			}
		}while (oponente.vida > 0 && player.vida > 0);
		System.out.println("HA TERMINADO EL COMBATE\n EL GANADOR ES: ");
		if (oponente.vida <= 0) {
			System.out.println(player.nombre);
		}else {
			System.out.println(oponente.nombre);
		}
	}
	public static void nohay(Player jugador, String item)
	{
		System.out.println(jugador.nombre + "no tiene " + item);
	}
}

