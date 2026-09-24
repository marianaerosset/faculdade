import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.BorderFactory;
import javax.swing.JRadioButton;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.SwingConstants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Quizz {
    static int i = 0;
    static int score = 0;

    static JLabel question;
    static JRadioButton op1, op2, op3, op4;
    static ButtonGroup options;
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                createAndShowGUI();
            }
        });
    }
    private static void createAndShowGUI(){
        JFrame f = new JFrame("Jogo de Perguntas");

        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        p.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));

        String[] questions = {
            "Qual é a capital da França?",
            "Qual é o maior planeta do sistema solar?",
            "Quem escreveu 'Dom Quixote'?",
            "Qual é o elemento químico com símbolo 'O'?",
            "Qual é a moeda oficial do Japão?"
        };
        String[][] options = {
            {"Paris", "Londres", "Roma", "Berlim"},
            {"Terra", "Júpiter", "Saturno", "Marte"},
            {"William Shakespeare", "Miguel de Cervantes", "Mark Twain", "Charles Dickens"},
            {"Ouro", "Oxigênio", "Hidrogênio", "Carbono"},
            {"Dólar", "Euro", "Iene", "Libra"}
        };
        String[] answers = {"Paris", "Júpiter", "Miguel de Cervantes", "Oxigênio", "Iene"};

        question = new JLabel("Rodada " + (i + 1) + ": " + questions[i]);
        p.add(question);

        // 2. Instancia os botões com as 4 alternativas daquela rodada
        op1 = new JRadioButton(options[i][0]);
        op2 = new JRadioButton(options[i][1]);
        op3 = new JRadioButton(options[i][2]);
        op4 = new JRadioButton(options[i][3]);

        // 3. Agrupa os botões (para garantir que só um seja marcado)
        ButtonGroup optionsG = new ButtonGroup();
        optionsG.add(op1);
        optionsG.add(op2);
        optionsG.add(op3);
        optionsG.add(op4);

        // 4. Adiciona os botões na tela
        p.add(op1);
        p.add(op2);
        p.add(op3);
        p.add(op4);

        // 5. Cria e adiciona o botão de ação (que fará o jogo avançar)
        JButton answer = new JButton("Responder");
        answer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if(op1.isSelected() && options[i][0].equals(answers[i]) ||
                    op2.isSelected() && options[i][1].equals(answers[i]) ||
                    op3.isSelected() && options[i][2].equals(answers[i]) ||
                    op4.isSelected() && options[i][3].equals(answers[i])) {
                    score++;
                }
                i++;
                if(i < questions.length) {
                    question.setText("Rodada " + (i + 1) + ": " + questions[i]);
                    op1.setText(options[i][0]);
                    op2.setText(options[i][1]);
                    op3.setText(options[i][2]);
                    op4.setText(options[i][3]);

                    optionsG.clearSelection();
                } else {
                    JFrame resultFrame = new JFrame("Mensagem");
                    JLabel resultLabel = new JLabel("Fim do jogo! Você acertou " + score + " de " + questions.length + " perguntas.", SwingConstants.CENTER);

                    JButton okButton = new JButton("OK");
                    okButton.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            System.exit(0);
                        }
                    });

                    resultFrame.add(resultLabel, java.awt.BorderLayout.CENTER);
                    resultFrame.add(okButton, java.awt.BorderLayout.SOUTH);

                    resultFrame.setSize(350, 100);
                    resultFrame.setLocationRelativeTo(null); 
                    resultFrame.setVisible(true);
                }
            }
        });
        p.add(answer);

        f.add(p);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(400, 200);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}
