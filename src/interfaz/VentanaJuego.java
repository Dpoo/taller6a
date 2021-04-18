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
	 private Tablero tableroOriginal;
	 private int tamanio = 5;
	 private int dificultad = 0;
	
	
		public void establecerDificultad(int i) {
			System.out.print("actual: " + this.dificultad + "\n");
			this.dificultad = i;
			System.out.print("nuevo: " + this.dificultad + "\n");
		}	
		
		
		public void establecerTamanio(int i) {
			System.out.print("actual: " + this.tamanio + "\n");
			this.tamanio = i;
			tablero = new Tablero(tamanio);
//			panelTablero = new PanelTablero(tablero);
			System.out.print("nuevo: " + this.tamanio + "\n");
		}


	public VentanaJuego() {
		setTitle("LightsOut");
		setSize(700, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panelOpciones = new PanelOpciones(this); 

		panelMarcador = new PanelMarcador(this);  
		panelTablero = new PanelTablero();
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
