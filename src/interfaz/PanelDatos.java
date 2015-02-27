package interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.accessibility.Accessible;
import javax.swing.Action;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;

public class PanelDatos extends JPanel {

	private JTextField funcion;
	private JTextField bps;
	private JTextField numArmonicos;
	private JTextPane txtFuncion;
	private JTextPane txtBps;
	private JTextPane txtNumArmonicos;
	private Interfaz interfaz;
	public PanelDatos(Interfaz v){
		this.setLayout(new GridLayout(3,2));
		this.setBorder(new TitledBorder("Ingresar los datos"));
		
		
	    interfaz=v;
		funcion= new JTextField();
		bps= new JTextField();
		numArmonicos= new JTextField();
		txtBps= new JTextPane();
		txtBps.setEditable(false);
		txtFuncion= new JTextPane();
		txtNumArmonicos= new JTextPane();
		txtNumArmonicos.setEditable(false);
		txtBps.setText("BPS:");
		txtFuncion.setText("g(t):");
		txtFuncion.setEditable(false);
		txtNumArmonicos.setText("Num Armónicos:");
		
	
		this.add(txtFuncion);
		this.add(funcion);
		this.add(txtBps);
		this.add(bps);
		this.add(txtNumArmonicos);
		this.add(numArmonicos);
	
	}
	public JTextField getFuncion() {
		return funcion;
	}
	public void setFuncion(JTextField funcion) {
		this.funcion = funcion;
	}
	public JTextField getBps() {
		return bps;
	}
	public void setBps(JTextField bps) {
		this.bps = bps;
	}
	public JTextField getNumArmonicos() {
		return numArmonicos;
	}
	public void setNumArmonicos(JTextField numArmonicos) {
		this.numArmonicos = numArmonicos;
	}
	public JTextPane getTxtFuncion() {
		return txtFuncion;
	}
	public void setTxtFuncion(JTextPane txtFuncion) {
		this.txtFuncion = txtFuncion;
	}
	public JTextPane getTxtBps() {
		return txtBps;
	}
	public void setTxtBps(JTextPane txtBps) {
		this.txtBps = txtBps;
	}
	public JTextPane getTxtNumArmonicos() {
		return txtNumArmonicos;
	}
	public void setTxtNumArmonicos(JTextPane txtNumArmonicos) {
		this.txtNumArmonicos = txtNumArmonicos;
	}

	


}
