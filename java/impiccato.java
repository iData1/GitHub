import java.io.*;
public class impiccato {
  public static void impi(String word){
    InputStreamReader Input = new InputStreamReader (System.in);
  	BufferedReader tastiera = new BufferedReader (Input);
  	String testo;
  	boolean ver = false;
  	int lungParola=word.length()-1;
  	byte vite = 10;
  	char[] parola = word.toCharArray();
  	int tentativi = 1;
  	char par = ' ';
  	boolean fuckyou = true;
  	 try{
    	 while(fuckyou == true){
    	  System.out.print("Inserisci lettera: ");
  		  testo = tastiera.readLine();
  		  try{
    		  for(int count = 0; count < parola.length;count++){
    		    par = parola[count];
    		    ver = false;
            if(vite == 0){
    			    System.out.println("Hai perso");
    			    return;
            }
            else if(testo.equalsIgnoreCase(word)){
              ++tentativi;
              System.out.println("Hai vinto dopo: "+tentativi+" tentativi");
              return;
            }
            else if(lungParola==0){
              System.out.println("Hai vinto in: "+tentativi+" tentativi");
              return;
            } 
            else if(testo.charAt(0) == par){
    			    System.out.println("Lettera corretta.");
    			    System.out.println(count+", "+testo.charAt(count));
    			    lungParola--;
    			    tentativi++;
    			    ver = true;
    			    break;
    			  }
    			  else if(ver == false && count==parola.length-1){
    			    System.out.println("Lettera errata.");
    			    --vite;
    			    ++tentativi;
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