package nep;

public class Konto
{

    public static String användarnamn, losenord;
    static float pengar;

    Konto(String namn, String losen, float pengar)
    {
        användarnamn = namn;
        losenord = losen;
        this.pengar = pengar;
    }

}
