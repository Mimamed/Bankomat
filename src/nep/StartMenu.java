package nep;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartMenu extends JPanel
{
    static JLabel namnLabel = new JLabel("Användarnamn"), losenLabel = new JLabel("Lösenord"), titel = new JLabel("Välkommen"), felmedelande = new JLabel();
    static JTextField namnArea = new JTextField(), losenArea = new JTextField();
    static JButton registrera = new JButton("Skapa Konto");

    StartMenu()
    {


        this.setLayout(null);
        this.setBackground(Color.gray);

        this.add(namnLabel);
        this.add(losenLabel);
        this.add(namnArea);
        this.add(losenArea);
        this.add(titel);
        this.add(felmedelande);
        this.add(registrera);


        titel.setFont(new Font(Font.DIALOG, Font.BOLD, 40));
        titel.setForeground(Color.orange);
        felmedelande.setFont(new Font(Font.DIALOG, Font.BOLD, 15));
        felmedelande.setForeground(Color.red);
        registrera.setFocusPainted(false);


        titel.setBounds(135, 10, 400, 80);
        namnArea.setBounds(170, 120, 150, 30);
        losenArea.setBounds(namnArea.getX(), namnArea.getY() + 70, namnArea.getWidth(), namnArea.getHeight());
        namnLabel.setBounds(namnArea.getX(), namnArea.getY() - 30, 150, 25);
        losenLabel.setBounds(losenArea.getX(), losenArea.getY() - 30, losenArea.getWidth(), 30);
        registrera.setBounds(namnArea.getX(), namnArea.getY() + 100, namnArea.getWidth(), namnArea.getHeight());
        felmedelande.setBounds(namnArea.getX() - 50, namnArea.getY() + 130, 400, 30);

        registrera.addActionListener(new registreraKnapp());
        namnArea.addKeyListener(new Huvudklas.EnterLyssnaren());
        losenArea.addKeyListener(new Huvudklas.EnterLyssnaren());
    }

    public static void checka()
    {
        boolean felLösenord= true;
        if (namnArea.getText().length() == 0 || losenArea.getText().length() == 0)
        {
            felmedelande.setText("Fyll i fällterna");
        }
        else
        {
            for (int i = 0; i < Huvudklas.konton.size(); i++)
            {
                if(Huvudklas.konton.get(i).användarnamn.equals(namnArea.getText()) && Huvudklas.konton.get(i).losenord.equals(losenArea.getText()))
                {
                    felLösenord = false;
                    felmedelande.setText("");
                    //gå vidare till kontot!!
                    System.out.println("Inloggad");
                    Huvudklas.huvudMenu.nyttKonto(namnArea.getText());
                    Huvudklas.byta(Huvudklas.huvudMenu);
                }
            }
            if (felLösenord == true)
            {
                felmedelande.setText("Fel lösenord/användarnamn, försök igen");
            }
        }
        for (int i = 0; i < Huvudklas.konton.size(); i++)
        {
            System.out.println(Huvudklas.konton.get(i).användarnamn + " : " + Huvudklas.konton.get(i).losenord);
        }
    }

    static class registreraKnapp implements ActionListener
    {
        public void actionPerformed(ActionEvent actionEvent)
        {
            namnArea.setText("");
            losenArea.setText("");
            Huvudklas.byta(Huvudklas.signup);
        }
    }

}
