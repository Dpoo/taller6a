package interfaz;

import uniandes.dpoo.taller6.modelo.Tablero;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;


public class PanelTablero extends JPanel implements ActionListener {
    private JButton[][] botones;
    private VentanaJuego ventana;
    private boolean[][] matrixTablero;
    private int largo;
    ImageIcon GatoOff = new ImageIcon("./data/gatoOff.png");
    ImageIcon GatoON = new ImageIcon("./data/gatoON.png");


    public PanelTablero(VentanaJuego ventana) {
        setSize(600, 600);
        this.ventana = ventana;
    }

    public void nuevoPanel(Tablero tablero){
        this.removeAll();
        this.matrixTablero = tablero.darTablero();
        this.largo = matrixTablero.length;
        this.botones =  new JButton[largo][largo];
        GridLayout gl = new GridLayout(largo,largo);
        setLayout(gl);

        for (int i = 0; i < largo; i++) {
            for (int ii = 0; ii < largo; ii++) {
                JButton acB = new JButton();
                acB.addActionListener(this);
                acB.setActionCommand(i + "," + ii);
                add(acB);
                botones[i][ii] = acB;
            }
        }
        actulizarPanel();
    }

    public void actulizarPanel(){
        System.out.println("actua");

        for (int i = 0; i < largo; i++) {
            for (int ii = 0; ii < largo; ii++) {
                if (matrixTablero[i][ii]) {
                    botones[i][ii].setIcon(new ImageIcon(GatoON.getImage().
                            getScaledInstance((int)(ventana.getWidth()*0.8)/largo,(int)(ventana.getHeight()*0.8)/largo,Image.SCALE_DEFAULT)));
                    botones[i][ii].setBackground(new java.awt.Color(255, 239, 108));
                } else {
                    botones[i][ii].setIcon(new ImageIcon(GatoOff.getImage().
                            getScaledInstance((int)(ventana.getWidth()*0.8)/largo,(int)(ventana.getHeight()*0.8)/largo,Image.SCALE_DEFAULT)));
                    botones[i][ii].setBackground(new java.awt.Color(39, 97, 128));
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String[] grito = e.getActionCommand().split(",");
        ventana.Jugar(Integer.parseInt(grito[0]), Integer.parseInt(grito[1]));
    }
}
