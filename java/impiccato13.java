import java.util.Arrays;
import java.io.*;
public class impiccato1 {
  public static void impi(String word){
    InputStreamReader Input = new InputStreamReader (System.in);
  	BufferedReader tastiera = new BufferedReader (Input);
  	
  	
  	String testo;
  	boolean ver = false;
  	int lungParola=word.length();
  	byte vite = 10;
  	char[] parola = word.toCharArray();
  	int tentativi = 1;
  	char par = ' ';
  	char[] wording = word.toCharArray();
  	
  	
  	for(int a = 0; a < word.length();a++){
  	  wording[a]='_';
  	}
  	
  	 try{
    	 while(true){
    	  System.out.print("Lettera corretta: ");
        System.out.println(wording);
    	  tentativi = 0;
    	  if(Arrays.equals(wording, parola)){
    		    System.out.println("Hai vinto!");
    		    return;
    		   }
    	  System.out.print("Inserisci lettera: ");
  		  testo = tastiera.readLine();
  		  try{
    		  for(int count = 0; count < parola.length;count++){
    		    par = parola[count];
    		    ver = false;
    		    if(vite==0){
    		      System.out.println("Hai perso.");
    		      return;
    		    }
            else if(testo.charAt(0)==par){
              ver = true;
              tentativi++;
              lungParola--;
              wording[count] = testo.charAt(0);
              
              
            }
            else if(ver == false && tentativi == 0){
              System.out.println("Lettera sbagliata");
              tentativi++;
              vite--;
              
            }
    			}
  		  }
  		  catch(IndexOutOfBoundsException e){
		    }
  	  }
		}
		catch(IOException e){
			System.out.println(e.getMessage());
		}
  }
  public static void main(String[] args){
    String parola = args[0];
    impi(parola);
  }
}