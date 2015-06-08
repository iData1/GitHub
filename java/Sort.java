import java.util.Random;

/**
 *
 * @author iData
 */
public class Sort {
	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		if(args.length > 0 && (args[0].equalsIgnoreCase("asco")||args[0].equalsIgnoreCase("desc"))){
			int[] a = new int[10];
			riempimento(a);            
			System.out.print("\nArray con numeri casuali (non ordinato): ");
			print(a);
			sort(a,args[0]);
			System.out.print("\nArray con numeri casuali (ordinato): ");
			print(a);  
		}
		else{
			System.out.println("Inserire un argomento\n\t1.) per ordine decrescente\n\t2.) per ordine Crescente");
		}
	}
	/**
	 * 
	 * @param m array to modify
	 * @param kindOfSort kind of sort (growing or decreasing)
	 */
	public static void sort(int[] m, String kindOfSort){
		boolean sort = false;
		int temp;
		double tempo=System.nanoTime();
		if(kindOfSort.equalsIgnoreCase("1")){
			while(!sort){
				sort=true;
				for(int count = 1; count < m.length; count++){
					if(m[count] < m[count-1]){
						temp = m[count-1];
						m[count-1] = m[count];
						m[count] = temp;
						sort = false;
					}
				}
			}    
		}
		else if(kindOfSort.equalsIgnoreCase("2")){
			while(!sort){
				sort=true;
				for(int count = 1; count < m.length; count++){
					if(m[count] > m[count-1]){
						temp = m[count-1];
						m[count-1] = m[count];
						m[count] = temp;
						sort = false;
					}
				}
			}
		}
		double delta=System.nanoTime()-tempo;
		System.out.println("\n"+delta);
	}
	/**
	 * 
	 * @param m Array to modify
	 */
	public static void riempimento(int[] m){
		Random rnd = new Random();
		for(int count = 0; count < m.length; count++){
			m[count] = rnd.nextInt(15);
		}
	}
	/**
	 * 
	 * @param m array to print
	 */
	public static void print(int[] m){
		//System.out.print("");
		for(int count = 0; count < m.length; count++){
			System.out.print(m[count]+" ");
		}
		System.out.print("\t");
	}

}
