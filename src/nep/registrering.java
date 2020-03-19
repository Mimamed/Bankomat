package nep;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class registrering extends JPanel
{
    static JLabel användarNamn = new JLabel("Skriv namn"), losen = new JLabel("Skriv ditt Lösenord"), felmedelande = new JLabel("aaaaaaaaaaaaaaaaaaaaaaaaaaaa"), titel = new JLabel("Registrering"), losen2 = new JLabel("Skriv lösen igen");
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
        felmedelande.setBounds(skrivNamn.getX(), skrivNamn.getY() + 200, 400, skrivNamn.getHeight());
        skrivLosen2.setBounds(skrivLosen.getX(), skrivLosen.getY() + 60, skrivLosen.getWidth(), skrivLosen.getHeight());
        losen2.setBounds(skrivLosen.getX(), skrivLosen.getY() + 30, skrivLosen.getWidth(), skrivLosen.getHeight());
        regKnapp.setBounds(skrivLosen2.getX(), skrivLosen2.getY() + 40, 95, 30);
        tillbakaKnapp.setBounds(skrivLosen2.getX() + 105, skrivLosen2.getY() + 40, 95, 30);

        titel.setForeground(Color.orange);
        felmedelande.setForeground(Color.red);
        titel.setFont(new Font(Font.DIALOG, Font.BOLD, 30));
        regKnapp.addActionListener(new reg());
        tillbakaKnapp.addActionListener(new tillbak());

    }

    //public static  checkarBokstaver()

    static boolean checkar()
    {
        if (skrivNamn.getText().equals("") || skrivLosen.getText().equals("") || skrivLosen2.getText().equals(""))
        {
            felmedelande.setText("Fyll i fältena!");
            return false;
        }
        else
        {
            if (!skrivLosen.getText().equals(skrivLosen2.getText()))
            {
                felmedelande.setText("Lösenorden stämmer inte överens med varandra");
                return false;
            }
            else
            {
                if (skrivNamn.getText().length() < 4 && skrivLosen.getText().length() < 8)
                {
                    felmedelande.setText("För kort namn/lösenord");
                    return false;
                }
                else
                {
                    //for (int i = 0; i < )
                    return true; //tillälligt
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

        }

    }

    static class tillbak implements ActionListener
    {

        public void actionPerformed(ActionEvent actionEvent)
        {
            System.out.println("llllllllllllllllllll");
            dsf.byta(dsf.startMenu);
            skrivNamn.setText("");
            skrivLosen.setText("");
            skrivLosen2.setText("");
        }
    }

}
