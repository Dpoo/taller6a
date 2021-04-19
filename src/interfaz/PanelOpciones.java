package interfaz;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class PanelOpciones extends JPanel implements ActionListener, ItemListener{
	
	private JLabel label1, label2;
	private JComboBox<String> menuTamanio;
	private JRadioButton botonFacil, botonMedio, botonDificil;
	private ButtonGroup bg;
	private VentanaJuego juego;
	
	public PanelOpciones(VentanaJuego juego) {
		
		setBackground(new java.awt.Color(51, 184, 255));
		Font font = new Font("Comic Sans MS", Font.BOLD,12);
		
		this.juego = juego;
		label1 = new JLabel("Tamaño:");
		label1.setForeground(new java.awt.Color(255, 255, 255));
		label1.setFont(font);

		
		String[] tamaños = new String[] {"3x3", "4x4", "5x5", "6x6", "7x7", "8x8", "9x9", "10x10"};
		menuTamanio = new JComboBox<>(tamaños);
		menuTamanio.setSelectedIndex(2);
		menuTamanio.addItemListener(this);
		menuTamanio.setFont(font);
        
		label2 = new JLabel("Dificultad:");
		label2.setForeground(new java.awt.Color(255, 255, 255));
		label2.setFont(font);

		bg = new ButtonGroup();
		
		botonFacil = new JRadioButton("Fácil", true);
		botonFacil.setForeground(new java.awt.Color(255, 255, 255));
		botonFacil.setFont(font);
		botonFacil.addActionListener(this);        
		bg.add(botonFacil);
		
		botonMedio = new JRadioButton("Medio");
		botonMedio.setForeground(new java.awt.Color(255, 255, 255));
		botonMedio.setFont(font);
		botonMedio.addActionListener(this);        
		bg.add(botonMedio);
		
		botonDificil = new JRadioButton("Difícil");
		botonDificil.setForeground(new java.awt.Color(255, 255, 255));
		botonDificil.setFont(font);
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
			juego.establecerDificultad(2);
			System.out.print("Escogido = 0\n");
		}
		if (botonMedio.isSelected()) {
			juego.establecerDificultad(10);
			System.out.print("Escogido = 1\n");
		}
		if (botonDificil.isSelected()) {
			juego.establecerDificultad(20);
			System.out.print("Escogido = 2\n");
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource()==menuTamanio) {
            String seleccionado = (String)menuTamanio.getSelectedItem();
            String tamanio = seleccionado.substring(0, 1);
            System.err.print("Escogido = " + tamanio + "\n");
            int tamanioInt = Integer.parseInt(tamanio);
            juego.establecerTamanio(tamanioInt);
		}
	}
}
