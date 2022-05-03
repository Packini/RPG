package RPG;
import RPG.Item;

public class Player {
	String rol;
	double vida;
	double mana;
	double atk;
	double def;
	double HpMax; 
	double MpMax; 
	
	public Player (String clase, double Hp, double Mp, double ataque, double defensa) {
		rol = clase;
		vida = Hp;
		mana = Mp;
		atk = ataque;
		def = defensa;	
		HpMax = vida;
		MpMax = mana;
	}
	
	public void Atacar(Player opponent) {
		if (opponent.vida <= 0) {
			System.out.println("Has Derrotado a " + opponent.rol);
			return;
		} else {
			if (this.mana > 0) {
				this.mana = this.mana - 20;
				opponent.vida = opponent.vida - (this.atk / opponent.def);
				System.out.println(opponent.rol + " Hp = " + String.format("%.02f",opponent.vida));
			} else {
				System.out.println("ataque fallado");
			}
		}
	}
	public void TomarPocionCuradora() {
		if (this.vida == this.HpMax) {
			System.out.println("Vida de " + this.rol + " lleno");;
		} else if (this.vida >= (this.HpMax - 20)) {
			this.vida = this.HpMax;
			System.out.println(this.rol + " se ha curado completamente");
		} else {
			this.vida = this.vida + 20;
			System.out.println(this.rol + " ha regenerado 20 de vida");
		}
	}

	public void TomarPocionMana() {
		if (this.mana == this.MpMax) {
			System.out.println("Mana de " + this.rol + " lleno");;
		} else if (this.mana >= this.MpMax - 20) {
			this.mana = this.MpMax;
			System.out.println(this.rol + " se ha recuperado completamente");
		} else {
			this.mana = this.mana + 20;
			System.out.println(this.rol + " ha regenerado 20 de mana");
		}
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
