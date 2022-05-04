package RPG;
public class Inventario
{
    public String arm;
    public int tipoarma;
    public int HPgrande;
    public int HPjr;
    public int MPgrande;
    public int MPc;
    //Crearle inventario a mi compita :v
    public Inventario()
    {}
    public Inventario(String arma, int tipoarma, int HP, int hp, int MP, int mp)   
    {
        arm = arma;
        HPgrande = HP;
        HPjr = hp;
        MPgrande = MP;
        MPc = mp; 
    } 
    public void ver_inventario(int usos){
        System.out.println("Tienes un " + arm + " que tiene " + usos + " usos disponibles\nTienes:\nPocion de Mana Grande:" 
        + MPgrande + "\nPocion de Mana:" + MPc + "\nPocion de Vida Grande:" + HPgrande + "\nPocion de Vida:" + HPjr);
    }
    /*
    public static void main(String[] args)
    {
        Inventario playerita = new Inventario("HACHA GAY", 2, 6, 0, 6);
        playerita.ver_inventario(7);
    }
    */
}
