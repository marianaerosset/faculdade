import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ColorChange{
    public static void main(String[] args){
        JFrame frame = new JFrame("Color Change");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MyPanel panel = new MyPanel();
        frame.add(panel);
        frame.setSize(250, 150);
        frame.setVisible(true);
    }
}

class MyPanel extends JPanel implements ActionListener{
    private JButton yellowButton = new JButton("Yellow");
    private JButton blueButton = new JButton("Blue");
    private JButton redButton = new JButton("Red");
    public MyPanel(){
        this.add(yellowButton);
        this.add(blueButton);
        this.add(redButton);
        yellowButton.addActionListener(this);
        blueButton.addActionListener(this);
        redButton.addActionListener(this);
    }
    public void actionPerformed(ActionEvent evt){
        String command = evt.getActionCommand();
        if(command.equals("Yellow"))
            setBackground(Color.YELLOW);
        else if(command.equals("Blue"))
            setBackground(Color.BLUE);
        else if(command.equals("Red"))
            setBackground(Color.RED);
    }
}