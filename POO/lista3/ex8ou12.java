package lista3;

public class ex8ou12 {
    protected Integer doInBackground() throws Exception{
        Thread.sleep(3000);
        return numero*numero;
    }
    protected void done(){
        try{
            int valor = get();
            resultado.setText(String.valueOf(valor));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
