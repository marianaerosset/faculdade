import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;
import java.awt.GridLayout;

public class Poupex {
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                createAndShowGUI();
            }
        });
    }
    private static void createAndShowGUI(){
        JFrame f = new JFrame("Poupex");
        
        GridLayout gridLayout = new GridLayout(6, 2, 30, 1);

        f.setLayout(gridLayout);

        String[] lines = {"Juros ao mês %:", "Num. de anos:", "Depósito mensal R$:", "Total poupado R$:"};
        JLabel[] labels = new JLabel[lines.length];
        JTextField[] tFields = new JTextField[lines.length];

        f.add(new JButton("Ajuda"));
        f.add(new JLabel (""));

        for(int count = 0; count < lines.length; count++){
            labels[count] = new JLabel(lines[count]);
            tFields[count] = new JTextField(10);
            if(count == lines.length - 1){
                f.add(labels[count]);
                f.add(new JLabel (""));
                break;
            }
            f.add(labels[count]);
            f.add(tFields[count]);
        }

        f.add(new JLabel (""));
        f.add(new JButton("OK"));

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
    }
}

