package mundo;


import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.*;
public class Senial {
	
	


	private int bps;
	private int numeroArmonicos;
	private String funcion;
	double frecuenciaFundamental;
	private ArrayList<Double> an;
	private ArrayList<Double> bn;
	private ArrayList<Double> cn;
	private ArrayList<Double> tn;
	private ArrayList<Double> g;
	
	public Senial(int bps, int numeroArmonicos, String funcion, double ff) {
		this.bps = bps;
		this.frecuenciaFundamental=ff;
		this.numeroArmonicos = numeroArmonicos;
		this.funcion = funcion;
		an= new ArrayList<Double>();
		bn =new ArrayList<Double>();
		cn= new ArrayList<Double>();
		tn= new ArrayList<Double>();
		g= new ArrayList<Double>();
		// no he calculado la frecuancia fundamental fourier
	}
	
	public void calcularG(double inicio, double fin, double incremento){
	
		double cantuno=0.0;
		for (int i = 0; i < funcion.length(); i++) {
			if(funcion.charAt(i)=='1'){
				cantuno+=1;
			}
		}
		double constante= (double)cantuno/(double)funcion.length();
		System.out.println("con"+constante);
		// ingresar los datos de 
		for (double i = inicio; i < fin; i+=incremento) {
			// ahora hay que calcular cada uno.
			double resultado=0;
			for (int j = 0; j < an.size(); j++) {
				resultado+=(double) an.get(j)*Math.sin(2*Math.PI*(j+1)*frecuenciaFundamental*i);
				//resultado+= 0.5*cn.get(j);
			}
			for (int j = 0; j < bn.size(); j++) {
				resultado+= (double) bn.get(j)*Math.cos(2*Math.PI*(j+1)*frecuenciaFundamental*i);
				
			}
			resultado+=constante;
			g.add(resultado);
		}
		System.out.println("tam: "+g.size());
		
	}
	
	public boolean calcularSenial()throws Exception{
		//ir leyendo uno a uno cada valor de la función
		
		for (int i = 1; i <= numeroArmonicos; i++) {
			double resultado=0.0;
			double resultadoB=0.0;
			for (int j = 1; j <=funcion.length(); j++) {
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
		calcularG(0.0, 1, 0.001);
		return true;
	}
	
	public void exportarFuncion(){
		PrintWriter writer;
		try {
			writer = new PrintWriter("fourier.csv", "UTF-8");
			writer.println( "sep=;");
			writer.println( " ; y ");
			for (int i = 0; i < g.size(); i++) {
					
					String imprimo= String.valueOf(g.get(i));
					
					String[] vector= imprimo.split("\\.");
					System.out.println("imprimo :" +imprimo+ " l: "+vector.length);
				writer.println( vector[0]+"."+vector[1]+";"+i);
			
			}
			
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(Exception e){
			
		}
		
	}
}
