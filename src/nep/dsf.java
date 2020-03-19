package nep;
//jag försöker lista ut varför panelen inte vill bytas se tet rad 57 och "byta" metoden i dsf

import javafx.scene.input.KeyCode;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public class dsf
{
    static JFrame fon = new JFrame("Swedbank SE");
    public static mena huvudMenu = new mena();
    public static tet startMenu = new tet();
    static List<Konto> konton = new ArrayList<Konto>();
    static JPanel aktivPanel = startMenu;
    static registrering signup = new registrering();

    public static void main (String[] args)
    {

        System.out.println(System.getProperty("user.name"));
        konton.add(new Konto("1", "2", 420.69f));


        //fönster
        fon.setVisible(true);
        fon.setSize(500,400);
        fon.setLocationRelativeTo(null);
        fon.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fon.addKeyListener(new EnterLyssnaren());
        fon.add(aktivPanel);
    }

    public static void byta(JPanel panel)
    {
        fon.remove(aktivPanel);
        fon.add(panel);
        aktivPanel = panel;
        fon.invalidate();
        fon.validate();
        fon.repaint();
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
                tet.checka();
            }
        }
    }
}
