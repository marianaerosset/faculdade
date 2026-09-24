package lista3;

public class ex10ou16 {
    if(e.getSource() == iniciar){
        worker = new SwingWorker<Void, Void>(){
            protected Void doInBackground() throws Exception{
                Thread.sleep(5000);
                return null;
            }
            protected void done(){
                if(isCancelled()) status.setText("Cancelado");
                else status.setText("Concluído");
            }
        };
        worker.execute();
    }
    else if(e.getSource() == cancelar){
        worker.cancel(true);
    }
}
