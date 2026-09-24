package lista3;

import javax.swing.SwingWorker;

public class ex11ou18 {
    protected void done() {
        contadorLabel.setText("5");
    }
}

/*
Atualizar o JLabel dentro do doInBackground() não é recomendada porque esse método faz parte do SwingWorker, e componentes Swing devem
ser atualizados na EDT. Para atualizar o contador em tempo real, devem ser usados métodos que se comunicam com a EDT durante a execução 
do SwingWorker.
*/