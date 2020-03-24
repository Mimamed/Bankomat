package nep;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mena extends JPanel
{
    static JButton loggaUt = new JButton("Logga ut"), laggTill = new JButton("Lägg till pengar"), draUt = new JButton("Dra ut pengar");
    static JLabel pengar = new JLabel("Pengar"), summa = new JLabel("Summa"), konto = new JLabel("Konto"), money = new JLabel(), felmedelande = new JLabel();
    static JTextField pengarSkriv = new JTextField();
    static Konto kontot;
    static float cash;

    mena()
    {

        this.setLayout(null);
        this.setBackground(Color.gray);

        //läger till
        this.add(loggaUt);
        this.add(laggTill);
        this.add(konto);
        this.add(draUt);
        this.add(pengar);
        this.add(summa);
        this.add(money);
        this.add(pengarSkriv);
        this.add(felmedelande);

        laggTill.addActionListener(new knap1());
        draUt.addActionListener(new knap2());
        loggaUt.addActionListener(new knap3());

        loggaUt.setBounds(0,0,90,25);
        konto.setBounds(70, 20, 300, 80);
        pengar.setBounds(konto.getBounds().x + 10, konto.getBounds().y + 90, 150, 30);
        summa.setBounds(pengar.getBounds().x, pengar.getBounds().y + 60, pengar.getBounds().width, pengar.getBounds().height);
        money.setBounds(pengar.getBounds().x, pengar.getBounds().y + 20, pengar.getBounds().width, pengar.getBounds().height);
        pengarSkriv.setBounds(pengar.getBounds().x, pengar.getBounds().y + 90, pengar.getBounds().width, pengar.getBounds().height);
        laggTill.setBounds(pengar.getBounds().x + 170, pengar.getBounds().y + 90, pengar.getBounds().width, pengar.getBounds().height);
        draUt.setBounds(pengar.getBounds().x + 170, pengar.getBounds().y + 50, pengar.getBounds().width, pengar.getBounds().height);
        felmedelande.setBounds(pengar.getBounds().x, pengar.getBounds().y + 130, pengar.getBounds().width + 300, pengar.getBounds().height);

        felmedelande.setFont(new Font(Font.DIALOG, Font.BOLD, 18));
        pengar.setFont(new Font(Font.DIALOG, Font.BOLD, 15));
        loggaUt.setFocusPainted(false);
        konto.setFont(new Font(Font.DIALOG, Font.BOLD, 30));
        konto.setForeground(Color.orange);
        felmedelande.setForeground(Color.red);
        pengarSkriv.setBackground(Color.lightGray);


    }

    public static void fyllAllt()
    {
        money.setText(Float.toString(cash));
    }

    public static void nyttKonto(String namn)
    {
        for (int i = 0; i < dsf.konton.size(); i++)
        {
            if(dsf.konton.get(i).användarnamn.equals(namn))
            {
                kontot = dsf.konton.get(i);
                break;
            }
        }

        cash = kontot.pengar;
        fyllAllt();
    }

    static class knap1 implements ActionListener
    {

        public void actionPerformed(ActionEvent actionEvent)
        {
            try
            {
                cash += Float.parseFloat(pengarSkriv.getText());
                money.setText(Float.toString(cash));
            }catch (Exception e)
            {
                System.out.println("går inte att parsa till float");
                e.printStackTrace();
                felmedelande.setText("Fel! Skriv siffror endast");
            }
        }
    }

    static class knap2 implements ActionListener
    {

        public void actionPerformed(ActionEvent actionEvent)
        {
            try
            {
                int x = (int) Float.parseFloat(pengarSkriv.getText());
            }catch (Exception e)
            {
                System.out.println("går inte att parsa till float");
                e.printStackTrace();
                felmedelande.setText("Fel! Skriv siffror endast");
            }
            if(cash >= Float.parseFloat(pengarSkriv.getText()))
            {
                try
                {
                    cash -= Float.parseFloat(pengarSkriv.getText());
                    money.setText(Float.toString(cash));
                }catch (Exception e)
                {
                    System.out.println("går inte att parsa till float");
                    e.printStackTrace();
                    felmedelande.setText("Fel! Skriv siffror endast");
                }
            }
            else
            {

                felmedelande.setText("Fel! Du har för lite pengar!");
            }
        }
    }

    static class knap3 implements ActionListener
    {

        public void actionPerformed(ActionEvent actionEvent)
        {
            kontot.pengar = Float.parseFloat(money.getText());

            money.setText("");
            kontot = null;
            pengarSkriv.setText("");
            dsf.byta(dsf.startMenu);
        }
    }
}
