import java.io.*;
public class Esercizio1A{
	public static int chiediIntero(int min, int max){
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int numero = 0;
		String numeroIn = "";
		boolean verificaInput = true, verificaOutput = true;
		while(verificaInput){
			try{
				System.out.print("Inserisci un numero compreso tra: ["+min+" e "+max+"[  ");
				numeroIn = in.readLine();
				numero=Integer.parseInt(numeroIn);
				if(numero >= min && numero < max) verificaInput=false;
				else if(numero >= max) System.out.println("Valore troppo grande "+numero);
				else if(numero < min) System.out.println("Valore troppo piccolo "+numero);
			}
			catch(IOException e){
				max++;
				return max;
			}
			catch(NumberFormatException e){
				System.out.println("Valore non accettabile " +"\""+numeroIn+"\"");
			}
		}
		return numero;
	}
	public static void main(String[] args){
		int numero1 = chiediIntero(-10,10);
		int numero2 = chiediIntero(25,50);
		int numero3 = chiediIntero(-1,2);
		int somma = numero1 + numero2 + numero3;
		System.out.println("Somma: "+numero1+" + "+numero2+" + "+numero3+" = "+somma);
	}
}	
