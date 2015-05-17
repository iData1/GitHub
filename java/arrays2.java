import java.util.Random;
/**
 *	@author Samuel Dias da Silva
 *	Data 14.05.2015
 */
public class arrays2{
	/**
	 *	Crea un array di lunghezza random, e lo riempe con un numero random tra 1 e lunghezza dell'array ( random )
	 *	Cerca il numero maggiore e il numero minore, e la loro rispettiva posizione.
	 */
	public static void arrayRip(){
		Random rnd = new Random();
		int numeroRandom = rnd.nextInt(1000);
		if(numeroRandom <= 0){
			numeroRandom=numeroRandom+(-2*numeroRandom);
		}
		int[] primo = new int[numeroRandom];
		int counter1 = 0;
		boolean verifica = false;
		int numero = 0;
		int max = 0, posizione = 0, min = 0;
		System.out.println("");
		for(int count = 0; count < primo.length; count++){
			while(verifica == false){
				numero = rnd.nextInt(numeroRandom+1);
				counter1 = 0;
				for(int count1 = 0; count1 < primo.length; count1++){
					if(numero!=primo[count1]){
						counter1++;
						if(counter1 == primo.length) verifica = true;
					}
				}
			}
			verifica = false;
			primo[count]=numero;
		}
		System.out.print("Array casuale senza doppioni: \n\n");
		for(int a = 0; a < primo.length; a++){
			System.out.print(primo[a]+" ");
		}
		for(int count = 0; count < primo.length; count++){
			if(primo[count] > max){
				max = primo[count];
				posizione = count;
			}
		}
		min = max;
		System.out.println("\n\nNumero piu' grande: "+max+"\nPosizione: "+posizione);

		for(int count = 0; count < primo.length; count++){
			if(primo[count] < min){
				min = primo[count];
				posizione = count;
			}
		}
		System.out.println("\nNumero piu' piccolo: "+min+"\nPosizione: "+posizione);
		System.out.println("\nLunghezza array: "+primo.length);	
	}
	/**
	 * 	Crea un array di lunghezza 100, e lo riempe con numeri da 0 a 99
	 */
	public static void esercizio1(){
		int[] a = new int[100];
		for(int i = 0; i < a.length; i++){
			a[i] = i;
		}
		System.out.print("\n");
		for(int count = 0; count < a.length; count++){
			System.out.print(a[count]+" ");
		}
	}
	/**
	 *	Crea un array di tipo short, e lo riempo
	 */
	public static void esercizio2(){
		short[] a = {5, 2, 9, 1, 12};
		for(int count = 0; count < a.length; count++){
			System.out.print(a[count]+" ");
		}
	}
	/**
	 * 	Crea un array bidimensionale di grandezza [3] (righe) e [6] (colonne)
	 */
	public static void esercizio3(){
		int[][] a = new int[3][6];
		int b = 0;
		for(int count = 0; count < a.length;count++){
			for(int count2 = 0; count2 < a[count].length; count2++){
				a[count][count2]=b++;

			}
		}
		System.out.println("");
		for(int count = 0; count < a.length;count++){
			for(int count2 = 0; count2 < a[count].length; count2++){
				if(count2!=a[count].length-1) System.out.print(a[count][count2]+" ");
				else System.out.println(a[count][count2]+" ");
			}
		}		
	}
	/**
	 * 	Crea un array bidimensionale
	 */
	public static void esercizio4(){
		int[][] a = {{6,21,3},{9,4,1}};
		for(int count = 0; count < a.length;count++){
			for(int count2 = 0; count2 < a[count].length; count2++){
				if(count2!=a[count].length-1) System.out.print(a[count][count2]+" ");
				else System.out.println(a[count][count2]+" ");
			}
		}
	}
	/**
	 * 	Crea un array di dimensione 6, e lo riempe con numeri casuali
	 */ 
	public static void esercizio5(){
		Random rnd = new Random();
		int[] arrayRandom = new int[6];
		for(int count = 0; count < arrayRandom.length; count++){
			int nRandom = rnd.nextInt(45);
			arrayRandom[count] = nRandom+1;
		}
		for(int count = 0; count < arrayRandom.length; count++){
			System.out.print(arrayRandom[count]+" ");
		}
	}
	/**
	 *
	 * 	Crea un array di grandezza casuale, e lo riempe con numeri casuali
	 * 	Crea un secondo array che esegue copia il primo array, e dopo lo copia al contrario
	 * 	esempio: primo array = 123
	 * 		 secondo array = 12321
	 */
	public static void simmetria(){
		Random rnd = new Random();
		int numeroRandom = 1 + rnd.nextInt(10);
		if(numeroRandom<=0){
			numeroRandom=numeroRandom+(-2*numeroRandom);
		}
		int[] primo = new int[numeroRandom];
		int[] secondo = new int[primo.length*2-1];
		int lunghezzaPrimo = primo.length;
		int lunghezzaSecondo = secondo.length-1;
		int count = 0;
		for(count = 0; count < primo.length; count++){
			primo[count]=(int)(Math.random()*10);
		}
		for(int count1 = 0; count1 < primo.length; count1++){
			secondo[count1]=primo[count1];
		}
		int a = 0;
		for(int count1 = count-1; count1 < secondo.length; count1++){
			a = lunghezzaSecondo - count1;
			secondo[count1] = secondo[a];
		}
		System.out.print("Primo array:\t");
		for(count = 0; count < primo.length; count++){
			System.out.print(primo[count]+" ");
		}
		System.out.println("");
		System.out.print("Secondo array:\t");
		for(count = 0; count < secondo.length; count++){
			System.out.print(secondo[count]+" ");
		}
		System.out.println("");
	}
	/**
	 * 	Crea un array di lunghezza random, con numeri random
	 *	Crea un secondo array con gli stessi numeri del primo, ma ordinati
	 */ 
	public static void sorting(){
		Random rnd = new Random();
		int[] primo = new int[rnd.nextInt(10)];
		int[] ordinato = new int[primo.length];	
		int max = 0;
		for(int count = 0; count < primo.length; count++){
			primo[count] = rnd.nextInt(primo.length+10);
		}
		for(int count = 0; count < primo.length; count++){
			if(primo[count] > max)max=primo[count];
		}		
		System.out.print("\n");
		for(int count = 0; count < ordinato.length; count++){
			System.out.print(primo[count]+" ");
		}
		int uno = 0;
		for(; max >= 0 ; max--){
			for(int count = 0; count < primo.length; count++){
				if( primo[count] == max ) {
					ordinato[uno]= primo[count];
					uno++;
				}
			}
		}
		System.out.print("\n");
		for(int count = 0; count < ordinato.length; count++){
			System.out.print(ordinato[count]+" ");
		}
	}
	/**
	 * 	Esegue tutti i metodi
	 */
	public static void main(String[] args){
		arrayRip();
		System.out.println("\n\nEsercizio 1\n");
		esercizio1();
		System.out.println("\n\nEsercizio 2\n");
		esercizio2();
		System.out.println("\n\nEsercizio 3\n");
		esercizio3();	
		System.out.println("\nEsercizio 4\n");
		esercizio4();
		System.out.println("\nEsercizio 5\n");
		esercizio5();
		System.out.println("\n\nSimmetria\n");
		simmetria();
		System.out.println("\n\nNumeri ordinati\n");
		sorting();
	}
}
