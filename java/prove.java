import java.util.Arrays;
public class prove{
  public static void prova1(String[] args){
    char[] a = {'a', 'b', 'c'};
    char[] b = {'a', 'b', 'c'};
    if(a == b){
      System.out.println("True");
    }
    else{
      System.out.println("False");
    }
  }
  public static void prova2(String[] args){
    char[] a ={'a'};
    String b = a.toString();
    System.out.println(b);
  }
    public static void prova3(String[] args){
      String a ="Io sono samuel";
      char[] b = a.toCharArray();
      
      System.out.println(b);
    }
    public static void prova4(String[] args){
      char[] a = {'a', 'b', 'c'};
      char b = 'a';
      a[0] = 'b';
      System.out.println(a);
    }
    public static void prova5(String[] args){
      String b = args[0];
      char[] arrayChar=b.toCharArray();
      for(int a = 0; a < arrayChar.length;a++){
        arrayChar[a]='*';
      }
      System.out.println(arrayChar);
    }
    public static void prova6(String[] args){
    char[] a = {'a', 'b', 'c'};
    char[] b = {'a', 'b', 'c'};
    if(Arrays.equals(a, b)){
      System.out.println("True");
    }
    else{
      System.out.println("False");
    }
  }
  
 
  public static void main (String[] args){
    prova6(args);
  }
}