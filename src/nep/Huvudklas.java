package nep;
//jag försöker lista ut varför panelen inte vill bytas se tet rad 57 och "byta" metoden i dsf

import javafx.scene.input.KeyCode;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public class Huvudklas
{
    static JFrame fonster = new JFrame("Swedbank SE");
    public static HuvudMenu huvudMenu = new HuvudMenu();
    public static StartMenu startMenu = new StartMenu();
    static List<Konto> konton = new ArrayList<Konto>();
    static JPanel aktivPanel = startMenu;
    static registrering signup = new registrering();

    public static void main (String[] args)
    {

        System.out.println(System.getProperty("user.name"));
        konton.add(new Konto("1", "2", 420.69f));


        //fönster
        fonster.setVisible(true);
        fonster.setSize(500,400);
        fonster.setLocationRelativeTo(null);
        fonster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fonster.addKeyListener(new EnterLyssnaren());
        fonster.add(aktivPanel);
    }

    public static void byta(JPanel panel)
    {
        fonster.remove(aktivPanel);
        fonster.add(panel);
        aktivPanel = panel;
        fonster.invalidate();
        fonster.validate();
        fonster.repaint();
    }

    static class EnterLyssnaren implements KeyListener
    {

        public void keyTyped(KeyEvent keyEvent) {

        }

        public void keyPressed(KeyEvent keyEvent)
        {
        }

        public void keyReleased(KeyEvent keyEvent)
        {
            if (keyEvent.getKeyCode() == KeyCode.ENTER.getCode() && aktivPanel == startMenu)
            {
                StartMenu.checka();
            }
        }
    }
}
