package interfaz;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PanelBotones extends JPanel implements ActionListener{

	private VentanaJuego juego;
	private JButton btnNuevo;
	private JButton btnReiniciar;
	private JButton btnTop;

	
	public PanelBotones (VentanaJuego vjuego) {
		
		juego=vjuego;
		btnNuevo = new JButton("NUEVO");
		btnReiniciar = new JButton("REINICIAR");
		btnTop = new JButton("TOP-10");
		FlowLayout fl = new FlowLayout();
		add(btnNuevo);
		add(btnReiniciar);
		add(btnTop);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
