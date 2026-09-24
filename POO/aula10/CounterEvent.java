import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class CounterEvent extends JFrame implements KeyListener {

    private JTextField campoContador;
    private JButton botaoIncrementar;
    private JButton botaoZerar;

    private int contador = 0;

    public CounterEvent() {
        setTitle("Contador");
        setSize(350, 150);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        campoContador = new JTextField("0", 10);
        campoContador.setEditable(false);
        botaoIncrementar = new JButton("Incrementar");
        botaoZerar = new JButton("Zerar");

        add(campoContador);
        add(botaoIncrementar);
        add(botaoZerar);

        botaoIncrementar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                incrementarContador();
                setTitle("Contador atualizado");
            }
        });


        // ActionListener do botão Zerar
        botaoZerar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                zerarContador();
            }
        });

 
        addKeyListener(this);
        campoContador.addKeyListener(this);
        botaoIncrementar.addKeyListener(this);
        botaoZerar.addKeyListener(this);

        // Eventos de entrada e saída do mouse
        addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                setTitle("Mouse na janela");
            }

            public void mouseExited(MouseEvent e) {
                setTitle("Contador");
            }
        });

        setVisible(true);

    }

    private void incrementarContador() {
        contador++;
        campoContador.setText(String.valueOf(contador));
    }

    private void zerarContador() {
        contador = 0;
        campoContador.setText(String.valueOf(contador));
    }


    public void keyPressed(KeyEvent e) {

        // getKeyChar permite identificar o caractere "+"
        if (e.getKeyChar() == '+') {
            incrementarContador();
        }

        /*
         * VK_Z identifica a tecla Z independentemente de ela ter
         * sido pressionada como maiúscula ou minúscula.
         */
        if (e.getKeyCode() == KeyEvent.VK_Z) {
            zerarContador();
        }
    }


    public void keyReleased(KeyEvent e) {
        // Não utilizado neste programa
    }


    public void keyTyped(KeyEvent e) {
        // Não utilizado neste programa
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
    
            public void run() {
                new ContadorSwing();
            }
        });
    }
}