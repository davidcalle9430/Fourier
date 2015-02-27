package interfaz;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

import mundo.Senial;



public class Interfaz extends JFrame{
	
	private PanelDatos panelDatos;
	private PanelResultados panelResultados;
	public Interfaz(){
		panelDatos= new PanelDatos(this);
		panelResultados= new PanelResultados(this);
		
		this.setVisible(true);
		this.setSize(new Dimension(400,300));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Análisis de Fourier");
		this.setLayout(new BorderLayout());
		this.add(panelDatos, BorderLayout.CENTER);
		this.add(panelResultados, BorderLayout.SOUTH);
		
		
	}
	
	public void calcular(){
		String funcion= panelDatos.getFuncion().getText();
		String bps= panelDatos.getBps().getText();
		String n = panelDatos.getNumArmonicos().getText();
		Integer cantidadDeBits= funcion.length();
		Integer bitps= Integer.parseInt(bps);
		Integer numArmonicos= Integer.parseInt(n);
		
		Integer frecuencia= bitps/cantidadDeBits;
		panelResultados.getResFrecuencia().setText(frecuencia.toString());
		Senial p= new Senial(bitps, numArmonicos, funcion);
		try {
			p.calcularSenial();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//el numero de armónicos lo define  la frecuencia
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Interfaz v = new Interfaz();
		

	}

}
