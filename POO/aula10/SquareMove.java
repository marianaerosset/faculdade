import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SquareMove {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Controle do Quadrado");
        frame.setLayout(null);   
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Painel que representa o quadrado
        JPanel quadrado = new JPanel();
        quadrado.setBackground(Color.BLUE);
        quadrado.setBounds(220, 180, 40, 40);

        // Rótulos
        JLabel lblPosicao = new JLabel("Coordenadas: (220, 180)");
        lblPosicao.setBounds(10, 410, 200, 20);
        JLabel lblCliques = new JLabel("Cliques: 0");
        lblCliques.setBounds(250, 410, 100, 20);
        frame.add(quadrado);
        frame.add(lblPosicao);
        frame.add(lblCliques);
        
        Random random = new Random();
        int[] cliques = {0};

        // Evento de mouse
        quadrado.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {

                quadrado.setBackground(new Color(
                        random.nextInt(256),
                        random.nextInt(256),
                        random.nextInt(256)));

                cliques[0]++;

                lblCliques.setText("Cliques: " + cliques[0]);
            }

        });

        // Evento de teclado
        frame.addKeyListener(new KeyAdapter() {

            public void keyPressed(KeyEvent e) {

                int x = quadrado.getX();
                int y = quadrado.getY();

                switch (e.getKeyCode()) {

                    case KeyEvent.VK_UP:
                        y -= 10;
                        break;

                    case KeyEvent.VK_DOWN:
                        y += 10;
                        break;

                    case KeyEvent.VK_LEFT:
                        x -= 10;
                        break;

                    case KeyEvent.VK_RIGHT:
                        x += 10;
                        break;
                }

                // Impede que o quadrado saia da janela
                if (x < 0)
                    x = 0;

                if (y < 0)
                    y = 0;

                if (x > frame.getWidth() - quadrado.getWidth() - 15)
                    x = frame.getWidth() - quadrado.getWidth() - 15;

                if (y > frame.getHeight() - quadrado.getHeight() - 40)
                    y = frame.getHeight() - quadrado.getHeight() - 40;

                quadrado.setLocation(x, y);

                lblPosicao.setText("Coordenadas: (" + x + ", " + y + ")");
            }

        });

        frame.setVisible(true);


    }
}
