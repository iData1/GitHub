/**
 * @author Samuel Dias da Silva
 * Data: 17.04.2015
 */ 

public class division {
	public static void main(String[] args) {
		divisione(args);
	}

	public static void divisione(String[] args) {
		try {
			int a = Integer.parseInt(args[0]);
			int b = Integer.parseInt(args[1]);

			int c = a/b;

			System.out.println(a + " / " + b + " = " + c);
			
		} 
		catch (NumberFormatException e) {
			System.out.println("Errore: Valore argomenti errato. Prego inserire solo numeri.");
		}
		catch (ArithmeticException e) {
			System.out.println("Errore: Impossibile dividere per 0.");
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Errore: Numero argomenti insufficenti per l'operazione. Necessari: 2.");
		}
	}
}