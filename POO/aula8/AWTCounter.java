import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.awt.FlowLayout;

public class AWTCounter {
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                createAndShowGUI();
            }
        });
    }
    private static void createAndShowGUI(){
        JFrame f = new JFrame("AWT Counter");

        f.setLayout(new FlowLayout());

        JLabel label = new JLabel("Counter");
        f.add(label);

        JTextField tField = new JTextField(10);
        f.add(tField);
        String name = tField.getText();

        JButton button;
        button = new JButton("Count");
        f.add(button);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
    }
}
