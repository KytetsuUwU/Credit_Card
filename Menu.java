public class Menu 
{
    private static int choix;

    public Menu()
    {

    }

    private static void affichageMenu()
    {
        Ecran.afficherln("1. Consultation solde");
        Ecran.afficherln("2. Crédit");
        Ecran.afficherln("3. Débit");
        Ecran.afficherln("4. Quitter");
        Ecran.afficher("Choix : ");
    }
    
    public static void menuUtilisateur(Purse carte, double montantC, double montantD)
    {
        affichageMenu();
        setChoix();
        getChoix();
        Ecran.afficherln("");
        switch(choix)
        {
            case 1 : Ecran.afficherln(carte.toString()); break;
            case 2 : 
            {
                carte.credit(montantC);
                Ecran.afficherln(carte.toString());
            }
                break;
            case 3 :
            {
                carte.debit(montantD);
                Ecran.afficherln(carte.toString());
            }
                break;
            case 4 : 
            {
                Ecran.afficherln("Au revoir.");
                System.exit(01); 
            }
                break;
            default : System.exit(02); break;
        }
    }

    public static void setChoix()
    {
        choix = Clavier.saisirInt();
        while(choix < 1 && choix > 4)
        {
            choix = Clavier.saisirInt();
        }
    }
    
    public static int getChoix()
    {
        return choix;
    }

}
