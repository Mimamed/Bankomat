package nep;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class registrering extends JPanel
{
    static JLabel användarNamn = new JLabel("Skriv namn"), losen = new JLabel("Skriv ditt Lösenord"), felmedelande = new JLabel(""), titel = new JLabel("Registrering"), losen2 = new JLabel("Skriv lösen igen");
    static JTextField skrivLosen = new JTextField(), skrivNamn = new JTextField(), skrivLosen2 = new JTextField();
    static JButton regKnapp = new JButton("Registrera"), tillbakaKnapp = new JButton("Tillbaka");

    registrering()
    {
        this.setBackground(Color.gray);
        this.setLayout(null);

        this.add(användarNamn);
        this.add(losen);
        this.add(skrivNamn);
        this.add(skrivLosen);
        this.add(felmedelande);
        this.add(titel);
        this.add(skrivLosen2);
        this.add(regKnapp);
        this.add(losen2);
        this.add(tillbakaKnapp);

        titel.setBounds(160, 0, 400, 50);
        skrivNamn.setBounds(titel.getX(), 100, 200, 30);
        skrivLosen.setBounds(skrivNamn.getX(), skrivNamn.getY() + 70, skrivNamn.getWidth(), skrivNamn.getHeight());
        användarNamn.setBounds(skrivNamn.getX(), skrivNamn.getY() - 30, 150, 25);
        losen.setBounds(skrivLosen.getX(), skrivLosen.getY() - 30, skrivLosen.getWidth(), 30);
        felmedelande.setBounds(skrivNamn.getX(), skrivNamn.getY() + 200, 400, skrivNamn.getHeight() + 20);
        skrivLosen2.setBounds(skrivLosen.getX(), skrivLosen.getY() + 60, skrivLosen.getWidth(), skrivLosen.getHeight());
        losen2.setBounds(skrivLosen.getX(), skrivLosen.getY() + 30, skrivLosen.getWidth(), skrivLosen.getHeight());
        regKnapp.setBounds(skrivLosen2.getX(), skrivLosen2.getY() + 40, 95, 30);
        tillbakaKnapp.setBounds(skrivLosen2.getX() + 125, skrivLosen2.getY() + 40, 95, 30);

        titel.setForeground(Color.orange);
        felmedelande.setForeground(Color.red);
        felmedelande.setFont(new Font(Font.DIALOG, Font.BOLD, 18));
        titel.setFont(new Font(Font.DIALOG, Font.BOLD, 30));
        regKnapp.setFocusPainted(false);
        tillbakaKnapp.setFocusPainted(false);

        regKnapp.addActionListener(new reg());
        tillbakaKnapp.addActionListener(new tillbak());

    }

    //public static  checkarBokstaver()

    static boolean checkar()
    {
        if (skrivNamn.getText().equals("") || skrivLosen.getText().equals("") || skrivLosen2.getText().equals(""))
        {
            felmedelande.setForeground(Color.red);
            felmedelande.setText("Fyll i fältena!");
            return false;
        }
        else
        {
            if (!skrivLosen.getText().equals(skrivLosen2.getText()))
            {
                felmedelande.setForeground(Color.red);
                felmedelande.setText("<html>Lösenorden stämmer inte <br/>överens med varandra</html>");
                return false;
            }
            else
            {
                if (skrivNamn.getText().length() < 4 && skrivLosen.getText().length() < 8)
                {
                    felmedelande.setForeground(Color.red);
                    felmedelande.setText("För kort namn/lösenord");
                    return false;
                }
                else
                {
                    boolean finnsSiffra = false, finnsBokstav = false;

                    for (int i = 0; i < skrivLosen.getText().length(); i++)
                    {
                        char teken = skrivLosen.getText().charAt(i);
                        boolean rättTecken = false;

                        if (finnsSiffra == false && Character.isDigit(teken))
                        {
                            finnsSiffra = true;
                        }
                        else if (finnsBokstav == false && Character.isAlphabetic(teken))
                        {
                            finnsBokstav = true;
                        }
                        else if (!Character.isDigit(teken) && !Character.isAlphabetic(teken))
                        {
                            felmedelande.setForeground(Color.red);
                            felmedelande.setText("Inga konstiga tecken som \"" + teken + "\"");
                            return false;
                        }
                    }

                    if (!finnsSiffra || !finnsBokstav)
                    {
                        felmedelande.setForeground(Color.red);
                        felmedelande.setText("<html>Ha med både bokstäver och <br/>siffror, det är ett krav</html>");
                        return false;
                    }
                    else
                    {
                        for (int i = 0; i < Huvudklas.konton.size(); i++)
                        {
                            if (skrivNamn.getText().equals(Huvudklas.konton.get(i).användarnamn))
                            {
                                felmedelande.setForeground(Color.red);
                                felmedelande.setText("<html>Användarnamnet redan taget, <br/>välj annat</html>");
                                return false;
                            }
                        }
                        return true;
                    }
                }
            }
        }
    }

    static class reg implements ActionListener
    {
        public void actionPerformed(ActionEvent actionEvent)
        {
            System.out.println("lksajdlkjdsa");
            System.out.println(checkar());
            if (checkar())
            {
                felmedelande.setForeground(Color.green);
                felmedelande.setText("<html>Grattis! Kontot är skapad. <br/>Gå tillbaka för att logga in</html>");
                Huvudklas.konton.add(new Konto(skrivNamn.getText(), skrivLosen.getText(), 0));
                skrivNamn.setText("");
                skrivLosen.setText("");
                skrivLosen2.setText("");
            }
        }

    }

    static class tillbak implements ActionListener
    {

        public void actionPerformed(ActionEvent actionEvent)
        {
            System.out.println("llllllllllllllllllll");
            Huvudklas.byta(Huvudklas.startMenu);
            skrivNamn.setText("");
            skrivLosen.setText("");
            skrivLosen2.setText("");
            felmedelande.setText("");
            felmedelande.setForeground(Color.red);
        }
    }

}
