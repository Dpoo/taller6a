package interfaz;

import java.awt.BorderLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import javax.swing.*;

import com.formdev.flatlaf.FlatLightLaf;

import uniandes.dpoo.taller6.modelo.*;

public class VentanaJuego extends JFrame{

	 private PanelOpciones panelOpciones; 
	 private PanelMarcador panelMarcador; 
	 private PanelTablero panelTablero;
	 private PanelBotones panelBotones;
	 private Tablero tablero ;
	 private Top10 top;
	 private int tamanio = 5;
	 private int dificultad = 2;




	public VentanaJuego() {
		tablero = new Tablero(5);
		top = new Top10();
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
		nuevoJuego();

		setVisible(true);
	}
	public void Jugar(int i, int j) throws FileNotFoundException, UnsupportedEncodingException {
		tablero.jugar(i,j);
		panelTablero.actulizarPanel(tablero);
		int conteo = tablero.darJugadas();
		panelMarcador.setJugadas(conteo);
		int puntaje = tablero.calcularPuntaje();

		if (tablero.tableroIluminado()) {
				agregarPuntuacion(puntaje);
		}
	}
	public void agregarPuntuacion(int punt) throws FileNotFoundException, UnsupportedEncodingException {

		if(top.esTop10(punt)){
			//cuadro de texto nombre
			String nombre = "ggg";
			top.agregarRegistro(nombre, punt);
			top.salvarRecords(new File("data/top10.csv"));
		}else{
			//decirle que se dedique a otra cosa
		}

	}

	public void establecerDificultad(int i) {
		this.dificultad = i;
	}


	public void establecerTamanio(int i) {
		this.tamanio = i;
		tablero = new Tablero(tamanio);
	}

	public Tablero getTablero() {
		return tablero;
	}

	public static void main(String[] args) {
		FlatLightLaf.install();
		new VentanaJuego();
	}

		public void nuevoJuego() {
		tablero = new Tablero(tamanio);
		tablero.desordenar(dificultad);
		panelTablero.nuevoPanel(tablero);
		panelMarcador.setJugadas(0);
	}


	public void reiniciarJuego() {
		tablero.reiniciar();
		panelTablero.actulizarPanel(tablero);
		panelMarcador.setJugadas(0);
	}


	public void top10() {
		
		System.out.print("Top 10");
	}
}
