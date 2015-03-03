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
		// para calcular la frecuencia fundamental...
		double t=(double) cantidadDeBits/(bitps);
		double frecuenciaFundamental= (double)bitps/(double)cantidadDeBits;
		Integer frecuencia= bitps/cantidadDeBits;
		panelResultados.getResFrecuencia().setText(frecuencia.toString());
		panelResultados.getResFrecuencia().setText(frecuenciaFundamental+"");;
		Senial p= new Senial(bitps, numArmonicos, funcion, frecuenciaFundamental);
		try {
			p.calcularSenial();
			p.exportarFuncion();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//el numero de armónicos lo define  la frecuencia
		
	}
	
	public static double fourier(int f){
		
		double res=0;
		for (int i = 0; i < 1000; i++) {
			res+= (double)Math.pow(f, i)/factorial(i);
		}
		return res;
	}
	public static double factorial(int n){
		if(n==0||n==1){
			return 1;
		}else{
		 return n*factorial(n-1);	
		}
		
	}
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Interfaz v = new Interfaz();
		System.out.println(fourier(1)+"");
		System.out.println(fourier(2)+"");


	}

}
