package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class PanelMarcador extends JPanel{
	
	private JLabel jugadas;
	private VentanaJuego juego;
	private int conteo;

	public PanelMarcador(VentanaJuego vjuego) {
		
		juego=vjuego;
		jugadas = new JLabel("0");
		setLayout (new BorderLayout());
		add(jugadas,BorderLayout.CENTER);
		
	}

	public void setJugadas(int conteo) {
		jugadas.setText(String.valueOf(conteo));
	}

	
}
