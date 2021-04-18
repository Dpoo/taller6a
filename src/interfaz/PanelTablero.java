package interfaz;

import uniandes.dpoo.taller6.modelo.Tablero;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class PanelTablero extends JPanel implements ActionListener {
    private JButton[][] botones;
    private VentanaJuego ventana;

    public PanelTablero(VentanaJuego ventana){
        this.ventana = ventana;
        Tablero tablero = ventana.getTablero();
       nuevoPanel(tablero);
    }

    public void nuevoPanel(Tablero tablero){
        boolean[][] tableroB = tablero.darTablero();
        int largo = tableroB.length;
        this.botones =  new JButton[largo][largo];
        GridLayout gl = new GridLayout(largo,largo);
        setLayout(gl);
        for (int i = 0; i < largo; i++)
            for (int ii = 0; ii < largo; ii++)
            {
                JButton acB = new JButton();
                acB.addActionListener(this);
                acB.setActionCommand(i+","+ii);
                if (tableroB[i][ii]){
                    acB.setText("Encendido");
                    acB.setBackground(Color.BLACK);
                }else{
                    acB.setText("Apagado");
                    acB.setBackground(Color.WHITE);
                }
                add(acB);
                botones[i][ii] = acB;
            }

    }

    public void actulizarPanel(Tablero tablero){
        boolean[][] tableroB = tablero.darTablero();
        int largo = tableroB.length;
        for (int i = 0; i < largo; i++) {
            for (int ii = 0; ii < largo; ii++) {
                if (tableroB[i][ii]) {
                    botones[i][ii].setText("Encendido");
                    botones[i][ii].setBackground(Color.WHITE);
                } else {
                    botones[i][ii].setText("Apagado");
                    botones[i][ii].setBackground(Color.BLACK);
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String[] grito = e.getActionCommand().split(",");
        int i = Integer.parseInt(grito[0]);
        int j = Integer.parseInt(grito[1]);
        ventana.Jugar(i,j);
    }
}
