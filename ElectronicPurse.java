public class ElectronicPurse
{
    
    private double solde;
    private String pin;
    private final int ESSAIS_MAX;
    private int essaisRestants;
    private boolean bloque;

    public ElectronicPurse(double soldeInit)
    {
        this.ESSAIS_MAX = 3;
        this.pin = generatePin();
        this.bloque = false;
        this.solde = soldeInit;
        this.essaisRestants = this.ESSAIS_MAX;

        Ecran.afficherln("Code carte : " + this.pin);
    }

    public ElectronicPurse()
    {
        this.ESSAIS_MAX = 3;
        this.pin = generatePin();
        this.bloque = false;
        this.solde = 0;
        this.essaisRestants = 3;

        Ecran.afficherln("Code carte : " + this.pin);
    }

    //génération code PIN dans le constructeur
    private static String generatePin()
    {
        int a = (int)(Math.random() * 10);
        int b = (int)(Math.random() * 10);
        int c = (int)(Math.random() * 10);
        int d = (int)(Math.random() * 10);
        String code = String.format("%d%d%d%d", a, b, c, d );
        // String.format("%d%d%d%d", a, b, c, d);
        return code;
    }

    private boolean saisiePin()
    {
        boolean reussi = true;
        String saisie = "";
        
        while(this.essaisRestants > 0 && !(saisie.equals(this.pin)) && this.bloque == false)
        {
            Ecran.afficher("Saisir PIN : ");
            saisie = Clavier.saisirString();
            if(saisie.equals(this.pin))
            {
                this.essaisRestants = 0;
                Ecran.afficherln("Code bon !");
                reussi = true;
            }
            else
            {
                this.essaisRestants--;
                reussi = false;
                Ecran.afficherln("Code erroné " + this.essaisRestants + " essais restants.");
                if(this.essaisRestants <= 0)
                {
                    this.bloque = true;
                    Ecran.afficherln("Carte bloquée.");
                }
            }
            if(reussi == true)
            {
                this.essaisRestants = 3;
            }
        }
        return reussi;
    }

    public void credit(double montantSup)
    {
        boolean verif = saisiePin();
        if(this.bloque == false && montantSup >= 0  && verif == true)
        {
            Ecran.afficherln("Vous venez de créditer " + montantSup + " euros.");
            this.solde = this.solde + montantSup;
        }
        else
        {
            Ecran.afficherln("Crédit impossible.");
        }
    }

    public void debit(double montantPay)
    {
        boolean verif = saisiePin();
        if(this.bloque == false && montantPay <= this.solde && verif == true)
        {
            Ecran.afficherln("Vous venez de débiter " + montantPay + " euros.");
            this.solde = this.solde - montantPay;
        }
        else
        {
            Ecran.afficherln("Débit impossible.");
        }
    }

    public String toString()
    {
        return "Votre solde est de " + this.solde + " euros.\n";
    }
}
