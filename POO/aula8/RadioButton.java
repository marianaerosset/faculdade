import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

public class RadioButton {
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                createAndShowGUI();
            }
        });
    }
    private static void createAndShowGUI(){
        JFrame f = new JFrame("Swing Hello World!");

        f.setLayout(new FlowLayout());
        ImageIcon icon = new ImageIcon("imagens/bird.png");
        JLabel image = new JLabel(icon);
        JRadioButton birdButton, catButton, dogButton, pigButton;
        birdButton = new JRadioButton("Bird");
        catButton = new JRadioButton("Cat");
        dogButton = new JRadioButton("Dog");
        pigButton = new JRadioButton("Pig");
        birdButton.setSelected(true);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(birdButton);
        buttonPanel.add(catButton);
        buttonPanel.add(dogButton);
        buttonPanel.add(pigButton);

        f.setLayout(new BorderLayout());

        f.add(buttonPanel, BorderLayout.NORTH);
        f.add(image, BorderLayout.CENTER);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}
