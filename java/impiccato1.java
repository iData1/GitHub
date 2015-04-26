import java.util.Arrays;
import java.io.*;
public class impiccato1 {
  public static void impi(String word){
    InputStreamReader Input = new InputStreamReader (System.in);
  	BufferedReader tastiera = new BufferedReader (Input);
  	String testo;
  	boolean ver = false;
  	int lungParola=word.length();
  	byte vite = 8;
  	char[] parola = word.toCharArray();
  	int tentativi = 1;
  	char par = ' ';
  	char[] wording = word.toCharArray();
  	int possibilita = 0;
  	int volte = 0;
  	for(int a = 0; a < word.length();a++){
  	  wording[a]='_';
  	}
  	 try{
    	 while(true){
    	  if(volte==0){
    	    volte=1;
    	  }
    	  else if(volte>1){
    	    System.out.print("Lettera corretta: ");
          System.out.println(wording);
          volte=1;
    	  }
    	  else if(volte==1){
    	    System.out.println("Lettera sbagliata.");
    	    System.out.println("Hai ancora: "+vite+" possibilita'");
    	  }
    	  //tentativi = 0;
    	  if(Arrays.equals(wording, parola)){
    		    System.out.println("Hai vinto!");
    		    System.out.print("Parola: ");
    		    System.out.println(wording);
    		    return;
    		   }
    	  System.out.print("Inserisci lettera: ");
  		  testo = tastiera.readLine();
  		  try{
  		    if(testo.equalsIgnoreCase(word)){
  		      System.out.println("Hai vinto!");
  		      return;
  		    }
    		  for(int count = 0; count < parola.length;count++){
    		    tentativi=0;
    		    par = parola[count];
    		    ver = false;
    		    if(vite==1){
    		      System.out.println("Hai perso.");
    		      System.out.print("La parola era: ");
    		      System.out.print("\"");
    		      System.out.print(parola);
    		      System.out.println("\"");
    		      return;
    		    }
    		    
            else if(testo.charAt(0)==par){
              ver = true;
              tentativi++;
              lungParola--;
              wording[count] = testo.charAt(0);
              volte++;
            }
            else if(ver == false && tentativi == 0){
              possibilita++;
              tentativi++;
              if(possibilita==parola.length){
                vite--;
                possibilita=0;
              }
              
            }
    			}
  		  }
  		  catch(IndexOutOfBoundsException e){
  		    vite--;
		    }
  	  }
		}
		catch(IOException e){
			System.out.println(e.getMessage());
		}
		catch(ArrayIndexOutOfBoundsException e){
		  System.out.println("Scrivere la parola come argomento.");
		}
  }
  public static void main(String[] args){
    if(args.length==0){
      System.out.println("inserire un argomento.");
    }
    else{
    String parola = args[0];
    impi(parola);
    }
  }
}