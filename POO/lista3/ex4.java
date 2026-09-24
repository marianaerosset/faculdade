package lista3;

public class ex4 {
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_UP) contador++;
        else if(key == KeyEvent.VK_DOWN) contador--;
        else if(key == KeyEvent.VK_ESCAPE) contador = 0;
        label.setText(String.valueOf(contador));
    }
}
