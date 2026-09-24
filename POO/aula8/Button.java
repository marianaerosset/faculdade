import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.AbstractButton;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;

public class Button {
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
        ImageIcon leftButtonIcon = new ImageIcon("imagens/left.png");
        ImageIcon middleButtonIcon = new ImageIcon("imagens/cacic_logo.png");
        ImageIcon rightButtonIcon = new ImageIcon("imagens/right.png");

        JButton b1, b2, b3;
        b1 = new JButton("Desabilitar botão do meio", leftButtonIcon);
        b1.setVerticalTextPosition(AbstractButton.CENTER);
        b1.setHorizontalTextPosition(AbstractButton.LEADING);
        b1.setMnemonic(KeyEvent.VK_D);

        b2 = new JButton("Botão do meio", middleButtonIcon);
        b2.setVerticalTextPosition(AbstractButton.BOTTOM);
        b2.setHorizontalTextPosition(AbstractButton.CENTER);
        b2.setMnemonic(KeyEvent.VK_M);

        b3 = new JButton("Habilitar botão do meio", rightButtonIcon);
        b3.setMnemonic(KeyEvent.VK_E);
        b3.setEnabled(false);

        f.add(b1); f.add(b2); f.add(b3);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
    }
}
