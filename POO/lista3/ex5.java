package lista3;

public class ex5 {
    public void mouseClicked(MouseEvent e){
        button = e.getButton();
        if(button == MouseEvent.BUTTON1) System.out.println("Botão esquerdo");
        else if(button == MouseEvent.BUTTON3) System.out.println("Botão direito");
    }
}
