import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.util.concurrent.ExecutionException;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class FirstFrame extends JFrame {
    public FirstFrame(){
        setTitle("FirstFrame");
        setSize(300,200);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(new MyWorkPanel());
    }
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                new FirstFrame().setVisible(true);
            }
        });
    }

    private class ButtonWorker extends SwingWorker<Integer,Void>{
        private int sleepTime;
        private ButtonWorker(int sleepTime){
            this.sleepTime = sleepTime;
        }
        @Override
        protected Integer doInBackground() throws Exception{
            try{
                Thread.sleep(sleepTime);
            }catch(InterruptedException ex){
                ex.printStackTrace();
            }
            return sleepTime;
        }
        @Override
        protected void done(){
            int result;
            try{
                result = get();
                JOptionPane.showMessageDialog(null,
                    "Finished. Sleep time: "+result,
                    "Swing Worker Example",
                    JOptionPane.INFORMATION_MESSAGE);
            }catch(InterruptedException | ExecutionException ex){
                ex.printStackTrace();
            }
            
        }
    }

    private class MyWorkPanel extends JPanel{
        private JButton edtButton = new JButton("EDT");
        private JButton swButton = new JButton("SwingWorker");
        private int sleepTime = 10000;
        
        private MyWorkPanel(){
            this.add(edtButton);
            this.add(swButton);
            
            edtButton.addActionListener(new ButtonListener());
            swButton.addActionListener(new ButtonListener());
        }
        class ButtonListener implements ActionListener{
            public void actionPerformed(ActionEvent evt){
                Object source = evt.getSource();
                if(source == edtButton){
                    setBackground(Color.YELLOW);
                    
                    try{
                        Thread.sleep(sleepTime);
                        JOptionPane.showMessageDialog(null,
                            "Finished. Sleep time: "+sleepTime,
                            "Event Dispatch Example",
                            JOptionPane.INFORMATION_MESSAGE);
                    } catch(InterruptedException ex){
                        ex.printStackTrace();
                    }
                }else if(source == swButton){
                    setBackground(Color.BLUE);
                    ButtonWorker bw = new ButtonWorker(sleepTime);
                    bw.execute();
                }
            }
        }
    }
}



