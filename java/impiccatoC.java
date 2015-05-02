/**
 * @author Samuel Dias da Silva
 * data: 27.04.15
 */

import java.io.*;
public class impiccatoC{
  public static void impiccato(){
    boolean gameOn=true, retry = false, characterTrue = false, character = true;
    aCapo();
    while(gameOn){
      InputStreamReader Input = new InputStreamReader (System.in);
    	BufferedReader tastiera = new BufferedReader (Input);
    	String word = "";
    	System.out.print("Inserisci la parola da indovinare: ");
    	try{
    	  word = tastiera.readLine();
    	}
    	catch(IOException e){
    	}
    	catch(IndexOutOfBoundsException e){
    	}
    	catch(NullPointerException e){
    	  System.out.println("How about NO.");
    	}
    	String hiddenWord = wordSecret(word.length(), '-');
      int volte = 0, lifes = 7, again = 0, volteTrue = 0, volteWrong = 0;
      String wrongAttempts = "";
      String wrongAttemptsWrite = "";
      hangedMan(7-lifes, wrongAttempts, hiddenWord);
    	String testo ="";
      boolean verify = false;
      int attempts = 0;
    	try{
    	  while(true){
    	    aCapo();
    	    hangedMan(7-lifes, wrongAttempts, hiddenWord);
    	    if(again == 0){
    	      again = 1;
    	    }
    	    else if(character == false){
    	      System.out.println("Inserire almeno un carattere.");
    	    }
    	    else if(lifes == 0){
    	      System.out.println("Hai perso. La parola da indovinare era: \""+word+"\"");
    	      System.out.print("Vuoi rigiocare? Y/N: ");
      	    testo=tastiera.readLine();
      	    if(testo.equalsIgnoreCase("N") || testo.equalsIgnoreCase("no"))return;
      	    else if(testo.equalsIgnoreCase("Y") || testo.equalsIgnoreCase("yes")){
      	      lifes = 7;
      	      retry = true;
      	      break;
      	    }
      	    else{ return;}
    	    }
    	    else if(hiddenWord.equals(word) ){
    	      System.out.println("Bravo! Hai vinto!\nParola: \""+hiddenWord+"\"");
    	      System.out.print("Vuoi rigiocare? Y/N: ");
      	    testo=tastiera.readLine();
      	    if(testo.equalsIgnoreCase("N") || testo.equalsIgnoreCase("No"))return;
      	    else if(testo.equalsIgnoreCase("Y") || testo.equalsIgnoreCase("yes")){
      	      lifes = 7;
      	      retry = true;
      	      break;
      	    }
      	    else{ 
      	      return;
      	    }
    	    }
    	    else if(characterTrue == true){
    	      System.out.println("Hai già inserito questa lettera.");
    	      characterTrue=false;
    	    }
    	    else if(verify == true){
    	      System.out.println("Lettera corretta: \""+testo.charAt(0)+"\"");
    	    }
    	    else if(verify == false){
    	      System.out.println("Lettera scorretta: \""+testo.charAt(0)+"\"\nTi rimangono: "+lifes+" tentativi.");
    	    }
    	    //System.out.println("Parola attuale: "+hiddenWord);
    	    System.out.print("Inserisci lettera: ");
    	    testo = tastiera.readLine();
    	    if(testo.length()==0 )character = false;
    	    else if(testo.equals(word)){
    	      System.out.println("Complimenti, hai vinto!");
    	      System.out.print("Vuoi rigiocare? Y/N: ");
      	    testo=tastiera.readLine();
      	    if(testo.equalsIgnoreCase("N") || testo.equalsIgnoreCase("no"))return;
      	    else if(testo.equalsIgnoreCase("Y") || testo.equalsIgnoreCase("yes")){
      	      lifes = 7;
      	      retry = true;
      	      break;
      	    }
        	  else{ 
        	    return;
        	  }
    	    }
    	    aCapo();
          volte = 0;
    	    try{
    	      for(int count = 0; count < word.length(); count++){
    	        if(testo.charAt(0)==word.charAt(count)){
    	          hiddenWord = newSecret(hiddenWord,count, word.charAt(count));
                verify = true;
    	        }
    	        else{
    	          volte++;
    	          if(volte==word.length() && characterTrue==false){
    	            lifes--;
    	            verify = false;
    	            wrongAttempts +="\""+testo.charAt(0)+"\" ";
    	            wrongAttemptsWrite +=testo.charAt(0);
    	            attempts++;
    	          }
    	        }
    	      }
    	    }
    	    catch(NumberFormatException e){
    	    }
    	    catch(IndexOutOfBoundsException e){
    	    }
    	  }
    	}
    	catch(IOException e){
    	}
    	catch(NullPointerException e){
    	  System.out.println("How about NO.");
    	}
    	catch(IndexOutOfBoundsException e){
    	}
    }
  }
  public static String wordSecret(int a, char c){
    String hidden ="";
    for(int count = 0; count < a; count++){
      hidden+=c;
    }
    return hidden;
  }
  public static String newSecret(String hiddenWord, int coordinate, char characterWord){
    String newHidden = "";
    for(int count = 0; count < hiddenWord.length(); count++){
      if(count == coordinate){
        newHidden += characterWord;
      }
      else{
        newHidden += hiddenWord.charAt(count);
      }
    }
    return newHidden;
  }
  public static void aCapo(){
    for(int count = 0; count < 123; count++){
      System.out.println("");
    }
  }
  public static void hangedMan(int errors, String error, String testo){
    String a ="╔═════════════════════════════════════════════════════════════════════╗";
    String b ="║                                                                     ║";
    //String b1 ="║Impiccato creato da: Samuel e Alessandro                             ║";
    String b1 ="║Lettere sbagliate: "+error;
    String c1 ="║Parola attuale:"+testo;
    String d1 ="║                                                                     ║";
    String e1 ="║        ╔════╦════════╗                                              ║";
    String f1 ="║        ╠════╝        ☺                                              ║";
    String g1 ="║        ║            ╔╬╗                                             ║";
    String h1 ="║        ║            ║║║                                             ║";
    String i1 ="║        ║            ╔╩╗                                             ║";
    String l1 ="║        ║            ║ ║                                             ║";
    String m1 ="║        ║                                                            ║";
    String n1 ="║        ║                                                            ║";
    String o1 ="║        ║                                                            ║";
    String p1 ="║        ║                                                            ║";
    String q1 ="║════════╩════════                                                    ║";
    String r ="╚═════════════════════════════════════════════════════════════════════╝";
    String owner = "Programma creato da: Samuel Dias da Silva e Alessandro Colugnat";
    int spaceErr = 71-b1.length();
    for(int count = 0; count < spaceErr; count++){
      if(count == spaceErr-1)b1+="║";
      else b1+=" ";
    }
    int spaceAtt = 71-c1.length();
    for(int count = 0; count < spaceAtt; count++){
      if(count == spaceAtt-1)c1+="║";
      else c1+=" ";
    }
    if(errors==0){
      System.out.println(owner);
      System.out.println(a);
      System.out.println(b1);
      System.out.println(c1);
      for(int count = 0; count < 15; count++){
        System.out.println(b);
      }
      System.out.println(r);
    }
    else if(errors == 1){
      System.out.println(owner);
      System.out.println(a);
      System.out.println(b1);
      System.out.println(c1);
      for(int count = 0; count < 14; count ++){
        System.out.println(b);
      }
      System.out.println(q1);
      System.out.println(r);
    }
    else if(errors == 2){
      System.out.println(owner);
      System.out.println(a);
      System.out.println(b1);
      System.out.println(c1);
      for(int count = 0; count < 4; count ++){
        System.out.println(b);
      }
      for(int count1 = 0; count1 < 9; count1 ++){
        System.out.println(m1); 
      }
      System.out.println(q1);
      System.out.println(r);
    }
    else if(errors == 3){
      System.out.println(owner);
      System.out.println(a);
      System.out.println(b1);
      System.out.println(c1);
      for(int count = 0; count < 3; count ++){
        System.out.println(b);
      }
      System.out.println(e1);
      for(int count1 = 0; count1 < 9; count1 ++){
        System.out.println(m1); 
      }
      System.out.println(q1);
      System.out.println(r);
    }
    else if(errors == 4){
      System.out.println(owner);
      System.out.println(a);
      System.out.println(b1);
      System.out.println(c1);
      for(int count = 0; count < 3; count ++){
        System.out.println(b);
      }
      System.out.println(e1);
      System.out.println(f1);
      for(int count1 = 0; count1 < 8; count1 ++){
        System.out.println(m1); 
      }
      System.out.println(q1);
      System.out.println(r);
    }
    else if(errors == 5){
      System.out.println(owner);
      System.out.println(a);
      System.out.println(b1);
      System.out.println(c1);
      for(int count = 0; count < 3; count ++){
        System.out.println(b);
      }
      System.out.println(e1);
      System.out.println(f1);
      System.out.println(g1);
      for(int count1 = 0; count1 < 7; count1 ++){
        System.out.println(m1); 
      }
      System.out.println(q1);
      System.out.println(r);
    }
    else if(errors == 6){
      System.out.println(owner);
            System.out.println(a);
            System.out.println(b1);
            System.out.println(c1);
      for(int count = 0; count < 3; count ++){
        System.out.println(b);
      }
      System.out.println(e1);
      System.out.println(f1);
      System.out.println(g1);
      System.out.println(h1);
      for(int count1 = 0; count1 < 6; count1 ++){
        System.out.println(m1); 
      }
      System.out.println(q1);
      System.out.println(r);
    }
    else if ( errors == 7 ){
      System.out.println(owner);
      System.out.println(a);
      System.out.println(b1);
      System.out.println(c1);
      for(int count = 0; count < 3; count ++){
        System.out.println(b);
      }
      System.out.println(e1);
      System.out.println(f1);
      System.out.println(g1);
      System.out.println(h1);
      System.out.println(i1);
      System.out.println(l1);
      for(int count1 = 0; count1 < 4; count1 ++){
        System.out.println(m1); 
      }
      System.out.println(q1);
      System.out.println(r);      
    }
  }
  public static void errors(String errors, int error){
    String a = "╔════════╗";
    String b = "║ Errori ║";
    String c = "╠════════╣";
    String d = "║ "+errors+"      ║";
    String e = "╚════════╝";
    for(int count = 0; count <= error; count++){
      if(count == 0){
        if(error == 0){
          System.out.print(a+"\n"+b+"\n"+e+"\n");
        }
        else{
          System.out.print(a+"\n"+b+"\n");
        }
      }
      else if(count < error){
        System.out.print(c+"\n"+d+"\n");
      }
      else if(count == error ){
          System.out.print(c+"\n"+d+"\n"+e+"\n");
        }
    }
  }
  public static void main (String[] args){
      impiccato();
  }
}