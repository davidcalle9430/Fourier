package interfaz;

import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;

public class PanelResultados extends JPanel implements ActionListener {
    public final static String CALCULAR="calc";
	private Interfaz interfaz;
	private JButton calcular;
	private JTextPane txtAmplitud;
	private JTextField resAmplitud;
	private JTextPane txtFrecuencia;
	private JTextField  resFrecuencia;
	
	public PanelResultados(Interfaz v){
		interfaz=v;
		calcular= new JButton("Calcular");
		calcular.setActionCommand(CALCULAR);
		calcular.addActionListener(this);
		txtAmplitud= new JTextPane();
		txtAmplitud.setEditable(false);
		txtAmplitud.setText("amplitud");
		txtFrecuencia= new JTextPane();
		txtFrecuencia.setEditable(false);
		txtFrecuencia.setText("Frecuencia");
		resAmplitud= new JTextField();
		resAmplitud.setEditable(false);
		resFrecuencia= new JTextField();
		resFrecuencia.setEditable(false);
		
		this.setLayout(new GridLayout(3,2));
		this.setBorder(new TitledBorder("Resultados"));
		
		JTextPane cal= new JTextPane();
		cal.setText(" ");
		this.add(txtAmplitud);
		this.add(resAmplitud);
		this.add(txtFrecuencia);
		this.add(resFrecuencia);
		this.add(cal);
		this.add(calcular);
	
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String comando= e.getActionCommand();
		if(comando.equals(CALCULAR)){
			interfaz.calcular();
			JOptionPane.showMessageDialog(this, "Se ha calculado el resultado");
		}
		
		
	}

	public JButton getCalcular() {
		return calcular;
	}

	public void setCalcular(JButton calcular) {
		this.calcular = calcular;
	}

	public JTextPane getTxtAmplitud() {
		return txtAmplitud;
	}

	public void setTxtAmplitud(JTextPane txtAmplitud) {
		this.txtAmplitud = txtAmplitud;
	}

	public JTextField getResAmplitud() {
		return resAmplitud;
	}

	public void setResAmplitud(JTextField resAmplitud) {
		this.resAmplitud = resAmplitud;
	}

	public JTextPane getTxtFrecuencia() {
		return txtFrecuencia;
	}

	public void setTxtFrecuencia(JTextPane txtFrecuencia) {
		this.txtFrecuencia = txtFrecuencia;
	}

	public JTextField getResFrecuencia() {
		return resFrecuencia;
	}

	public void setResFrecuencia(JTextField resFrecuencia) {
		this.resFrecuencia = resFrecuencia;
	}
}
