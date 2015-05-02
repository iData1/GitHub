import java.io.*;
public class mediaIO{
	public static void media(String[] args){
		InputStreamReader Input = new InputStreamReader (System.in);
		BufferedReader tastiera = new BufferedReader (Input);
		String testo = "";
		double num = 0;
		int counter = 0;
		double somma = 0;
		double divisione = 0;
		try{
			while(true){
				try{
					System.out.print("Inserisci nota: ");
					testo = tastiera.readLine();
					num = Double.parseDouble(testo);
					if(num <= 6 && num >= 1){
						somma+=num;
						counter++;
						divisione = somma / counter;
						System.out.println("Media: "+divisione);
					}
				}
				catch(NumberFormatException e){
					if(testo.equalsIgnoreCase("MB")){	
						somma+=6;
						counter++;
						divisione = somma / counter;
						System.out.println("Media: "+divisione);
					}
					else if(testo.equalsIgnoreCase("B")){ 
	          			somma+=5;
						counter++;
						divisione = somma / counter;
						System.out.println("Media: "+divisione);
	        		}
			        else if(testo.equalsIgnoreCase("S")){
			          	somma+=4;
			          	counter++;
						divisione = somma / counter;
						System.out.println("Media: "+divisione);
			        }
			        else if(testo.equalsIgnoreCase("I")){
				        somma+=3;
				        counter++;
						divisione = somma / counter;
						System.out.println("Media: "+divisione);
			        }
			        else if(testo.equalsIgnoreCase("MI")){
						somma+=2;
			          	counter++;
						divisione = somma / counter;
						System.out.println("Media: "+divisione);
			        }
			        else if(testo.equalsIgnoreCase("q")){
			        	return;
			        }	
				}
			}
		}
		catch(IOException e){
			System.out.println("Errore");
		}
		divisione = somma / counter;
		System.out.println("Media: "+divisione);
	}
	public static void main(String[] args){
		media(args);
	}

}