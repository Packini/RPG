package RPG;
public class Pocion extends Item
{
	//ATRIBUTOS
    boolean size;
    int tedoy;
    //SOBRECARGA POTIS, si hay firma con bool, es grande y cura o da mas mana  
    public Pocion(int doy)
    {
    	tedoy = doy;
    }
    public Pocion(int doy, boolean esgrande)
    {
    	tedoy = doy+20;
    }
    
    public static int preguntarsize()
    {
    	System.out.print("Elige el tamaño de la pocion\n1-Grande\n2-Pequeño\n");;
    	int r = funcs.leer();
    	return r;
    }
    public static int preguntarsize(boolean esoponente)
    {
    	int r = funcs.randomizar(2);
    	return r;
    }
//
}