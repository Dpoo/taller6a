package interfaz;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class PanelOpciones extends JPanel implements ActionListener, ItemListener{
	
	private JLabel label1, label2;
	private JComboBox<String> menuTamanio;
	private JRadioButton botonFacil, botonMedio, botonDificil;
	private ButtonGroup bg;
	private VentanaJuego juego;
	
	public PanelOpciones(VentanaJuego juego) {
		this.juego = juego;
		label1 = new JLabel("Tamaño:");
		
		String[] tamaños = new String[] {"3x3", "4x4", "5x5", "6x6", "7x7", "8x8", "9x9", "10x10"};
		menuTamanio = new JComboBox<>(tamaños);
		menuTamanio.addItemListener(this);
        
		label2 = new JLabel("Dificultad:");
		bg = new ButtonGroup();
		
		botonFacil = new JRadioButton("Fácil", true);
		botonFacil.addActionListener(this);        
		bg.add(botonFacil);
		
		botonMedio = new JRadioButton("Medio");
		botonMedio.addActionListener(this);        
		bg.add(botonMedio);
		
		botonDificil = new JRadioButton("Difícil");
		botonDificil.addActionListener(this);        
		bg.add(botonDificil);
		
		add(label1);
		add(menuTamanio);
		add(label2);
		add(botonFacil);
		add(botonMedio);
		add(botonDificil);
		
		FlowLayout fl = new FlowLayout();
		setLayout(fl);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (botonFacil.isSelected()) {
			juego.establecerDificultad(0);
			System.out.print("0");
		}
		if (botonMedio.isSelected()) {
			juego.establecerDificultad(1);
			System.out.print("1");
		}
		if (botonDificil.isSelected()) {
			juego.establecerDificultad(2);
			System.out.print("2");
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource()==menuTamanio) {
            String seleccionado = (String)menuTamanio.getSelectedItem();
			System.out.print(seleccionado.charAt(0));
            juego.establecerTamanio(Integer.valueOf(seleccionado.charAt(0)));
		}
	}
}
