package lista3;

public class ex6ou9 {
    confirmar.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            status.setText("Confirmado");
        }
    });
    confirmar.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            contador++;
        }
    });
    confirmar.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            System.out.println("Evento recebido.");
        }
    });
}
