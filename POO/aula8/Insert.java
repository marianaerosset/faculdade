import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Insert {
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                createAndShowGUI();
            }
        });
    }
    private static void createAndShowGUI(){
        JFrame f = new JFrame("Swing Hello World!");

        f.setLayout(new FlowLayout());
        JTextField tField1, tField2, tField3;
        tField1 = new JTextField(10);
        tField2 = new JTextField("Insira o texto aqui");
        tField3 = new JTextField("Campo não editável", 21);
        tField3.setEditable(false);

        f.add(tField1);; f.add(tField2); f.add(tField3);

        JPasswordField passField = new JPasswordField("Texto oculto");
        f.add(passField);

        String name = tField1.getText();
        char[] pass;
        pass = passField.getPassword();

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
    }
}
