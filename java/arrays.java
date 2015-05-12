import java.util.Random;
public class arrays{
  public static void simmetria(){
    Random rnd = new Random();
    int numeroRandom = rnd.nextInt(10);
    int[] primo = new int[numeroRandom];
    int[] secondo = new int[primo.length*2];
    int lunghezzaPrimo = primo.length;
    int lunghezzaSecondo = secondo.length-1;
    int count = 0;
    for(count = 0; count < primo.length; count++){
      primo[count]=(int)(Math.random()*10);
    }
    for(int count1 = 0; count1 < primo.length; count1++){
      secondo[count1]=primo[count1];
    }
    for(int count1 = count; count1 < secondo.length; count1++){
      int a = lunghezzaSecondo - count1;
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
  public static void arrayRip(){
    Random rnd = new Random();
    int numeroRandom = rnd.nextInt(15);
    int[] primo = new int[numeroRandom];
    int posizione = 0, counter1 = 0, counter2 = 0, counter3 = 0;
    boolean verifica = false, attempt = false, numberControl = false;
    int numero = 0;
    while(verifica == false){
      counter1 = 0;
      for(int count = 0; count < primo.length; count++){
        primo[count] = rnd.nextInt(numeroRandom);
      }
      for(int count = 0; count < primo.length; count++){
        for(int count1 = 0; count1 < primo.length; count1++){
          if((primo[count]==primo[count1])){
            counter1++;
          }
        }
      }
      if(counter1 == primo.length){
        verifica = true;
      }
    }
    System.out.print("Array casuale senza doppioni: ");
    for(int a = 0; a < primo.length; a++){
      System.out.print(primo[a]+" ");
    }
  }
  public static void main(String[] args){
    simmetria();
    arrayRip();
  }
}