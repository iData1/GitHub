public class Exceptions{
    public static void Calculator (String[] args){
        double sum = 0;
        double number = 0;
        double division = 0;
        double numb1 = 0, numb2 = 0;
        double sumDivision = 0;
        /*for(int count2=1;count2<args.length;count2++){
            if(args[count2].equals("/")){
                try{
                    division = Double.parseDouble(args[count2-1])/Double.parseDouble(args[count2+2]);
                }
                catch(NumberFormatException e){
                }
                if(args[count2-2].equals("-") || args[count2+1].equals("-")){
                    sum-=division;
                }
                else if(args[count2-2].equals("+") && args[count2+1].equals("+")){
                    sum+=division;
                }
                
            }
        }*/
        for(int count=1;count<args.length;count++){
                        
            try{
                number = Double.parseDouble(args[count]);
                
            }
            catch(NumberFormatException e){
            }
            if(!(count==1)){
                if(args[count-1].equals("+")){
                    sum+=number;
                }
                else if(args[count-1].equals("-")){
                    sum-=number;
                }
                /*else if(args[count-1].equals("/")){
                    try{
                        division = Double.parseDouble(args[count-1])/Double.parseDouble(args[count+1]);
                    }
                    catch(NumberFormatException e){
                    }
                    if(args[count-2].equals("+") && args[count+2].equals("+")){
                        sum+=division;
                    }
                    else if(args[count-2].equals("-") || args[count+2].equals("-")){
                        sum-=division;
                    }*/
            }
            
        }
        System.out.println("La somma e': "+sum);
    }
            
    
    public static void calculator(String[] args){
        
    }
    public static void everage (String[] args){
        double everage = 0, sum = 0, grade = 0;
        int counter = 0;
        for(int count = 1; count < args.length; count++){
            try{
                grade = Double.parseDouble(args[count]);
                if(grade <= 6 && grade >= 1){
                       sum+= grade;
                       counter++;
                }
            }
            catch(NumberFormatException e){
                if(args[count].equalsIgnoreCase("MI")){
                    sum+=2;
                    counter++;
                }if(args[count].equalsIgnoreCase("I")){
                     sum+=3;
                     counter++;
                }
                if(args[count].equalsIgnoreCase("S")){
                    sum+=4;
                    counter++;
                }
                if(args[count].equalsIgnoreCase("B")){
                    sum+=5;
                    counter++;
                }
                if(args[count].equalsIgnoreCase("MB")){
                    sum+=6;
                    counter++;
                }
            }
        }
        everage = sum / counter;
        System.out.println("La media e': "+everage);
    }
    public static void main(String[] args){
        if(args[0].equalsIgnoreCase("calculator"))Calculator(args);
        else if(args[0].equalsIgnoreCase("average"))everage(args);
    }
}