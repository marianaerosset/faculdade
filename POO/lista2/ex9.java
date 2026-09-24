package lista2;

public class ex9 {
    MouseListener ml = new MouseAdapter() {
        public void mouseEntered(MouseEvent e){
            label.setText("Mouse dentro")
        }
        public void mouseExited(MouseEvent e){
            label.setText("Mouse fora")
        }
    };
}
