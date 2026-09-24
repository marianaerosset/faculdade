import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Verification{
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                createAndShowGUI();
            }
        });
    }
    private static void createAndShowGUI(){
        JFrame f = new JFrame("O que é isso?");

        f.setLayout(new FlowLayout());
        ImageIcon icon = new ImageIcon("imagens/bird.png");
        JLabel image = new JLabel(icon);

        JRadioButton birdButton, catButton, dogButton, pigButton;
        birdButton = new JRadioButton("Bird");
        catButton = new JRadioButton("Cat");
        dogButton = new JRadioButton("Dog");
        pigButton = new JRadioButton("Pig");
        birdButton.setSelected(true);

        //Adicionado para agrupar os botões de opção
        ButtonGroup radioGroup = new ButtonGroup(); 
        radioGroup.add(birdButton);
        radioGroup.add(catButton);
        radioGroup.add(dogButton);
        radioGroup.add(pigButton);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(birdButton);
        buttonPanel.add(catButton);
        buttonPanel.add(dogButton);
        buttonPanel.add(pigButton);

        //Botão de verificação
        JButton checkButton = new JButton("Verificar");

        //Ação do botão
        checkButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame resultFrame = new JFrame("Resultado");
                JLabel resultLabel;

                if(birdButton.isSelected()) {
                    resultLabel = new JLabel("CERTA RESPOSTA!");
                } else {
                    resultLabel = new JLabel("ERROU", SwingConstants.CENTER);
                }
                resultFrame.add(resultLabel);
                resultFrame.setSize(250, 100);
                resultFrame.setLocationRelativeTo(null);
                resultFrame.setVisible(true);
            }
        });
        
        f.setLayout(new BorderLayout());

        f.add(buttonPanel, BorderLayout.NORTH);
        f.add(image, BorderLayout.CENTER);
        f.add(checkButton, BorderLayout.SOUTH);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }    
}

