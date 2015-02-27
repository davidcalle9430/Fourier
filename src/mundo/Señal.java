package mundo;


import java.util.*;
public class Señal {
	
	


	private int bps;
	private int numeroArmonicos;
	private String funcion;
	double frecuenciaFundamental;
	private ArrayList<Double> an;
	private ArrayList<Double> bn;
	private ArrayList<Double> cn;
	private ArrayList<Double> tn;
	
	public Señal(int bps, int numeroArmonicos, String funcion) {
		this.bps = bps;
		this.numeroArmonicos = numeroArmonicos;
		this.funcion = funcion;
		an= new ArrayList<Double>();
		bn =new ArrayList<Double>();
		cn= new ArrayList<Double>();
		tn= new ArrayList<Double>();
	}
	
	public boolean calcularSeñal()throws Exception{
		//ir leyendo uno a uno cada valor de la función
		
		for (int i = 1; i <= numeroArmonicos; i++) {
			double resultado=0.0;
			double resultadoB=0.0;
			for (int j = 1; j <funcion.length(); j++) {
				if(funcion.charAt(j-1)=='1'){
				double valor= (double)(Math.cos((double)(Math.PI*(j)*i*2)/(double)funcion.length()));
				double valor2=(double)(Math.cos((double)(Math.PI*(j-1)*i*2)/(double)funcion.length()));
				//System.out.println((Math.cos(Math.PI*(j)*i*2)/funcion.length())+"-"+(Math.cos(Math.PI*(j-1)*i*2)/funcion.length()));
				//System.out.println("Se restan "+ valor+ " con "+ valor2);
				double a1= (double)((double)(valor2-valor)/(double)(Math.PI*i));
				resultado+=a1;
				
				
				//b
				double valorb= (double)(Math.sin((Math.PI*(j)*i*2)/funcion.length()));
				double valorb2=(double)(Math.sin((Math.PI*(j-1)*i*2)/funcion.length()));
				//System.out.println((Math.cos(Math.PI*(j)*i*2)/funcion.length())+"-"+(Math.cos(Math.PI*(j-1)*i*2)/funcion.length()));
				//System.out.println("Se restan "+ valor+ " con "+ valor2);
				double b1= (double)(valorb-valorb2)/(Math.PI*i);
				resultadoB+=b1;
				
				
				}
			}
			double c= Math.sqrt(Math.pow(resultado, 2)+ Math.pow(resultadoB, 2));
			double theta=Math.atan(resultadoB/resultado);
			System.out.println(i+". "+resultado+ "  "+ resultadoB+ "  "+ c+ "  "+theta);
			an.add(resultado);
			bn.add(resultadoB);
			cn.add(c);
			tn.add(theta);
		}
		
		return true;
	}
	
	public ArrayList<Double> calcularFuncion(int max, int min){
		ArrayList<Double> resultado= new ArrayList<Double>();
		for (int i = min; i < max; i++) {
			double res= 0.0;
			for(int j=0; j<an.size();j++){
				//falta caluclar la frecuencia fundamental
				//double sin=Math.sin(2*Math.PI*j*);
				//double cos
			}
		}
		
		return null;
	}
	

}
