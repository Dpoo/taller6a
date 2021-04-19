package interfaz;

import java.awt.BorderLayout;
import javax.swing.*;

import com.formdev.flatlaf.FlatLightLaf;

import uniandes.dpoo.taller6.modelo.*;

public class VentanaJuego extends JFrame{

	 private PanelOpciones panelOpciones; 
	 private PanelMarcador panelMarcador; 
	 private PanelTablero panelTablero;
	 private PanelBotones panelBotones;
	 
	 private Tablero tablero = new Tablero(5);
	 private int tamanio = 5;
	 private int dificultad = 2;
	
	
		public void establecerDificultad(int i) {
			System.out.print("actual: " + this.dificultad + "\n");
			this.dificultad = i;
			System.out.print("nuevo: " + this.dificultad + "\n");
		}	
		
		
		public void establecerTamanio(int i) {
			System.out.print("actual: " + this.tamanio + "\n");
			this.tamanio = i;
			tablero = new Tablero(tamanio);
			System.out.print("nuevo: " + this.tamanio + "\n");
		}

		public void Jugar(int i, int j){
			tablero.jugar(i,j);
			panelTablero.actulizarPanel(tablero);
			int jugadas = tablero.darJugadas();
			int conteo = tablero.darJugadas();
			panelMarcador.setJugadas(conteo);
		}


	public VentanaJuego() {
		setTitle("LightsOut");
		setSize(700, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panelOpciones = new PanelOpciones(this); 

		panelMarcador = new PanelMarcador(this);  
		panelTablero = new PanelTablero(this);
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

	public Tablero getTablero() {
		return tablero;
	}

	public static void main(String[] args) {
		FlatLightLaf.install();
		new VentanaJuego();
	}

		public void nuevoJuego() {
		System.out.print("Nuevo juego");
		tablero = new Tablero(tamanio);
		tablero.desordenar(dificultad);
		this.remove(panelTablero);
		panelTablero = new PanelTablero(this);
		add(panelTablero);
		panelTablero.actulizarPanel(tablero);
	}


	public void reiniciarJuego() {
		tablero.reiniciar();
		panelTablero.actulizarPanel(tablero);
		
		System.out.print("Reiniciar juego");
	}


	public void top10() {
		
		System.out.print("Top 10");
	}
}
