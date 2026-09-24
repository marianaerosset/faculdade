package lista3;

public class ex2 {
    ButtonGroup group = new ButtonGroup();
    group.add(dobro);
    group.add(triplo);

    public void actionPerformed(ActionEvent e){
        int valor = Integer.parseInt(entrada.getText());
        if(dobro.isSelected()) valor *= 2;
        else if(triplo.isSelected()) valor *= 3;
        resultado.setText("Resultado: " + valor);
    }
}
