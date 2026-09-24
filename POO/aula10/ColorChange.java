import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.FocusAdapter;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ColorChange{
    public static void main(String[] args){
        JFrame frame = new JFrame("Color Change");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MyPanelFocus panel = new MyPanelFocus();
        frame.add(panel);
        frame.setSize(250, 150);
        frame.setVisible(true);
    }
}

class MyPanelFocus extends JPanel{
    private JButton yellowButton = new JButton("Yellow");
    private JButton blueButton = new JButton("Blue");
    private JButton redButton = new JButton("Red");
    public MyPanelFocus(){
        this.add(yellowButton);
        this.add(blueButton);
        this.add(redButton);
        yellowButton.addFocusListener(new FocusListener());
        blueButton.addFocusListener(new FocusListener());
        redButton.addFocusListener(new FocusListener());
    }
    class FocusListener extends FocusAdapter{
        public void focusGained(FocusEvent e){
            Object source = e.getComponent();
            if(source == yellowButton)
                setBackground(Color.YELLOW);
            else if(source == blueButton)
                setBackground(Color.BLUE);
            else if(source == redButton)
                setBackground(Color.RED);
        }
    }
}