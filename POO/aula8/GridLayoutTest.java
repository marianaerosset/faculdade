import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class GridLayoutTest {
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                createAndShowGUI();
            }
        });
    }
    private static void createAndShowGUI(){
        JFrame f = new JFrame("Swing Hello World!");
        
        GridLayout gridLayout = new GridLayout(2, 3, 5, 5);

        f.setLayout(gridLayout);

        String[] names = {"One", "Two", "Three", "Four", "Five", "Six"};
        JButton[] buttons = new JButton[names.length];

        for(int count = 0; count < names.length; count++){
            buttons[count] = new JButton(names[count]);
            f.add(buttons[count]);
            //add listener
        }

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
    }
}