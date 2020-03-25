package nep;

public class Konto
{

    public String användarnamn, losenord;
    float pengar;

    Konto(String namn, String losen, float pengar)
    {
        användarnamn = namn;
        losenord = losen;
        this.pengar = pengar;
    }

}
