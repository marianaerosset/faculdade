import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;

public class BorderLayoutTest {
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                createAndShowGUI();
            }
        });
    }
    private static void createAndShowGUI(){
        JFrame f = new JFrame("Swing Hello World!");
        
        BorderLayout borderLayout = new BorderLayout(5,5);
        f.setLayout(borderLayout);

        String[] names = {"Hide North", "Hide South", "Hide East", "Hide West", "Hide Center"};
        JButton[] buttons = new JButton[names.length];

        for (int count = 0; count < names.length; count++) {
            buttons[count] = new JButton(names[count]);
            //add listener
        }

        f.add(buttons[0], BorderLayout.NORTH);
        f.add(buttons[1], BorderLayout.SOUTH);
        f.add(buttons[2], BorderLayout.EAST);
        f.add(buttons[3], BorderLayout.WEST);
        f.add(buttons[4], BorderLayout.CENTER);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
    }
}
