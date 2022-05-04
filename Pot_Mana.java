package RPG;
public class Pot_Mana extends Pocion
{
    public Pot_Mana(int dando, boolean grande)
    {
        super(dando, grande);
    }
    public Pot_Mana(int dando)
    {
    	super(dando);
    }
    
    
    public static int usarpocion(Player jugador, Inventario inv, boolean big, int aumento)
    {
    	int stock = 0;
    	if (big == true)
    	{
    		if (inv.MPgrande - 1 < 0)
    		{
    			Main.nohay(jugador , "Pociones de vida grandes");
    		}
    		else
    		{
    			inv.MPgrande -=1;
    			if (jugador.mana + aumento >= jugador.MpMax)
    	    	{
    				jugador.mana = jugador.MpMax;
    	    	}
    	    	else
    	    	{
    	    		jugador.mana += aumento;
    	    	}
    		}
    		stock = inv.MPgrande;
    	}
    	else
    	{
    		if (inv.MPc - 1 < 0)
    		{
    			Main.nohay(jugador , "Pociones de vida grandes");
    		}
    		else
    		{
    			inv.MPc -=1;
    		}
    		stock = inv.MPc;
    	}
    	return stock;
    }
}
