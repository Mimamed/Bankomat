package nep;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class tet extends JPanel
{
    static JLabel namnLabel = new JLabel("Användarnamn"), losenLabel = new JLabel("Lösenord"), titel = new JLabel("Välkommen"), felmedelande = new JLabel();
    static JTextField namnArea = new JTextField(), losenArea = new JTextField();
    static JButton registrera = new JButton("Skapa Konto");

    tet()
    {


        this.setLayout(null);

        this.add(namnLabel);
        this.add(losenLabel);
        this.add(namnArea);
        this.add(losenArea);
        this.add(titel);
        this.add(felmedelande);
        this.add(registrera);

        namnArea.addKeyListener(new dsf.EnterLyssnaren());
        losenArea.addKeyListener(new dsf.EnterLyssnaren());

        titel.setFont(new Font(Font.DIALOG, Font.BOLD, 40));
        felmedelande.setFont(new Font(Font.DIALOG, Font.BOLD, 15));
        felmedelande.setForeground(Color.red);


        felmedelande.setBounds(150, 230, 400, 30);
        titel.setBounds(135, 10, 400, 80);
        namnArea.setBounds(170, 120, 150, 30);
        losenArea.setBounds(namnArea.getX(), namnArea.getY() + 70, namnArea.getWidth(), namnArea.getHeight());
        namnLabel.setBounds(namnArea.getX(), namnArea.getY() - 30, 150, 25);
        losenLabel.setBounds(losenArea.getX(), losenArea.getY() - 30, losenArea.getWidth(), 30);
        registrera.setBounds(namnArea.getX(), namnArea.getY() + 100, namnArea.getWidth(), namnArea.getHeight());

        registrera.addActionListener(new registreraKnapp());
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
            for (int i = 0; i < dsf.konton.size(); i++)
            {
                if(dsf.konton.get(i).användarnamn.equals(namnArea.getText()) && dsf.konton.get(i).losenord.equals(losenArea.getText()))
                {
                    felLösenord = false;
                    felmedelande.setText(null);
                    //gå vidare till kontot!!
                    System.out.println("Inloggad");
                    dsf.huvudMenu.nyttKonto(namnArea.getText());
                    dsf.byta(dsf.huvudMenu);
                }
            }
            if (felLösenord == true)
            {
                felmedelande.setText("Fel lösenord/användarnamn, försök igen");
            }
        }
    }

    static class registreraKnapp implements ActionListener
    {

        public void actionPerformed(ActionEvent actionEvent)
        {
            dsf.byta(dsf.signup);
        }
    }

}