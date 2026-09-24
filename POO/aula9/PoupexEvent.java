import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PoupexEvent {
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

        String[] lines = {"Juros ao mês %:", "Num. de anos:", "Depósito mensal R$:", "Investimento Inicial R$:", "Total poupado R$:"};
        JLabel[] labels = new JLabel[lines.length];
        JTextField[] tFields = new JTextField[lines.length];

        for(int count = 0; count < lines.length; count++){
            labels[count] = new JLabel(lines[count]);
            tFields[count] = new JTextField(10);
            if(count == lines.length - 1){
                f.add(labels[count]);
                JLabel resultLabel = new JLabel(" ");
                tFields[count].setEditable(false);
                f.add(tFields[count]);
                break;
            }
            f.add(labels[count]);
            f.add(tFields[count]);
        }

        f.add(new JLabel (""));
        JButton okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double juros = Double.parseDouble(tFields[0].getText());
                int anos = Integer.parseInt(tFields[1].getText());
                double depositoMensal = Double.parseDouble(tFields[2].getText());
                double investimentoInicial = Double.parseDouble(tFields[3].getText());

                double totalPoupado = investimentoInicial;
                for (int i = 0; i < anos * 12; i++) {
                    totalPoupado += totalPoupado * (juros / 100);
                    totalPoupado += depositoMensal;
                }

                tFields[4].setText(String.format("%.2f", totalPoupado));
            }
        });
        f.add(okButton);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
    }
}