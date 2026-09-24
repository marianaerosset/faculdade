import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CounterEvent {
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

        JTextField tField = new JTextField("0", 5);
        tField.setEditable(false);

        JButton button;
        button = new JButton("Count");

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int valor = Integer.parseInt(tField.getText());
                valor++;
                tField.setText(String.valueOf(valor));
            }
        });

        f.add(label); f.add(tField); f.add(button);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
    }
}
