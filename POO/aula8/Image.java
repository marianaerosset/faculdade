import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Image {
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                createAndShowGUI();
            }
        });
    }
    private static void createAndShowGUI(){
        JFrame f = new JFrame("Swing Hello World!");

        ImageIcon icon = new ImageIcon("imagens/amor.png");

        JLabel label1 = new JLabel("Image and Text", icon, JLabel.CENTER);
        label1.setVerticalTextPosition(JLabel.BOTTOM);
        label1.setHorizontalTextPosition(JLabel.CENTER);

        JLabel label2 = new JLabel("Text-Only Label");
        JLabel label3 = new JLabel(icon);

        JPanel panel = new JPanel();
        panel.add(label1);
        panel.add(label2);
        panel.add(label3);

        f.add(panel);?

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
    }
}
