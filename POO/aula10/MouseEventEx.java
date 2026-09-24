import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.BorderLayout;
import javax.swing.SwingUtilities;

public class MouseEventEx extends JFrame{
    private JLabel positionLabel;
    public MouseEventEx(){
        setTitle("Mouse Events Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        positionLabel = new JLabel("Position: ");
        add(positionLabel, BorderLayout.SOUTH);

        addMouseListener(new MouseListener());
        addMouseMotionListener(new MouseMotionListener());

        setSize(300, 200);
        setVisible(true);
    }

    class MouseListener extends MouseAdapter{
        public void mouseClicked(MouseEvent e){
            int x = e.getX();
            int y = e.getY();
            int clickCount = e.getClickCount();
            int button = e.getButton();
            System.out.println("Mouse clicked at (" + x + ", " + y + ")");
            System.out.println("Click count: " + clickCount);
            System.out.println("Button: " + button);
        }
    }
    
    class MouseMotionListener extends MouseMotionAdapter{
        public void mouseMoved(MouseEvent e){
            int x = e.getX();
            int y = e.getY();
            positionLabel.setText("Position: (" + x + ", " + y + ")");
        }
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
        @Override
            public void run(){
                new MouseEventEx();
            }
        });
    }
}
