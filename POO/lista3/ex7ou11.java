package lista3;

import javax.swing.SwingWorker;

public class ex7ou11 {
    public void actionPerformed(ActionEvent e){
        status.setText("Processando...");
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>(){
            protected Void doInBackground() throws Exception{
                Thread.sleep(000);
                return null;
            }
            protected void done(){
                status.setText("Concluído!");
            }
        };
    }
}
