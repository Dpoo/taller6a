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
		
		setSize(700, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panelOpciones = new PanelOpciones(this); 
		panelMarcador = new PanelMarcador(); 
		panelTablero = new PanelTablero();
		panelBotones = new PanelBotones();
		  
		 setLayout(new BorderLayout());
		 
		 this.add(panelOpciones , BorderLayout.NORTH); 
		 this.add(panelMarcador,BorderLayout.WEST);
		 this.add(panelTablero,BorderLayout.EAST);
		 this.add(panelBotones, BorderLayout.SOUTH);
		 
		
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		FlatLightLaf.install();
		new VentanaJuego();
	}


}
