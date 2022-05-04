package RPG;

public class Pot_Vida extends Pocion
{
    private int HP;
    public Pot_Vida(int curo, boolean grande)
    {
        super(curo, grande);
    }
    public Pot_Vida(int curo)
    {
        super(curo);
    }
    
    
    public static int usarpocion(Player jugador, Inventario inv, boolean big, int aumento)
    {
    	int stock = 0;
    	if (big == true)
    	{
    		if (inv.HPgrande - 1 < 0)
    		{
    			Main.nohay(jugador , "Pociones de vida grandes");
    		}
    		else
    		{
    			inv.HPgrande -=1;
    			if (jugador.vida + aumento >= jugador.HpMax)
    	    	{
    				jugador.vida = jugador.HpMax;
    	    	}
    	    	else
    	    	{
    	    		jugador.vida += aumento;
    	    	}
    		}
    		stock = inv.HPgrande;
    	}
    	else
    	{
    		if (inv.HPjr - 1 < 0)
    		{
    			Main.nohay(jugador , "Pociones de vida grandes");
    		}
    		else
    		{
    			inv.HPjr -=1;
    		}
    		stock = inv.HPjr;
    	}
    	return stock;
    }
}
