package lista2;

public class ex14 {
    ActionListener l1 = new ActionListener(){
        public void actionPerformed(ActionEvent e){
            System.out.println("Listener 1");
        }
    };
    ActionListener l2 = new ActionListener(){
        public void actionPerformed(ActionEvent e){
            System.out.println("Listener 2");
        }
    };
    button.addActionListener(l1);
    button.addActionListener(l2);
}
