import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import lista3.ex1.ButtonListener;

public class ex1 {
    class ButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == somar) contador++;
            else if(e.getSource() == subtrair) contador--;
            else if(e.getSource() == zerar) contador = 0;
            campo.setText(String.valueOf(contador));
        }
        ButtonListener listener = new ButtonListener();
        somar.addActionListener(listener);
        subtrair.addActionListener(listener);
        zerar.addActionListener(listener);
    }
}
