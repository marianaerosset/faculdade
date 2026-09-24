package lista2;

public class ex15 {
    ActionListener l1 = new ActionListener(){
        public void actionPerformed(ActionEvent e){
            label.setText("Atualizado");
        }
    };
    ActionListener l2 = new ActionListener(){
        public void actionPerformed(ActionEvent e){
            System.out.println("Atualização realizada");
        }
    };
    button.addActionListener(l1);
    button.addActionListener(l2);
}
