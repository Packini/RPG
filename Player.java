package RPG;
public class Player {
	Inventario inv = new Inventario();

	//STATS DEL PERSONAJE
	String rol;
	String nombre;
	double vida;
	double mana;
	double atk;
	double def;
	double HpMax; 
	double MpMax; 
	int mefriega;
	int melofriego;
	boolean real;
	public Player (String name, String clase, double Hp, double Mp, double ataque, double defensa, int legano, int megana, boolean jugador) {
		this.real = jugador;
		this.rol = clase;
		this.vida = Hp;
		this.mana = Mp;
		this.atk = ataque;
		this.def = defensa;	
		this.HpMax = vida;
		this.MpMax = mana;
		this.nombre = name;
		this.melofriego = legano;
		this.mefriega = megana;
	}
	public double calcularatk(Player opponent, double attack)
	{
		opponent.vida -= (this.atk / opponent.def);
		
		return opponent.vida;
	}
	public void Atacar(Player opponent) {
		if (calcularatk(opponent, opponent.atk)<= 0) {
			opponent.vida = 0;
			System.out.println("Has Derrotado a " + opponent.nombre);
			return;
		} else {
			if (this.mana >= 20) {
				this.mana = this.mana - 20;
				opponent.vida = opponent.vida - (this.atk / opponent.def);
				//mejore los outputs
				if (opponent.nombre == null)
				{System.out.println("HP de " + opponent.rol + ": " + String.format("%.02f",opponent.vida));}
				else
				{System.out.println("HP de " + opponent.nombre + " el " + opponent.rol + ": " + String.format("%.02f",opponent.vida));}
			} else {
				System.out.println("ataque fallado");
			}
		}
	}
	public void TomarPocionCuradora() {
		
		int r = Pot_Vida.preguntarsize();
		boolean a = false;
		if (r == 1) {a= true;Pocion heal = new Pocion(20, a); inv.HPgrande = Pot_Vida.usarpocion(this, this.inv, a, heal.tedoy);}
		else {Pocion heal = new Pocion(20); inv.HPjr = Pot_Vida.usarpocion(this, this.inv, a,  heal.tedoy);}
	}

	public void TomarPocionMana() {
		int r = Pot_Mana.preguntarsize();
		boolean a = false;
		if (r == 1) {a= true;Pocion heal = new Pocion(20, a); inv.HPgrande = Pot_Mana.usarpocion(this, this.inv, a, heal.tedoy);}
		else {Pocion heal = new Pocion(20); inv.HPjr = Pot_Mana.usarpocion(this, this.inv, a,  heal.tedoy);}
	}
	public void Equipar(Item ItemSelect) {
		double a = this.atk;
		double d = this.def;
		double h = this.HpMax;
		double m = this.MpMax;
		this.atk = this.atk + ItemSelect.ataque;
		this.def = this.def + ItemSelect.defensa;
		this.HpMax = this.HpMax + ItemSelect.vida;
		this.MpMax = this.HpMax + ItemSelect.mana;
		
		System.out.println("Ataque: " + a + " -> " + this.atk);
		System.out.println("Defensa: " + d+ " -> " + this.def);
		System.out.println("Vida: " + h + " -> " + this.HpMax);
		System.out.println("Mana: " + m + " -> " + this.MpMax);
		return;
	}
}
