import java.io.*;
public class matrici{
  public static void main (String[] args){
    int[][] matrici = new int[3][3];
    int[] array = new int[3];
    InputStreamReader Input = new InputStreamReader (System.in);
  	BufferedReader tastiera = new BufferedReader (Input);
    int num = 0;
    String testo;
    try{
      while(true){
        System.out.print("Array monodim: \n");
       
        for(int count = 0; count < 3; count++){
          System.out.print("Inserire numero: ");
           testo = tastiera.readLine();
           num = Integer.parseInt(testo);
           array[count] = num;
        }
        System.out.print("Array monodimensionale: \n");
        for(int count = 0; count < array.length; count++){
          System.out.print(array[count]+" - ");
        }
        System.out.println("\nArray bidimensionale: ");
       
       for(int riga = 0; riga < 3; riga++){
        for(int col = 0; col < 3; col++){
          System.out.print("Inserire numero: ");
           testo = tastiera.readLine();
           num = Integer.parseInt(testo);
           matrici[riga][col] = num;
        }
       }
       System.out.println("Array bidimensionale: ");
       for(int riga = 0; riga < 3; riga++){
        for(int col = 0; col < 3; col++){
          if(col == 0){
            System.out.print(matrici[riga][col]);
          }
          else{
            System.out.print(" - "+matrici[riga][col]);
          }
        }
        System.out.println("");
       }
    }
    
  }
  catch(IOException e){
      
  }
  
}
}