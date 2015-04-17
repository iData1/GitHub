public class Exceptions{
    public static void Calculator (String[] args){
        double sum = 0;
        double number = 0;
        for(int count=0;count<args.length;count++){
            try{
                number = Double.parseDouble(args[count]);
                
            }
            catch(NumberFormatException e){
            }
            if(!(count==0)){
                if(args[count-1].equals("+")){
                    sum+=number;
                }
                else if(args[count-1].equals("-")){
                    sum-=number;
                }
            }
        }
        System.out.println(sum);
    }
    public static void everage (String[] args){
        double everage = 0, sum = 0, grade = 0;
        //double grade = 0;
        int counter = 0;
        for(int count = 0; count < args.length; count++){
            try{
                grade = Double.parseDouble(args[count]);
                if(grade < 6 && grade > 1){
                    
                }
            }
            catch(NumberFormatException e){
                
            }
        }
    }
    public static void main(String[] args){
        Calculator(args);
    }
}