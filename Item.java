package RPG;
public class Item {
	double ataque;
	double defensa;
	double vida;
	double mana;
	String name;
	boolean sien;
	public Item()
	{}
	public Item (String nombre, double atk, double def, double Hp,double Mp, boolean sirve) {
		ataque = atk;
		defensa = def;
		vida = Hp;
		mana = Mp;
		sien = sirve;
		name = nombre;
	}
}
//daisy tomta
