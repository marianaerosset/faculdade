package lista2;

public class ex3 {
    ActionListener l = new ActionListener(){
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == button1){
                System.out.println("Azul");
            }
            else if(e.getSource() == button2){
                System.out.println("Vermelho");
            }
        }
    }
    button1.addActionListener(l);
    button2.addActionListener(l);
}
