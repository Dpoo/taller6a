package interfaz;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class VentanaJuego extends JFrame{

	 private PanelOpciones panelOpciones; 
	 private PanelMarcador panelMarcador; 
	 private PanelTablero panelTablero;
	 private PanelBotones panelBotones;
	
	public VentanaJuego() {
		
		setSize(700, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panelOpciones = new PanelOpciones(); 
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
		new VentanaJuego();
	}

}
