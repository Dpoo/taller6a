package interfaz;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelMarcador extends JPanel{
	
	private JLabel jugadas;
	private VentanaJuego juego;

	public PanelMarcador(VentanaJuego vjuego) {
		
		juego=vjuego;
		jugadas = new JLabel("0");
		add(jugadas, BorderLayout.CENTER);
	}

}
