/**
 * @author Samuel Dias da Silva
 * data: 27.04.15
 */
import java.io.*;

public class impiccatoC1{
  
  public static void impiccato(){
    boolean gameOn=true, retry = false, characterTrue = false, character = true;
    clean();
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
        clean();
      }
      String hiddenWord = wordSecret(word.length(), '-');
      int volte = 0, lifes = 7, again = 0, volteTrue = 0, volteWrong = 0, countRetry = 0, counterDouble1 = 0, counterDouble2 = 0;
      String wrongAttempts = "";
      String rightAttempts = "";
      String lettere = "";
      String right = "";
      String wrong = "";
      String wrongAttemptsWrite = "";
      hangedMan(7-lifes, lifes, wrongAttempts, hiddenWord);
      String testo ="";
      boolean verify = false;
      int attempts = 0;
      try{
        while(true){
          if(lifes < 0){
            lifes = 0;
          }
          clean();
          hangedMan(7-lifes, lifes, wrongAttempts, hiddenWord);
          if(again == 0){
            again = 1;
          }
          else if(character == false){
            System.out.println("Inserire almeno un carattere.");
            character = true;
          }
          else if(lifes <= 0){
            while(!retry){
              if(countRetry==0){
                System.out.println("GG Scrub!");
                countRetry = 1;
              }
              System.out.print("Vuoi rigiocare? Y/N: ");
              testo=tastiera.readLine();
              if(testo.equalsIgnoreCase("N") || testo.equalsIgnoreCase("no"))return;
              else if(testo.equalsIgnoreCase("Y") || testo.equalsIgnoreCase("yes")){
                lifes = 7;
                retry = true;
                clean();
              }
              else{
                System.out.println("Inserisci un carattere valido.");
              }
            }
            retry = false;
            countRetry=0;
            clean();
            break;
          }
          else if(hiddenWord.equals(word)){
            while(!retry){
              if(countRetry==0){
                System.out.println("Complimenti, hai vinto!");
                countRetry = 1;
              }
              System.out.print("Vuoi rigiocare? Y/N: ");
              testo=tastiera.readLine();
              if(testo.equalsIgnoreCase("N") || testo.equalsIgnoreCase("no"))return;
              else if(testo.equalsIgnoreCase("Y") || testo.equalsIgnoreCase("yes")){
                lifes = 7;
                retry = true;
                clean();
              }
              else{
                System.out.println("Inserisci un carattere valido.");
              }
            }
            retry = false;
            countRetry=0;
            clean();
            break;
          }
          else if(characterTrue == true){
            System.out.println("Hai già inserito questa lettera.");
            characterTrue=false;
          }
          else if(verify == true){
            System.out.println("Lettera/e corretta/e: "+right);
          }
          else if(verify == false){
            System.out.println("Lettera/e scorretta/e: "+lettere);
          }
          lettere = "";
          right = "";
          System.out.print("Inserisci lettere: ");
          testo = tastiera.readLine();
          if(testo.length()==0 )character = false;
          else if(testo.equals(word)){
            while(!retry){
              if(countRetry==0){
                System.out.println("Complimenti, hai vinto!");
                countRetry = 1;
              }
              System.out.print("Vuoi rigiocare? Y/N: ");
              testo=tastiera.readLine();
              if(testo.equalsIgnoreCase("N") || testo.equalsIgnoreCase("no"))return;
              else if(testo.equalsIgnoreCase("Y") || testo.equalsIgnoreCase("yes")){
                lifes = 7;
                retry = true;
                clean();
              }
              else{
                System.out.println("Inserisci un carattere valido.");
              }
            }
            retry = false;
            countRetry=0;
            clean();
            break;
          }
          try{
            for(int count2 = 0; count2 < testo.length(); count2++ ){
              if(lifes == 0) break;
              else if(testo.charAt(count2)==' ')continue;
              volte=0;
              for(int count = 0; count < rightAttempts.length(); count++ ){
                if(rightAttempts.charAt(count)==testo.charAt(count2)){
                  characterTrue=true;
                  counterDouble1++;
                }
              }
              for(int count1=0; count1 < wrongAttemptsWrite.length(); count1++ ){
                if(wrongAttemptsWrite.charAt(count1)==testo.charAt(count2) ){
                  characterTrue=true;
                  counterDouble2++;
                }
              }
              if(characterTrue==true){
                characterTrue=false;
                continue;
              }
              for(int count = 0; count < word.length(); count++){
                if(testo.charAt(count2)==word.charAt(count)){
                  hiddenWord = newSecret(hiddenWord,count, word.charAt(count));
                  verify = true;
                  rightAttempts+=testo.charAt(count2);
                  right+="\""+testo.charAt(count2)+"\""+" ";
                }
                else{
                  volte++;
                  if(volte==word.length()){
                    lifes--;
                    verify = false;
                    wrongAttempts +="\""+testo.charAt(count2)+"\" ";
                    wrongAttemptsWrite +=testo.charAt(count2);
                    attempts++;
                    lettere+="\""+testo.charAt(count2)+"\" ";
                  }
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
        clean();
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
  public static void clean(){
    for(int count = 0; count < 123; count++){
      System.out.println("");
    }
  }
  public static void hangedMan(int errors,int attempts, String error, String testo){
    String a ="╔═════════════════════════════════════════════════════════════════════╗";
    String b ="║                                                                     ║";
    String b1 ="║Lettere sbagliate: "+error;
    String c1 ="║Parola attuale: "+testo;
    String d1 ="║Vite: "+attempts;
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
    String q1 ="╠════════╩════════                                                    ║";
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
    int spaceTenta = 71-d1.length();
    for(int count = 0; count < spaceTenta; count++){
      if(count == spaceTenta-1)d1+="║";
      else d1+=" ";
    }
    if(errors==0){
      System.out.println(owner);
      System.out.println(a);
      System.out.println(b1);
      System.out.println(c1);
      System.out.println(d1);
      for(int count = 0; count < 14; count++){
        System.out.println(b);
      }
      System.out.println(r);
    }
    else if(errors == 1){
      System.out.println(owner);
      System.out.println(a);
      System.out.println(b1);
      System.out.println(c1);
      System.out.println(d1);
      for(int count = 0; count < 13; count ++){
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
      System.out.println(d1);
      for(int count = 0; count < 3; count ++){
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
      System.out.println(d1);
      for(int count = 0; count < 2; count ++){
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
      System.out.println(d1);
      for(int count = 0; count < 2; count ++){
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
      System.out.println(d1);
      for(int count = 0; count < 2; count ++){
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
      System.out.println(d1);
      for(int count = 0; count < 2; count ++){
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
    else if ( errors >= 7 ){
      
      System.out.println(owner);
      System.out.println(a);
      System.out.println(b1);
      System.out.println(c1);
      System.out.println(d1);
      for(int count = 0; count < 2; count ++){
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
  /**
   * Crea una tabella con gli errori fatti.
   * @param String errori, 
   */
    public static void errors(String errors, int error){
      char f = ' ';
      String a = "╔════════╗";
      String b = "║ Errori ║";
      String c = "╠════════╣";
      String d = "║";
      String e = "╚════════╝";
      if(error == 0){
       System.out.print(a+"\n"+b+"\n"+e+"\n"); 
      }
      else if(error > 0){ 
        System.out.print(a+"\n"+b+"\n");
        for(int count = 0; count < error; count++){
          f = errors.charAt(count);
          if(count == error-1){
            d+=count+1+".) "+f;
            int spaceErr = 10-d.length();
            for(int count1 = 0; count1 <= spaceErr; count1++){
              if(count1 == spaceErr-1)d+="║";
              else d+=" ";
            }
            System.out.print(c+"\n"+d+"\n"+e+"\n");
          }
          else if(count < error){
            d+=count+1+".) "+f;
            int spaceErr = 10-d.length();
            for(int count1 = 0; count1 <= spaceErr; count1++){
              if(count1 == spaceErr-1)d+="║";
              else d+=" ";
            }
            System.out.print(c+"\n"+d+"\n");
            d="║";
          }
        }
      }
    }
  public static void main (String[] args){
      try{
        impiccato();
      }
      catch(NullPointerException e){
        System.out.println("How about NO.");
      }
  }
}