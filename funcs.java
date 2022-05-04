package RPG;
import java.util.Scanner;
public class funcs
{
    public static int randomizar(int a)
    {
        int prob = (int) (Math.random()*a);
        return prob;
    }
    public static int leer()
    {
    	Scanner a = new Scanner(System.in);
    	int owo = a.nextInt();
    	return owo;
    }
    
    public static String leerstr()
    {
    	Scanner a = new Scanner(System.in);
    	String owo = a.nextLine();
    	return owo;
    }
}