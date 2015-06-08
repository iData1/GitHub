import java.util.Random;
public class SelectionSort{
	public static void selectionSort(int[] array, String kindOfSort){
		double tempo=System.nanoTime();
		int temp;
		boolean ok = true;
		int posizione = 0;
		if(kindOfSort.equalsIgnoreCase("1")){
			for(int count = 0; count < array.length; count++){
				ok = true;
				int num = array[count];
				for(int count2=count; count2 < array.length; count2++){
					if(num < array[count2]){
						num=array[count2];
						posizione = count2;
						ok = false;
					}
				}
				if(ok == false){
					temp = array[count];
					array[count] = array[posizione];
					array[posizione]=temp;
				}
			}
		}
		else if(kindOfSort.equalsIgnoreCase("2")){

			for(int count = 0; count < array.length; count++){
				ok = true;
				int num = array[count];
				for(int count2=count; count2 < array.length; count2++){
					if(num > array[count2]){
						num=array[count2];
						posizione = count2;
						ok = false;
					}
				}
				if(ok == false){
					temp = array[count];
					array[count] = array[posizione];
					array[posizione]=temp;
				}
			}
		}
		double tempo2 = System.nanoTime();
		print(array);		
		double delta = tempo2-tempo;
		System.out.println("\nTempo sort: "+delta);
	}
	public static void main(String[] args){
		if(args.length > 0 && (args[0].equalsIgnoreCase("1")||args[0].equalsIgnoreCase("2"))){
			//double tempo=System.nanoTime();
			int[] a = new int[100000];
			riempimento(a);
			System.out.print("\nArray con numeri casuali (non ordinato): ");
			print(a);
			System.out.print("\nArray con numeri casuali (ordinato): ");
			selectionSort(a , args[0]);
			double tempo=System.nanoTime();
			int posizione = binarySearch(a,10);
			double delta = System.nanoTime() -tempo;
			System.out.println("\n\n\nPosizione: "+posizione);
			
			System.out.println("\nTempo main: "+delta);
		}
		else{
			System.out.println("Inserire un argomento\n\t1.) per ordine decrescente\n\t2.) per ordine crescente");
		}
	}
	public static void riempimento(int[] m){
		Random rnd = new Random();
		for(int count = 0; count < m.length; count++){
			m[count] =(int) (math.Random*10);
		}
	}
	public static void print(int[] m){
		for(int count = 0; count < m.length; count++){
			System.out.print(m[count]+" ");
		}
		System.out.print("\t");
	}
	public static int binarySearch(int[] m, int num){
		double tempo = System.nanoTime();
		boolean found = false;
		int min = 0;
		int max = m.length-1;
		int medio;
		int temp=m.length+1;
		int posizione = -1;
		if(num > m[max] || num < m[min]){
			found = true;
		}
		while(!found){
			medio = (int) ((min + max) / 2);
			
			if(m[medio]==num){
				posizione = medio;
				found = true;
			}
			else if(medio==temp){
				found=true;
				posizione=-1;
			}
			else if(num<m[medio]){
				max = medio;
			}
			else if(num>m[medio]){
				min = medio;
			}
			temp=medio;
		}
		double tempo2 = System.nanoTime();
		double delta = tempo2-tempo;
		System.out.println("\nTempo binary search: "+delta);
		return posizione;
	}
}
