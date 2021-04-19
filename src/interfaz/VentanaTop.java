package interfaz;

import java.awt.Dialog;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.Window;

import javax.swing.JDialog;
import javax.swing.JFrame;

public class VentanaTop extends JDialog {
	public VentanaTop() {
		setTitle("Top 10");
		setSize(700, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}
