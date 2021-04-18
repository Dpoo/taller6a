package interfaz;

import java.awt.BorderLayout;
import javax.swing.JFrame;

import com.formdev.flatlaf.FlatLightLaf;

import uniandes.dpoo.taller6.modelo.*;

public class VentanaJuego extends JFrame{

	 private PanelOpciones panelOpciones; 
	 private PanelMarcador panelMarcador; 
	 private PanelTablero panelTablero;
	 private PanelBotones panelBotones;
	 private Tablero tablero = new Tablero(5);
	
	
		public void establecerDificultad(int i) {
			tablero.desordenar(i);
		}	
		
		
		public void establecerTamanio(int i) {
			tablero = new Tablero(i);
		}


	public VentanaJuego() {
		setTitle("LightsOut");
		setSize(700, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panelOpciones = new PanelOpciones(this); 
		panelMarcador = new PanelMarcador(this);  
		panelTablero = new PanelTablero(5);
		panelBotones = new PanelBotones(this);
		  
		 setLayout(new BorderLayout());
		 
		 this.add(panelOpciones , BorderLayout.NORTH); 
		 this.add(panelMarcador,BorderLayout.WEST);
		 this.add(panelTablero,BorderLayout.CENTER);
		 this.add(panelBotones, BorderLayout.SOUTH);

		int panelX = (getWidth() - panelTablero.getWidth() - getInsets().left - getInsets().right) / 2;
		int panelY = ((getHeight() - panelTablero.getHeight() - getInsets().top - getInsets().bottom) / 2);

		panelTablero.setLocation(panelX, panelY);

		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		FlatLightLaf.install();
		new VentanaJuego();
	}


}
